package com.example.petscareapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class SignUpFragment: Fragment(R.layout.signup_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireView().findViewById<View>(R.id.button_signup) as Button).setOnClickListener {
            view.findNavController().navigate(R.id.action_signUpFragment_to_loginFragment)
        }
    }
}
