package com.example.imadassignment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.example.imad_assignment.R

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize UI components from the layout
        val timeInput = findViewById<EditText>(R.id.etTimeInput)
        val sparkButton = findViewById<Button>(R.id.btnSpark)
        val suggestionText = findViewById<TextView>(R.id.tvSuggestion)
        val resetButton = findViewById<Button>(R.id.btnReset)

        // Social Spark Suggestion Logic:
        // Provides a suggestion based on the user-entered time of day.
        sparkButton.setOnClickListener {
            val timeOfDay = timeInput.text.toString().trim().lowercase()

            if (timeOfDay == "morning") {
                suggestionText.text = "Send a 'Good morning' text to a family member."
            } else if (timeOfDay == "mid-morning") {
                suggestionText.text = "Reach out to a colleague with a quick 'Thank you.'"
            } else if (timeOfDay == "afternoon") {
                suggestionText.text = "Share a funny meme or interesting link with a friend."
            } else if (timeOfDay == "afternoon snack time") {
                suggestionText.text = "Send a quick 'thinking of you' message."
            } else if (timeOfDay == "dinner") {
                suggestionText.text = "Call a friend or relative for a 5-minute catch-up."
            } else if (timeOfDay == "after dinner" || timeOfDay == "night") {
                suggestionText.text = "Leave a thoughtful comment on a friend's post."
            } else {
                suggestionText.text = "Please enter a valid time of day (Morning, Mid-morning, Afternoon, Afternoon Snack Time, Dinner, After Dinner/Night)"
            }
        }

        // Reset Button Logic:
        // Clears the input field and the suggestion text.
        resetButton.setOnClickListener {
            timeInput.text.clear()
            suggestionText.text = ""
        }
    }
}
