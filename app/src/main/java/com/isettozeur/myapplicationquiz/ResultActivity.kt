package com.isettozeur.myapplicationquiz
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName = intent.getStringExtra("userName")
        val score = intent.getIntExtra("score", 0)

        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val btnReturnToThemes: Button = findViewById(R.id.btnReturnToThemes)

        resultTextView.text = "$userName, votre score est de $score points."

        if (score >= 10) {
            resultTextView.setTextColor(resources.getColor(android.R.color.holo_green_dark))
        } else {
            resultTextView.setTextColor(resources.getColor(android.R.color.holo_red_dark))
        }

        btnReturnToThemes.setOnClickListener {
            val intent = Intent(this, ThemeSelectionActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
