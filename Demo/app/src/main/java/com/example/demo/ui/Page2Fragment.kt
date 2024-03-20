package com.example.demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.demo.R
import com.example.demo.UserViewModel
import com.example.demo.databinding.FragmentPage2Binding

class Page2Fragment : Fragment() {

    private lateinit var binding: FragmentPage2Binding
    private val nav by lazy { findNavController() }

    // TODO: Shared view model
    private val vm: UserViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPage2Binding.inflate(inflater, container, false)

        // ----------------------------------------------------------------------------------------

        // TODO: Setup RecyclerView with adapter


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