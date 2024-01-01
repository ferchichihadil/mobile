package com.isettozeur.myapplicationquiz
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity:AppCompatActivity() {

    private val questions = arrayOf(
        "Quelle est la capitale de la France?",
        "Quel est le plus grand océan du monde?",
        // Ajoutez d'autres questions
    )

    private val options = arrayOf(
        arrayOf("Paris", "Berlin", "Londres"),
        arrayOf("Océan Atlantique", "Océan Indien", "Océan Pacifique"),
        // Ajoutez d'autres options
    )

    private val correctAnswers = arrayOf(0, 2 /* Ajoutez l'indice de la bonne réponse pour chaque question */)

    private var currentQuestionIndex = 0
    private var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val userName = intent.getStringExtra("userName")

        val questionTextView: TextView = findViewById(R.id.questionTextView)
        val option1Button: Button = findViewById(R.id.option1Button)
        val option2Button: Button = findViewById(R.id.option2Button)
        val option3Button: Button = findViewById(R.id.option3Button)

        displayQuestion()

        option1Button.setOnClickListener {
            checkAnswer(0)
        }

        option2Button.setOnClickListener {
            checkAnswer(1)
        }

        option3Button.setOnClickListener {
            checkAnswer(2)
        }
    }

    private fun displayQuestion() {
        val questionTextView: TextView = findViewById(R.id.questionTextView)
        val option1Button: Button = findViewById(R.id.option1Button)
        val option2Button: Button = findViewById(R.id.option2Button)
        val option3Button: Button = findViewById(R.id.option3Button)

        if (currentQuestionIndex < questions.size) {
            questionTextView.text = questions[currentQuestionIndex]
            option1Button.text = options[currentQuestionIndex][0]
            option2Button.text = options[currentQuestionIndex][1]
            option3Button.text = options[currentQuestionIndex][2]
        } else {
            // Toutes les questions ont été posées, affichez le résultat
            showResult()
        }
    }

    private fun checkAnswer(selectedOption: Int) {
        if (selectedOption == correctAnswers[currentQuestionIndex]) {
            // La réponse est correcte, augmentez le score
            score += 5
        }

        // Passer à la question suivante
        currentQuestionIndex++
        displayQuestion()
    }

    private fun showResult() {
        // Affichez le résultat et redirigez vers l'activité de résultats
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("userName", intent.getStringExtra("userName"))
        intent.putExtra("score", score)
        startActivity(intent)
        finish()
    }
}
