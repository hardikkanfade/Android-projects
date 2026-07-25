import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var emojiText: TextView
    private lateinit var inputAnswer: EditText
    private lateinit var feedbackText: TextView
    private lateinit var scoreText: TextView
    private lateinit var topicText: TextView

    private var emojiItems: List<Pair<String, String>> = listOf()
    private var currentEmoji: Pair<String, String>? = null
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize UI elements
        emojiText = findViewById(R.id.emojiText)
        inputAnswer = findViewById(R.id.inputAnswer)
        feedbackText = findViewById(R.id.feedbackText)
        scoreText = findViewById(R.id.scoreText)
        topicText = findViewById(R.id.topicText)

        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener { checkAnswer() }

        // Initialize Emoji Items (Example Topics: Fruits and Movies)
        emojiItems = listOf(
            "🍎🍏" to "Apple",
            "🍌" to "Banana",
            "🦁👑" to "Lion King",
            "🧙‍♂️🪄" to "Harry Potter",
            "🍇🍉" to "Grapes",
            "🐕🦴" to "Dog Bone",
            "🌙⭐" to "Moon Star"
        )

        // Set a topic (Optional, you can add topic selection)
        topicText.text = "Topic: General"

        // Load the first random emoji
        loadNewEmoji()
    }

    private fun loadNewEmoji() {
        // Randomly pick an emoji item
        currentEmoji = emojiItems.random()
        emojiText.text = currentEmoji?.first
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
