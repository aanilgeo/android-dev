package com.example.tapcounterapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private var counter = 0
    private var goal = 100
    private var tapIncrement = 1
    private var currentUpgradeValue = 2
    private var isDogTheme = false
    private var isCustomIconUnlocked = false
    private var goalsReached = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tapButton = findViewById<ImageButton>(R.id.tapButton)
        val upgradeButton = findViewById<Button>(R.id.upgradeBtn)
        val themeSwitchBtn = findViewById<Button>(R.id.themeSwitchBtn)
        val customIconButton = findViewById<Button>(R.id.customIconBtn)
        val mainLayout = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
        val textView = findViewById<TextView>(R.id.textView)
        val goalTextView = findViewById<TextView>(R.id.goalTextView)
        val goalsReachedTextView = findViewById<TextView>(R.id.goalsReachedTextView)

        customIconButton.visibility = View.INVISIBLE
        upgradeButton.visibility = View.INVISIBLE

        goalTextView.text = getString(R.string.goal_text, goal)
        goalsReachedTextView.text = getString(R.string.goals_reached, goalsReached)

        tapButton.setOnClickListener {
            counter += tapIncrement
            textView.text = counter.toString()

            if (counter >= goal) {
                goalsReached++
                goalsReachedTextView.text = getString(R.string.goals_reached, goalsReached)

                upgradeButton.visibility = View.VISIBLE

                if (counter >= 100 && !isCustomIconUnlocked) {
                    customIconButton.visibility = View.VISIBLE
                }

                goal += 100
                goalTextView.text = getString(R.string.next_goal_text, goal)
            }
        }

        upgradeButton.setOnClickListener {
            if (counter >= goal - 100) {
                Toast.makeText(this, getString(R.string.upgrade_purchased, currentUpgradeValue), Toast.LENGTH_SHORT).show()
                tapIncrement = currentUpgradeValue
                currentUpgradeValue += 2
                upgradeButton.text = getString(R.string.upgrade_purchased, currentUpgradeValue)
                upgradeButton.visibility = View.INVISIBLE
            } else {
                Toast.makeText(this, getString(R.string.not_enough_taps, goal - 100), Toast.LENGTH_SHORT).show()
            }
        }

        customIconButton.setOnClickListener {
            if (!isCustomIconUnlocked) {
                tapButton.setImageResource(R.drawable.heart_filled)
                Toast.makeText(this, getString(R.string.custom_icon_unlocked), Toast.LENGTH_SHORT).show()
                isCustomIconUnlocked = true
                customIconButton.visibility = View.INVISIBLE
            }
        }

        themeSwitchBtn.setOnClickListener {
            if (!isDogTheme) {
                mainLayout.setBackgroundResource(R.drawable.dog_background)
                tapButton.setImageResource(R.drawable.paw_print)
                themeSwitchBtn.text = getString(R.string.switch_to_default_theme)
                changeTextColorsToWhite(textView, goalTextView, goalsReachedTextView)
                isDogTheme = true
                Toast.makeText(this, getString(R.string.dog_theme_activated), Toast.LENGTH_SHORT).show()
            } else {
                mainLayout.setBackgroundResource(R.drawable.sky_background)
                tapButton.setImageResource(if (isCustomIconUnlocked) R.drawable.heart_filled else R.drawable.heart_empty)
                themeSwitchBtn.text = getString(R.string.switch_to_dog_theme)
                changeTextColorsToBlack(textView, goalTextView, goalsReachedTextView)
                isDogTheme = false
                Toast.makeText(this, getString(R.string.default_theme_activated), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun changeTextColorsToWhite(vararg textViews: TextView) {
        for (textView in textViews) {
            textView.setTextColor(ContextCompat.getColor(this, android.R.color.white))
        }
    }

    private fun changeTextColorsToBlack(vararg textViews: TextView) {
        for (textView in textViews) {
            textView.setTextColor(ContextCompat.getColor(this, android.R.color.black))
        }
    }
}











