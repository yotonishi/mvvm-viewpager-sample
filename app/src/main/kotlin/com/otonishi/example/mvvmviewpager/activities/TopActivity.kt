package com.otonishi.example.mvvmviewpager.activities

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.otonishi.example.mvvmviewpager.R
import com.otonishi.example.mvvmviewpager.databinding.ActivityTopBinding
import com.otonishi.example.mvvmviewpager.extensions.logOutput
import com.otonishi.example.mvvmviewpager.extensions.setupActionBar
import com.otonishi.example.mvvmviewpager.handlers.TopHandler
import com.otonishi.example.mvvmviewpager.navigators.TopNavigator
import com.otonishi.example.mvvmviewpager.viewmodels.TopViewModel

class TopActivity : AppCompatActivity(), TopNavigator {

    override fun toViewPager() {
        startActivity(Intent(this, ViewPagerActivity::class.java))
    }

    private val viewModel by lazy {
        TopViewModel(this)
    }

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityTopBinding>(this, R.layout.activity_top)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top)

        setupActionBar(binding.toolbar) {
            title = resources.getString(R.string.app_name)
        }

        viewModel.setNavigator(this)

        binding.apply {
            viewmodel = this@TopActivity.viewModel
            handlers = TopHandler()
        }
    }

    override fun onDestroy() {
        viewModel.onActivityDestroyed()
        super.onDestroy()
    }

}
