package com.loogibot.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        val rollButton2: Button = findViewById(R.id.button2)
        rollButton2.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        val dice = Dice(6)
        // creates a new dice from Dice() class, with 6 Int as numSides
        val diceRoll = dice.roll()
        // creates a roll by calling the roll() method/fun in Dice(), which returns a random(Int) with range 1..numSides

        val resultTextView: TextView = findViewById(R.id.textView)
        // finds textView with id, and assigns it to a new resultTextView val, updating the screen with the dice roll
        resultTextView.text = diceRoll.toString()
        // turns diceRoll Int to String

        val dice2 = Dice(6)
        val diceRoll2 = dice.roll()
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView2.text = diceRoll2.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}