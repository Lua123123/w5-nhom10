package com.example.login.fragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.login.R

class FragmentVerificationCode : Fragment() {

    lateinit var handler: Handler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verification_code, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handler = Handler()
        handler.postDelayed({

//            val intent = Intent(this, OnboardingOne::class.java)
//            startActivity(intent)
//            finish()
            val controller = findNavController()
            controller.navigate(R.id.action_fragmentVerificationCode_to_fragmentOnboardingOne)

        }, 3000)

    }
}