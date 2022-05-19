package com.example.davaleba5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var editTextTextEmailAddress2: EditText
    private lateinit var editTextTextPassword2: EditText
    private lateinit var button4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()

    }

    private fun init() {

        editTextTextEmailAddress2 = findViewById(R.id.editTextTextEmailAddress2)
        editTextTextPassword2 = findViewById(R.id.editTextTextPassword2)
        button4 = findViewById(R.id.button4)


    }

    private fun registerlisteners() {

        button4.setOnClickListener {
            button4.setOnClickListener {

                val email = editTextTextEmailAddress2.text.toString()
                val password = editTextTextPassword2.text.toString()

                if (email.isEmpty() || password.isEmpty()) {

                    Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener

                }


                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful){
                            startActivity(Intent(this, LoginActivity::class.java))

                        } else{
                            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()

                        }

                    }

            }

        }

    }
}