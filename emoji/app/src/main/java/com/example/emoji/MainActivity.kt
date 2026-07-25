package com.example.emoji

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.emoji.R


class MainActivity : AppCompatActivity() {
    private lateinit var emojiText: TextView
    private lateinit var inputAnswer: EditText
    private lateinit var feedbackText: TextView
    private lateinit var scoreText: TextView

    private var emojiItems: List<Pair<String, String>> = listOf()
    private var currentEmoji: Pair<String, String>? = null
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        emojiText = findViewById(R.id.emojiText)
        inputAnswer = findViewById(R.id.inputAnswer)
        feedbackText = findViewById(R.id.feedbackText)
        scoreText = findViewById(R.id.scoreText)

        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener { checkAnswer() }

        // Initialize Emoji Items
        initializeEmojiList()

        // Load the first random emoji
        loadNewEmoji()
    }

    private fun initializeEmojiList() {
        emojiItems = listOf(
            "🍎🍏" to "Apple",
            "🍌" to "Banana",
            "🦁👑" to "Lion King",
            "🧙‍♂️🪄" to "Harry Potter",
            "🍇🍉" to "Grapes",
            "🐕🦴" to "Dog Bone",
            "🌙⭐" to "Moon Star"
        )

        if (emojiItems.isEmpty()) {
            Toast.makeText(this, "Emoji list is empty!", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun loadNewEmoji() {
        // Randomly pick an emoji item
        currentEmoji = emojiItems.randomOrNull()
        if (currentEmoji != null) {
            emojiText.text = currentEmoji!!.first
        } else {
            Toast.makeText(this, "Error loading emoji!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkAnswer() {
        val userAnswer = inputAnswer.text.toString().trim()
        if (userAnswer.equals(currentEmoji?.second, ignoreCase = true)) {
            score++
            feedbackText.text = "Correct!"
        } else {
            feedbackText.text = "Try Again!"
        }

        // Update score and clear input
        scoreText.text = "Score: $score"
        inputAnswer.text.clear()

        // Load a new random emoji
        loadNewEmoji()
    }
}
