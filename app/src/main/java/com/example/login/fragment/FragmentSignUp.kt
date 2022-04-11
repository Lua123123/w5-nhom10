package com.example.login.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.login.R
import com.example.login.databinding.FragmentSignUpBinding
import com.example.login.viewmodel.MainViewModel
import java.util.regex.Pattern

class FragmentSignUp : Fragment() {

    //MVVM
    private lateinit var binding: FragmentSignUpBinding
    val mainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun PasswordValidation(password: String): Boolean {
            return if (password.length >= 8) {
                val letter = Pattern.compile("[a-zA-z]")
                val digit = Pattern.compile("[0-9]")
                val special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]")
                //Pattern eight = Pattern.compile (".{8}");
                val hasLetter = letter.matcher(password)
                val hasDigit = digit.matcher(password)
                val hasSpecial = special.matcher(password)
                hasLetter.find() && hasDigit.find() && hasSpecial.find()
            } else false
        }

//        edtFullName = findViewById<View>(R.id.edtFullName) as EditText
//        edtEmail = findViewById<View>(R.id.edtEmail) as EditText
//        edtPassWord = findViewById<View>(R.id.edtPassWord) as EditText
//        txtLogin = findViewById<View>(R.id.txtLogin) as TextView
//        login = findViewById<View>(R.id.login) as TextView

        binding.login.setOnClickListener(View.OnClickListener {

            val email = binding.edtEmail.text.toString().trim()
            val password = binding.edtPassWord.text.toString().trim()
            val fullname = binding.edtFullName.text.toString().trim()
            var view: View? = null

            if (password.length < 8) {
                binding.edtPassWord.error = "Field is required minimum is 8"
                view = binding.edtPassWord
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.edtEmail.error = "Field is required"
                view = binding.edtEmail
            }
            if (fullname.isEmpty()) {
                binding.edtFullName.error = "Field is required"
                view = binding.edtFullName
            }
            if (email.isEmpty()) {
                binding.edtEmail.error = "Field is required"
                view = binding.edtEmail
            }
            if (password.isEmpty()) {
                binding.edtPassWord.error = "Field is required"
                view = binding.edtPassWord
            }
            if (!PasswordValidation(password)) {
                binding.edtPassWord.error = "Field is required minimum is 8 and all charecters have @#! 1-8 a-Z"
                view = binding.edtPassWord
                return@OnClickListener;
            }

            mainViewModel.registerUser(email, password, fullname)
        })

        binding.txtLogin?.setOnClickListener(View.OnClickListener {
//            val intent2 = Intent(this@SignUp, Login::class.java)
//            intent2.flags = (Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK
//                    or Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(intent2)
//            finish()
            val controller = findNavController()
            controller.navigate(R.id.action_fragmentSignUp_to_fragmentLogin)

        })
        listennerSuccessEvent()
        listennerErrorEvent()
    }

    private fun listennerSuccessEvent() {
        mainViewModel.isSuccessEvent.observe(this) { isSuccess ->
            if (isSuccess) {
                val email = binding.edtEmail.text.toString().trim()
                val password = binding.edtPassWord.text.toString().trim()
                val fullname = binding.edtFullName.text.toString().trim()

//                val action = fragmentSignUp.ac
                val controller = findNavController()
                controller.navigate(R.id.action_fragmentSignUp_to_fragmentLogin)

//                val intent = Intent(this, Login::class.java)
//                val bundle = Bundle()
//                bundle.putString("name", fullname)
//                bundle.putString("email", email)
//                bundle.putString("pass", password)
//                intent.putExtra("Data", bundle)
//                startActivity(intent)
//                finish()
            }
        }
    }

    private fun listennerErrorEvent() {
        mainViewModel.isErrorEvent.observe(this) { isError ->
            Toast.makeText(activity, isError, Toast.LENGTH_LONG).show()
        }
    }
}