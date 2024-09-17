package com.example.wordle

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import nl.dionsegijn.konfetti.KonfettiView

class MainActivity : AppCompatActivity() {
    private var wordToGuess: String = FourLetterWordList.getRandomFourLetterWord()
    private var attempts = 0
    private var correctStreak = 0  // To track the user's streak

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputField: EditText = findViewById(R.id.etEnteredWord)
        val checkButton: Button = findViewById(R.id.btnCheck)
        val restartButton: Button = findViewById(R.id.btnRestart)
        val correctWordView: TextView = findViewById(R.id.tvCorrectWord)

        checkButton.setOnClickListener {
            val guess = inputField.text.toString().uppercase()
            if (guess.length == 4 && isAlpha(guess)) {
                handleGuess(guess)
                inputField.setText("")
            } else {
                Toast.makeText(this, "Please enter a valid 4-letter word!", Toast.LENGTH_SHORT).show()
            }
        }

        restartButton.setOnClickListener {
            restartGame()
        }
    }

    private fun handleGuess(guess: String) {
        attempts++

        val guessedWordView: TextView
        val checkResultView: TextView

        when (attempts) {
            1 -> {
                guessedWordView = findViewById(R.id.tvFirstGuessed)
                checkResultView = findViewById(R.id.tvFirstCheck)
            }
            2 -> {
                guessedWordView = findViewById(R.id.tvSecondGuessed)
                checkResultView = findViewById(R.id.tvSecondCheck)
            }
            3 -> {
                guessedWordView = findViewById(R.id.tvThirdGuessed)
                checkResultView = findViewById(R.id.tvThirdCheck)
            }
            else -> {
                endGame()
                return
            }
        }

        guessedWordView.text = guess
        guessedWordView.visibility = View.VISIBLE

        val result = checkGuess(guess)
        checkResultView.setText(result, TextView.BufferType.SPANNABLE)
        checkResultView.visibility = View.VISIBLE

        if (result.toString() == "OOOO") {
            endGame(true)
        } else if (attempts == 3) {
            endGame(false)
        }
    }

    // Check guess correctness using Spannables for colored text
    private fun checkGuess(guess: String): SpannableStringBuilder {
        val builder = SpannableStringBuilder()

        for (i in guess.indices) {
            val letterSpan = SpannableString(guess[i].toString())
            when {
                guess[i] == wordToGuess[i] -> {
                    letterSpan.setSpan(ForegroundColorSpan(Color.GREEN), 0, 1, 0)
                }
                guess[i] in wordToGuess -> {
                    letterSpan.setSpan(ForegroundColorSpan(Color.YELLOW), 0, 1, 0)
                }
                else -> {
                    letterSpan.setSpan(ForegroundColorSpan(Color.RED), 0, 1, 0)
                }
            }
            builder.append(letterSpan)
        }
        return builder
    }

    // Handle game end logic and display confetti if the user wins
    private fun endGame(playerWon: Boolean = false) {
        val correctWordView: TextView = findViewById(R.id.tvCorrectWord)
        val checkButton: Button = findViewById(R.id.btnCheck)
        val restartButton: Button = findViewById(R.id.btnRestart)

        correctWordView.text = "The correct word was: $wordToGuess"
        correctWordView.visibility = View.VISIBLE
        checkButton.isEnabled = false
        restartButton.visibility = View.VISIBLE

        if (playerWon) {
            correctStreak++
            startConfetti()
            Toast.makeText(this, "Congratulations! You guessed the word!", Toast.LENGTH_LONG).show()
        } else {
            correctStreak = 0
            Toast.makeText(this, "Game over! Better luck next time.", Toast.LENGTH_LONG).show()
        }
    }

    // Start confetti animation
    private fun startConfetti() {
        val konfettiView = findViewById<KonfettiView>(R.id.viewKonfetti)
        konfettiView.build()
            .addColors(Color.RED, Color.GREEN, Color.YELLOW)
            .setDirection(0.0, 359.0)
            .setSpeed(1f, 5f)
            .setFadeOutEnabled(true)
            .setTimeToLive(2000L)
            .addShapes(nl.dionsegijn.konfetti.models.Shape.RECT, nl.dionsegijn.konfetti.models.Shape.CIRCLE)
            .addSizes(nl.dionsegijn.konfetti.models.Size(12))
            .setPosition(-50f, konfettiView.width + 50f, -50f, -50f)
            .streamFor(300, 5000L)
    }

    // Reset the game and clear all guesses
    private fun restartGame() {
        wordToGuess = FourLetterWordList.getRandomFourLetterWord()
        attempts = 0

        // Reset visibility of views
        findViewById<TextView>(R.id.tvFirstGuessed).visibility = View.INVISIBLE
        findViewById<TextView>(R.id.tvFirstCheck).visibility = View.INVISIBLE
        findViewById<TextView>(R.id.tvSecondGuessed).visibility = View.INVISIBLE
        findViewById<TextView>(R.id.tvSecondCheck).visibility = View.INVISIBLE
        findViewById<TextView>(R.id.tvThirdGuessed).visibility = View.INVISIBLE
        findViewById<TextView>(R.id.tvThirdCheck).visibility = View.INVISIBLE
        findViewById<TextView>(R.id.tvCorrectWord).visibility = View.INVISIBLE
        findViewById<Button>(R.id.btnCheck).isEnabled = true
        findViewById<Button>(R.id.btnRestart).visibility = View.GONE
    }

    // Helper function to ensure only alphabets are used
    private fun isAlpha(str: String): Boolean {
        return str.all { it.isLetter() }
    }
}
