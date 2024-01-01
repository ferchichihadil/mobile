package com.isettozeur.myapplicationquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStartQuiz: Button = findViewById(R.id.btnStartQuiz)
        val etUserName: EditText = findViewById(R.id.etUserName)

        btnStartQuiz.setOnClickListener {
            val userName = etUserName.text.toString()
            val intent = Intent(this, ThemeSelectionActivity::class.java)
            intent.putExtra("userName", userName)
            startActivity(intent)
        }
    }
}
