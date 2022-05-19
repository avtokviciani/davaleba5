package com.example.davaleba5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextTextEmailAddress: EditText
    private lateinit var editTextTextPassword: EditText
    private lateinit var button: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()

    }

    private fun init () {

        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress)
        editTextTextPassword = findViewById(R.id.editTextTextPassword)
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

    }


    private fun registerlisteners(){

        button.setOnClickListener {

            val email = editTextTextEmailAddress.text.toString()
            val password = editTextTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {

                Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT ).show()
                return@setOnClickListener

            }


            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        startActivity(Intent(this, ProfileActivity::class.java))
                        finish()

                    } else{
                        Toast.makeText(this, "Error!!", Toast.LENGTH_SHORT).show()
                    }

                }

        }

        button2.setOnClickListener {

            startActivity(Intent(this, RegisterActivity :: class.java))

        }

        button3.setOnClickListener {

            startActivity(Intent(this, ResetPasswordActivity :: class.java))

        }

    }

}