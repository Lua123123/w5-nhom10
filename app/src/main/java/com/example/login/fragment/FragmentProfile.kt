package com.example.login.fragment

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.login.R
import com.example.login.databinding.FragmentLoginBinding
import com.example.login.databinding.FragmentProfileBinding
import com.example.login.viewmodel.MainViewModel

class FragmentProfile : Fragment() {

    lateinit var dataBinding:FragmentProfileBinding
    val mainViewModel: MainViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dataBinding = FragmentProfileBinding.inflate(inflater, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialogProfile()
        getDataFromSignUp();

        dataBinding.btnSoutProfile.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.action_fragmentProfile_to_fragmentWelcome)
        }

    }

    private fun getDataFromSignUp() {
//        val intent2 = intent
//        val bundle2 = intent.getBundleExtra("Data")
//        val fullNameBundle = bundle2?.getString("name")
//        val emailBundle = bundle2?.getString("email")
//        dataBinding.txtFullName?.setText(fullNameBundle)
//        dataBinding.txtEmail?.setText(emailBundle)

    }

    private fun dialogProfile() {

        dataBinding.txtFullName?.setOnClickListener(View.OnClickListener { view ->
            val builder = AlertDialog.Builder(activity)
            val viewGroup = view.findViewById<ViewGroup>(android.R.id.content)

            val dialogView =
                LayoutInflater.from(view.context)
                    .inflate(R.layout.dialog_signup_fullname, viewGroup, false)
            builder.setView(dialogView)
            val alertDialog = builder.create()
            alertDialog.show()

            val edtDialogFullName = alertDialog.findViewById<EditText>(R.id.edtDialogFullName)
            val txtDialogCancelFullName =
                alertDialog.findViewById<TextView>(R.id.txtDialogCancelFullName)
            val btnDialogEnterFullName =
                alertDialog.findViewById<TextView>(R.id.btnDialogEnterFullName)

            txtDialogCancelFullName.setOnClickListener {
                alertDialog.dismiss()
            }

            btnDialogEnterFullName.setOnClickListener {
                val fullName: String = edtDialogFullName.getText().toString().trim { it <= ' ' }
                dataBinding.txtFullName?.setText(fullName)
                alertDialog.cancel()
            }
        })



        dataBinding.txtEmail?.setOnClickListener(View.OnClickListener { view ->
            val builder = AlertDialog.Builder(activity)
            val viewGroup = view.findViewById<ViewGroup>(android.R.id.content)

            val dialogView =
                LayoutInflater.from(view.context)
                    .inflate(R.layout.dialog_signup_email, viewGroup, false)
            builder.setView(dialogView)
            val alertDialog = builder.create()
            alertDialog.show()

            val edtDialogEmail = alertDialog.findViewById<EditText>(R.id.edtDialogEmail)
            val txtDialogCancelEmail =
                alertDialog.findViewById<TextView>(R.id.txtDialogCancelEmail)
            val btnDialogEnterEmail =
                alertDialog.findViewById<TextView>(R.id.btnDialogEnterEmail)

            txtDialogCancelEmail.setOnClickListener {
                alertDialog.dismiss()
            }

            btnDialogEnterEmail.setOnClickListener {
                val email: String = edtDialogEmail.getText().toString().trim { it <= ' ' }
                dataBinding.txtEmail?.setText(email)
                alertDialog.cancel()
            }
        })


        dataBinding.txtPhone?.setOnClickListener(View.OnClickListener { view ->
            val builder = AlertDialog.Builder(activity)
            val viewGroup = view.findViewById<ViewGroup>(android.R.id.content)

            val dialogView =
                LayoutInflater.from(view.context)
                    .inflate(R.layout.dialog_signup_password, viewGroup, false)
            builder.setView(dialogView)
            val alertDialog = builder.create()
            alertDialog.show()

            val edtDialogPassword = alertDialog.findViewById<EditText>(R.id.edtDialogPassword)
            val txtDialogCancelPassword =
                alertDialog.findViewById<TextView>(R.id.txtDialogCancelPassword)
            val btnDialogEnterPassword =
                alertDialog.findViewById<TextView>(R.id.btnDialogEnterPassword)

            txtDialogCancelPassword.setOnClickListener {
                alertDialog.dismiss()
            }

            btnDialogEnterPassword.setOnClickListener {
                val password: String = edtDialogPassword.getText().toString().trim { it <= ' ' }
                dataBinding.txtPhone?.setText(password)
                alertDialog.cancel()
            }
        })
    }

}