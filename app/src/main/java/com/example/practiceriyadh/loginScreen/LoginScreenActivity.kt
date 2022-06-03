package com.example.practiceriyadh.loginScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.practiceriyadh.R
import com.example.practiceriyadh.databinding.ActivityLoginScreenBinding
import com.example.practiceriyadh.zoneScreen.MainActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase

class LoginScreenActivity : AppCompatActivity() {

    lateinit var loginBinding:ActivityLoginScreenBinding
    lateinit var mAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login_screen)

        supportActionBar?.title = "SignIn"
        mAuth = FirebaseAuth.getInstance()

        loginBinding.btnLogin.setOnClickListener {
          //  profileProgressBar.visibility = View.VISIBLE
            var email = loginBinding.etEnterEmail.editableText.toString()
            var password =loginBinding.etEnterPassword.editableText.toString()


            if (email.isEmpty() || password.isEmpty()) {
             //   profileProgressBar.visibility = View.INVISIBLE
                Toast.makeText(
                    this@LoginScreenActivity, "Please Enter valid email and password", Toast.LENGTH_LONG
                ).show()
            } else {
                mAuth!!.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this@LoginScreenActivity,
                        OnCompleteListener<AuthResult?> { task ->
                            if (task.isSuccessful) {

                            //    profileProgressBar.visibility = View.INVISIBLE

                                Toast.makeText(
                                    this@LoginScreenActivity,
                                    "Authentication SuccessFul",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this, MainActivity::class.java)
                                startActivity(intent)

                            } else {
                             //   profileProgressBar.visibility = View.INVISIBLE
                                Toast.makeText(
                                    this@LoginScreenActivity,
                                    "Authentication Failed",
                                    Toast.LENGTH_SHORT
                                ).show()

                            }
                        })
            }
        }

    }

    override fun onStart() {
        super.onStart()
        var user: FirebaseUser? =mAuth?.currentUser
        if (user!=null){
            startActivity(Intent(this,MainActivity::class.java))
            Toast.makeText(this,"User already Login",Toast.LENGTH_SHORT).show()
            finish()
        }else{
            Toast.makeText(this,"First Login",Toast.LENGTH_LONG).show()
        }
    }
}