package com.otonishi.example.mvvmviewpager.viewmodels

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.ObservableField
import android.support.annotation.IdRes
import android.support.v7.app.AlertDialog
import android.view.View
import com.otonishi.example.mvvmviewpager.R
import com.otonishi.example.mvvmviewpager.extensions.logOutput
import com.otonishi.example.mvvmviewpager.navigators.ViewPagerNavigator
import com.otonishi.example.mvvmviewpager.util.convertNumberToText
import com.otonishi.example.mvvmviewpager.util.selected1
import com.otonishi.example.mvvmviewpager.util.selected2
import java.lang.Exception

class ViewPagerViewModel(private val context: Context) : BaseObservable() {

    private var navigator: ViewPagerNavigator? = null

    val inputText = ObservableField<String>()

    fun setNavigator(navigator: ViewPagerNavigator) {
        this.navigator = navigator
    }

    fun onClickToNext() {
        logOutput("inputText is ${inputText.get()}")
        if (inputText.get()?.isNotEmpty() == true) {
            navigator?.toNext()
        } else {
            showEmptyError()
        }
    }

    private fun showEmptyError() {
        val dialog = AlertDialog.Builder(context)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            .setTitle("Empty Error")
            .setMessage("Please input text")
            .let {
                it.create()
            }

        dialog.show()
    }

    fun onClickToResult(@IdRes selectRadioID: Int) {
        val number = when(selectRadioID){
            R.id.rg_view_pager_group_1 -> selected1
            R.id.rg_view_pager_group_2 -> selected2
            else -> throw Exception()
        }
        navigator?.toResult(inputText.get()!!, number)
    }

    fun getRadioText(number: Int): String{
        return context.convertNumberToText(number)
    }

    fun onActivityDestroyed() {
        // Clear references to avoid potential memory leaks.
        navigator = null
    }
}