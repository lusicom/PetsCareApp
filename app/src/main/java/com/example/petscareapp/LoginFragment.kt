package com.example.petscareapp
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.petscareapp.validator.InputErrorHandler


class LoginFragment: Fragment(R.layout.login_fragment) {


    private val inputErrorHandler = InputErrorHandler()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (requireView().findViewById<View>(R.id.button_signupForm) as Button).setOnClickListener {
            view.findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }


        (requireView().findViewById<View>(R.id.button_login) as Button).setOnClickListener {
            Toast.makeText(activity, "Thank you for LogIn", Toast.LENGTH_LONG).show()
        }
    }
}