package com.otonishi.example.mvvmviewpager.handlers

import android.widget.RadioGroup
import com.otonishi.example.mvvmviewpager.extensions.logOutput
import com.otonishi.example.mvvmviewpager.viewmodels.ViewPagerViewModel

class ViewPagerHandler {

    fun onClickToNext(viewModel: ViewPagerViewModel) {
        logOutput("onClickToNext")
        viewModel.onClickToNext()
    }

    fun onClickToResult(viewModel: ViewPagerViewModel, rg: RadioGroup) {
        viewModel.onClickToResult(rg.checkedRadioButtonId)
    }

    fun getRadioText(viewModel: ViewPagerViewModel, number: Int): String {
        return viewModel.getRadioText(number)
    }
}