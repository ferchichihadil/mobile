package com.isettozeur.myapplicationquiz

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
class ThemeSelectionActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme_selection)

        val userName = intent.getStringExtra("userName")

        val themes = arrayOf("Histoire", "Géographie", "Sport", "Politique", "Technologie")

        val themeList: ListView = findViewById(R.id.themeList)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, themes)
        themeList.adapter = adapter

        themeList.setOnItemClickListener { _, _, position, _ ->
            val selectedTheme = themes[position]
            val intent = Intent(this, QuizActivity::class.java)
            intent.putExtra("userName", userName)
            intent.putExtra("selectedTheme", selectedTheme)
            startActivity(intent)
        }
    }

}


