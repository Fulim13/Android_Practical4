package com.example.demo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import coil.load
import com.example.demo.User
import com.example.demo.UserViewModel
import com.example.demo.databinding.FragmentPage3Binding

class Page3Fragment : Fragment() {

    private lateinit var binding: FragmentPage3Binding
    private val nav by lazy { findNavController() }

    // TODO: Shared view model
    private val vm: UserViewModel by activityViewModels()

    // TODO: Arguments
    private val userId by lazy { requireArguments().getInt("userId", 0) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPage3Binding.inflate(inflater, container, false)

        // ----------------------------------------------------------------------------------------

        // TODO: Load user
        val user = vm.get(userId);
        if (user == null) {
            nav.navigateUp()
        }
        else {
            load(user)
        }

        binding.btnBack.setOnClickListener {
            nav.navigateUp()
        }

        // ----------------------------------------------------------------------------------------

        return binding.root
    }

    fun load(user: User) {
        binding.imgPhoto.load(user.photo)
        binding.txtId.text = user.id.toString()
        binding.txtName.text = user.name
        binding.txtGender.text = if (user.gender == "F") "Female" else "Male"
        binding.txtAge.text = user.age.toString()
        binding.txtCountry.text = user.country + " - " + user.countryName
    }

}