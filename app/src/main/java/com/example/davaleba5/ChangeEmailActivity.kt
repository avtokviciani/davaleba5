package com.example.davaleba5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ChangeEmailActivity : AppCompatActivity() {
    private lateinit var editTextTextEmailAddress5 : EditText
    private lateinit var button12 : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_email)

    init()
    registerlistener()

    }

    private fun init(){
        editTextTextEmailAddress5 = findViewById(R.id.editTextTextEmailAddress5)
        button12 = findViewById(R.id.button12)

    }


    private fun registerlistener() {

        button12.setOnClickListener { it: View? ->

            val newEmail = editTextTextEmailAddress5.text.toString()

            if (newEmail.isEmpty() || newEmail.endsWith(suffix = ".ru", ignoreCase = true)) {

                Toast.makeText(this, "Enter E-mail Again!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }


            FirebaseAuth.getInstance()
                .sendPasswordResetEmail(newEmail)
                .addOnCompleteListener { task ->

                    if (task.isSuccessful){

                        Toast.makeText(this, "Check E-mail", Toast.LENGTH_SHORT).show()

                    } else {

                        Toast.makeText(this, "Error!!!!", Toast.LENGTH_SHORT).show()
                    }

                }


        }

    }

}

