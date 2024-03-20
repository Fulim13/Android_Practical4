package com.example.demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.demo.R
import com.example.demo.databinding.FragmentPage1Binding

class Page1Fragment : Fragment() {

    private lateinit var binding: FragmentPage1Binding
    private val nav by lazy { findNavController() }

    // TODO: Shared view model


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPage1Binding.inflate(inflater, container, false)

        // ----------------------------------------------------------------------------------------

        // TODO: Setup RecyclerView with adapter


        // TODO: Divider item decoration
        binding.rv.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        // TODO: Observe live data


        // ----------------------------------------------------------------------------------------

        return binding.root
    }

    fun more(userId: Int) {
        nav.navigate(R.id.page3Fragment, bundleOf(
            "userId" to userId
        ))
    }

}