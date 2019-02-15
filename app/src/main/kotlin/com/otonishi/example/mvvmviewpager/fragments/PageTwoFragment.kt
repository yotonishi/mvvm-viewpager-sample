package com.otonishi.example.mvvmviewpager.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.otonishi.example.mvvmviewpager.R
import com.otonishi.example.mvvmviewpager.databinding.FragmentViewPager2Binding
import com.otonishi.example.mvvmviewpager.handlers.ViewPagerHandler
import com.otonishi.example.mvvmviewpager.viewmodels.ViewPagerViewModel
import kotlinx.android.synthetic.main.fragment_view_pager_2.view.*

class PageTwoFragment : Fragment() {

    private var viewModel: ViewPagerViewModel? = null

    private var binding: FragmentViewPager2Binding? = null

    fun setViewModel(viewModel: ViewPagerViewModel) {
        this.viewModel = viewModel
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_view_pager_2, container, false)
        if (binding == null) {
            binding = FragmentViewPager2Binding.bind(root)
        }

        binding!!.apply {
            viewmodel = this@PageTwoFragment.viewModel
            handlers = ViewPagerHandler()
            radiogroup = root.rg_view_pager_group
        }

        return binding!!.root
    }


    companion object {
        fun newInstance(): PageTwoFragment = PageTwoFragment()
    }
}