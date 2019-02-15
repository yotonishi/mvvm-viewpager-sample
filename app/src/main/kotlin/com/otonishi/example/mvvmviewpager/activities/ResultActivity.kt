package com.otonishi.example.mvvmviewpager.activities

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.otonishi.example.mvvmviewpager.R
import com.otonishi.example.mvvmviewpager.databinding.ActivityResultBinding
import com.otonishi.example.mvvmviewpager.extensions.setupActionBar
import com.otonishi.example.mvvmviewpager.handlers.ResultHandler
import com.otonishi.example.mvvmviewpager.navigators.ResultNavigator
import com.otonishi.example.mvvmviewpager.viewmodels.ResultViewModel

class ResultActivity : AppCompatActivity(), ResultNavigator {
    override fun finishResult() {
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private val viewModel by lazy {
        ResultViewModel(this)
    }

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityResultBinding>(this, R.layout.activity_result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        viewModel.apply {
            setNavigator(this@ResultActivity)
            setInputValue(this@ResultActivity.intent)
        }

        setupActionBar(binding.toolbar) {
            title = "Result"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        binding.apply {
            viewmodel = this@ResultActivity.viewModel
            handlers = ResultHandler()
        }
    }

    override fun onDestroy() {
        viewModel.onActivityDestroyed()
        super.onDestroy()
    }

    companion object {
        const val KeyInputText = "key_input_text"
        const val KeySelectedNumber = "key_selected_number"
    }
}