package com.example.login.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.login.R
import com.example.login.databinding.FragmentLoginBinding
import com.example.login.viewmodel.MainViewModel

class FragmentLogin : Fragment() {

    //MVVM
    val mainViewModel: MainViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin?.setOnClickListener(View.OnClickListener {

            val email = binding.edtEmail?.text.toString().trim()
            val password = binding.edtPassWord?.text.toString().trim()
            Log.d("iii", email)
            Log.d("iii", password)

            mainViewModel.LoginUser(email, password)
        })

        binding.txtSignUp?.setOnClickListener(View.OnClickListener {
//            val intent2 = Intent(this@Login, SignUp::class.java)
//            intent2.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                    or Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(intent2)
//            finish()
            val controller = findNavController()
            controller.navigate(R.id.action_fragmentLogin_to_fragmentSignUp)
        })
        listennerSuccessEvent()
        listennerErrorEvent()
    }

    private fun listennerSuccessEvent() {
        mainViewModel.isSuccessEvent.observe(this) { isSuccess ->
            if (isSuccess) {

                val email = binding.edtEmail?.text.toString().trim()
                val password = binding.edtPassWord?.text.toString().trim()
                Log.d("iii", email)
                Log.d("iii", password)

//                val intent = intent
//                val bundle = intent.getBundleExtra("Data")
//                val emailBundle = bundle?.getString("email")
//                val passwordBundle = bundle?.getString("pass")
//                val fullNameBundle = bundle?.getString("name")
//                val EMAIL = emailBundle
//                val PASS = passwordBundle
//                if (email != EMAIL) {
//                    Toast.makeText(activity, "Email is invalid", Toast.LENGTH_LONG).show()
//                    return@observe
//                }
//                if (password != PASS) {
//                    Toast.makeText(activity, "Pass is invalid", Toast.LENGTH_LONG).show()
//                    return@observe
//                }

//                val intent2 = Intent(activity, RecycleviewDataStore::class.java)
//                val bundle2 = Bundle()
//                bundle2.putString("email", email)
//                bundle2.putString("name", fullNameBundle)
//                intent2.putExtra("Data", bundle2)
                val controller = findNavController()
                controller.navigate(R.id.action_fragmentLogin_to_fragmentHomeScreen)
            }
        }
    }

    private fun listennerErrorEvent() {
        mainViewModel.isErrorEvent.observe(this) { isError ->
            Toast.makeText(activity, isError, Toast.LENGTH_LONG).show()
        }

    }
}