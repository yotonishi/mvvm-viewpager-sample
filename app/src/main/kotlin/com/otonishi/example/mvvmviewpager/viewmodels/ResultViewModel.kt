package com.otonishi.example.mvvmviewpager.viewmodels

import android.content.Context
import android.content.Intent
import android.databinding.BaseObservable
import android.databinding.ObservableField
import com.otonishi.example.mvvmviewpager.activities.ResultActivity
import com.otonishi.example.mvvmviewpager.navigators.ResultNavigator
import com.otonishi.example.mvvmviewpager.util.convertNumberToText
import com.otonishi.example.mvvmviewpager.util.selected1

class ResultViewModel(private val context: Context) : BaseObservable() {

    var inputText = ObservableField<String>()
    var selectedRadioText = ObservableField<String>()

    private var navigator: ResultNavigator? = null

    fun setNavigator(navigator: ResultNavigator) {
        this.navigator = navigator
    }

    fun setInputValue(intent: Intent) {
        inputText.set(intent.getStringExtra(ResultActivity.KeyInputText))
        context.convertNumberToText(intent.getIntExtra(ResultActivity.KeySelectedNumber,selected1)).also {
            selectedRadioText.set(it)
        }
    }

    fun finishResult(){
        navigator?.finishResult()
    }

    fun onActivityDestroyed() {
        // Clear references to avoid potential memory leaks.
        navigator = null
    }
}