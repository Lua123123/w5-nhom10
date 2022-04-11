package com.example.login.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.login.R

class FragmentOnBoardingTwo : Fragment() {
    lateinit var handler: Handler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_boarding_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonSkip = view.findViewById<RelativeLayout>(R.id.nut2)
        buttonSkip.setOnClickListener() {
//            val intent: Intent = Intent(this, OnboardingThree::class.java)
//            startActivity(intent)
//            activity?.finish()
            val controller = findNavController()
            controller.navigate(R.id.action_fragmentOnBoardingTwo_to_fragmentOnboardingThree)
        }

    }
}