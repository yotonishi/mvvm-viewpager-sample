package com.otonishi.example.mvvmviewpager.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.otonishi.example.mvvmviewpager.R
import com.otonishi.example.mvvmviewpager.databinding.FragmentViewPager1Binding
import com.otonishi.example.mvvmviewpager.handlers.ViewPagerHandler
import com.otonishi.example.mvvmviewpager.viewmodels.ViewPagerViewModel
import kotlinx.android.synthetic.main.fragment_view_pager_1.view.*

class PageOneFragment : Fragment(){

    private var viewModel: ViewPagerViewModel? = null

    private var binding: FragmentViewPager1Binding? = null

    fun setViewModel(viewModel: ViewPagerViewModel){
        this.viewModel = viewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_view_pager_1, container, false)
        if (binding == null) {
            binding = FragmentViewPager1Binding.bind(root)
        }

        binding!!.apply {
            viewmodel = this@PageOneFragment.viewModel
            handlers = ViewPagerHandler()
        }

        return binding!!.root
    }

    companion object {
        fun newInstance(): PageOneFragment = PageOneFragment()
    }
}