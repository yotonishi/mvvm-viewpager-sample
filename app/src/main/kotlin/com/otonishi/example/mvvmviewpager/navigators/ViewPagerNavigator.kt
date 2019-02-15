package com.otonishi.example.mvvmviewpager.navigators

interface ViewPagerNavigator {

    fun toNext()
    fun toResult(inputText: String, number: Int)
}