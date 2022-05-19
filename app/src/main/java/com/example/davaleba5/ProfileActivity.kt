package com.example.davaleba5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class ProfileActivity : AppCompatActivity() {
    private lateinit var button6 : Button
    private lateinit var button7 : Button
    private lateinit var textView : TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        init()
        registerlisteners()

        textView.text = FirebaseAuth.getInstance().currentUser?.uid
    }

    private fun init() {
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        textView = findViewById(R.id.textView)


    }


    private fun registerlisteners(){

        button7.setOnClickListener {

            startActivity(Intent(this, ChangePasswordActivity:: class.java))

        }

        button6.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }

    }


}

