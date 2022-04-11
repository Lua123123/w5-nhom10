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

class FragmentOnboardingThree : Fragment() {

    lateinit var handler: Handler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonSkip = view.findViewById<RelativeLayout>(R.id.nut3)
        buttonSkip.setOnClickListener() {
//            val intent: Intent = Intent(this, Welcome::class.java)
//            startActivity(intent)
//            activity?.finish()
            val controller = findNavController()
            controller.navigate(R.id.action_fragmentOnboardingThree_to_fragmentWelcome)
        }

    }
}