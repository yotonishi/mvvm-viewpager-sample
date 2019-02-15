package com.otonishi.example.mvvmviewpager.handlers

import com.otonishi.example.mvvmviewpager.viewmodels.ResultViewModel

class ResultHandler {

    fun onClick(viewModel: ResultViewModel) {
        viewModel.finishResult()
    }
}