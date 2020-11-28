package com.test.istestprojectapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.test.istestprojectapplication.R
import com.test.istestprojectapplication.core.SessionManager
import kotlinx.android.synthetic.main.fragment_welcome.*


class WelcomeFragment() : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val userName = SessionManager(requireContext()).getUserName()
        userName?.let { (activity as MainActivity).setWelcomeActionBar(it) }
        viewItems.setOnClickListener { openProductListingFragment() }
    }

    private fun openProductListingFragment() {
        findNavController().navigate(R.id.action_welcomeFragment_to_productsFragment)
    }

}