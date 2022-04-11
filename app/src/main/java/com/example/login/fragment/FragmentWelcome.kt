package com.example.login.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.login.R

class FragmentWelcome : Fragment() {

    lateinit var handler: Handler

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        handler = Handler()
        val buttonSkip  = view.findViewById<Button>(R.id.skip)
        buttonSkip.setOnClickListener(){
//            val intent: Intent = Intent(this, SignUp::class.java)
//            startActivity(intent)
//            finish()
            val controller = findNavController()
            controller.navigate(R.id.action_fragmentWelcome_to_fragmentSignUp)
        }
        val buttonStartWith = view.findViewById<Button>(R.id.button3)
        buttonStartWith.setOnClickListener(){
//            val intent: Intent = Intent(this, SignUp::class.java)
//            startActivity(intent)
//            finish()
            val controller = findNavController()
            controller.navigate(R.id.action_fragmentWelcome_to_fragmentSignUp)
        }

        val buttonSignIn = view.findViewById<Button>(R.id.signin)
        buttonSignIn.setOnClickListener(){
//            val intent: Intent = Intent(this, Login::class.java)
//            startActivity(intent)
//            finish()
            val controller = findNavController()
            controller.navigate(R.id.action_fragmentWelcome_to_fragmentLogin)
        }
    }
}