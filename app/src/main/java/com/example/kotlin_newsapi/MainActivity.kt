package com.example.kotlin_newsapi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val submitButton: Button
        get() = findViewById(R.id.loginButton)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submitButton.setOnClickListener{
            val nameInput = findViewById<EditText>(R.id.nameInput).text.toString()
            if(nameInput.isNotEmpty()){
                val ResultIntent = Intent(this, HomeActivity::class.java)
                ResultIntent.putExtra(name, nameInput)
                startActivity(ResultIntent)
            }
            else{
                Toast
                    .makeText(this, getString(R.string.name_input_empty),
                        Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    companion object {
        const val TAG = "MainActivity"
        const val name = "name"
    }
}