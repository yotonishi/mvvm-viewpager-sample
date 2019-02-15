package com.otonishi.example.mvvmviewpager.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.otonishi.example.mvvmviewpager.R
import com.otonishi.example.mvvmviewpager.adapters.PagerAdapter
import com.otonishi.example.mvvmviewpager.extensions.setupActionBar
import com.otonishi.example.mvvmviewpager.fragments.PageOneFragment
import com.otonishi.example.mvvmviewpager.fragments.PageTwoFragment
import com.otonishi.example.mvvmviewpager.navigators.ViewPagerNavigator
import com.otonishi.example.mvvmviewpager.viewmodels.ViewPagerViewModel
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity(), ViewPagerNavigator {

    private val viewModel by lazy {
        ViewPagerViewModel(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        viewModel.apply {
            setNavigator(this@ViewPagerActivity)
        }

        setupActionBar(R.id.toolbar) {
            title = "Input Data"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        setViewPager()
    }

    private fun setViewPager() {
        val pageOneFragment = PageOneFragment.newInstance().apply {
            setViewModel(this@ViewPagerActivity.viewModel)
        }

        val pageTwoFragment = PageTwoFragment.newInstance().apply {
            setViewModel(this@ViewPagerActivity.viewModel)
        }

        ly_view_pager.adapter = PagerAdapter(
            supportFragmentManager,
            listOf(pageOneFragment, pageTwoFragment)
        )
    }

    override fun onDestroy() {
        viewModel.onActivityDestroyed()
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (ly_view_pager.currentItem == 0) {
            finish()
        } else {
            ly_view_pager.setCurrentItem(ly_view_pager.currentItem - 1, true)
        }
    }

    override fun toNext() {
        ly_view_pager.setCurrentItem(ly_view_pager.currentItem + 1, true)
    }

    override fun toResult(inputText: String, number: Int) {
        startActivity(Intent(this, ResultActivity::class.java).apply {
            putExtra(ResultActivity.KeyInputText, inputText)
            putExtra(ResultActivity.KeySelectedNumber, number)
        })
        finish()
    }
}