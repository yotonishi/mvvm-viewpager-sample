package com.otonishi.example.mvvmviewpager.viewmodels

import android.content.Context
import android.databinding.BaseObservable
import com.otonishi.example.mvvmviewpager.navigators.TopNavigator

class TopViewModel(private val context: Context): BaseObservable() {

    private var navigator: TopNavigator? = null

    fun setNavigator(navigator: TopNavigator){
        this.navigator = navigator
    }

    fun onClickToViewPager(){
        navigator?.toViewPager()
    }

    fun onActivityDestroyed() {
        // Clear references to avoid potential memory leaks.
        navigator = null
    }
}