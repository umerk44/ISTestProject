package com.test.istestprojectapplication.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.test.istestprojectapplication.R
import com.test.istestprojectapplication.core.SessionManager


class SplashFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if( SessionManager(requireContext()).getToken() == null) {
            openNextFragment(R.id.action_splashFragment_to_loginFragment)
        } else {
            openNextFragment(R.id.action_splashFragment_to_welcomeFragment)
        }
    }

    private fun openNextFragment(action: Int) {
        findNavController().navigate(action)
    }

}