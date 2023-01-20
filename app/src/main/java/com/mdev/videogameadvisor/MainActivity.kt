package com.mdev.videogameadvisor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val findGameButton = findViewById<Button>(R.id.find_game)

        // This is a lambda
        findGameButton.setOnClickListener {
            // 1. Get a reference to the spinner
            val findGameChoiceSpinner = findViewById<Spinner>(R.id.game_choice)
            // 2. Get the selected item in the spinner
            val selectedGenre = findGameChoiceSpinner.selectedItem
            // 2b. Get the list of games based on the Genre selected
            val gameList = getGames(selectedGenre.toString())
            // 2c. Modify the list to include new line characters
            val games = gameList.reduce { str, item -> str + '\n' + item}
            // 2d. Add a description for the selected Genre
            val gameDescription = getSpinnerDescription(selectedGenre.toString())
            // 3. Get a reference to the TextView
            val gamesText = findViewById<TextView>(R.id.games)
            // 4. Update the text to reflect the item selected in the spinner
            gamesText.text = games
            // 6. Get a reference to Description TextView
            val descriptionText = findViewById<TextView>(R.id.description)
            // 7. Update the description text to describe the selected genre
            descriptionText.text = gameDescription
        }
    }

    fun getGames(genre: String) : List<String> {
        return when (genre) {
            "Action" -> listOf("- Legend of Zelda", "- Grand Theft Auto 5")
            "Adventure" -> listOf("- Final Fantasy", "- Elden Ring")
            "Strategy" -> listOf("- Age of Empire", "- StarCraft")
            "Sports" -> listOf("- FIFA", "- NBA2K23")
            "RPG" -> listOf<String>("- Pokemon", "- Chrono Trigger")
            else -> listOf("- Super Mario", "- Metroid")
        }
    }

    fun getSpinnerDescription(genre: String): String {
        return when (genre) {
            "Action" -> "An action game is a video game genre that emphasizes physical challenges, including hand–eye coordination and reaction-time"
            "Adventure" -> "A type of video game in which the participant plays a fantasy role in an episodic adventure story."
            "Strategy" -> "A strategy game is a game in which the players' uncoerced, and often autonomous, decision-making skills have a high significance in determining the outcome."
            "Sports" -> "A sports video game is a video game that simulates the practice of sports."
            "RPG" -> "A role-playing game is a game in which players assume the roles of characters in a fictional setting."
            else -> ""
        }
    }
}