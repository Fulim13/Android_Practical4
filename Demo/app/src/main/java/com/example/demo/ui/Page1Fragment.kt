package com.example.demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.demo.R
import com.example.demo.UserAdapter
import com.example.demo.UserViewModel
import com.example.demo.databinding.FragmentPage1Binding

class Page1Fragment : Fragment() {

    private lateinit var binding: FragmentPage1Binding
    private val nav by lazy { findNavController() }

    // TODO: Shared view model
//    viewModel
    private val vm: UserViewModel by activityViewModels()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPage1Binding.inflate(inflater, container, false)

        // ----------------------------------------------------------------------------------------

        // TODO: Setup RecyclerView with adapter
        val adapter = UserAdapter { h , u ->
            h.binding.btnDelete.setOnClickListener{ vm.delete(u.id) }
            h.binding.btnMore.setOnClickListener{ more(u.id) }
        }

        binding.rv.adapter = adapter

        // TODO: Divider item decoration
        binding.rv.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        // TODO: Observe live data
        // I want to observe live data as long as it not remove and move to another fragment
        vm.usersLiveData.observe(viewLifecycleOwner) {
            binding.txtCount.text ="${it.size} user(s)"
            adapter.submitList(it)
        }

        // ----------------------------------------------------------------------------------------

        return binding.root
    }

    fun more(userId: Int) {
        nav.navigate(R.id.page3Fragment, bundleOf(
            "userId" to userId
        ))
    }

}