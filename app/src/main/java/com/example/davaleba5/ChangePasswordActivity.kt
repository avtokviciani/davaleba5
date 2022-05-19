package com.example.davaleba5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var editTextTextPassword3 : EditText
    private lateinit var button8 : Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        init()
        registerlisteners()

    }


    private fun init(){

        editTextTextPassword3 = findViewById(R.id.editTextTextPassword3)
        button8 = findViewById(R.id.button8)


    }

    private fun registerlisteners(){

        button8.setOnClickListener {

            val NewPassword = editTextTextPassword3.text.toString()

            if (NewPassword.isEmpty() || NewPassword.length < 8) {

                Toast.makeText(this, "Enter Password Again", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            }

            // ToDo



        }

    }


}