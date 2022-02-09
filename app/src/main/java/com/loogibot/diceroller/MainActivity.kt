package com.loogibot.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
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

        //Do a dice roll when the app start
        rollDice()

    }

    /**
     * Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        val dice = Dice(6)
        // creates a new dice from Dice() class, with 6 Int as numSides
        val diceRoll = dice.roll()
        // creates a roll by calling the roll() method/fun in Dice(), which returns a random(Int) with range 1..numSides

        val diceImage: ImageView = findViewById(R.id.imageView)
        // finds imageview with id, and assigns it to a new diceroll val, updating the screen with the dice roll

        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        // sets the image to dice
        diceImage.contentDescription = diceRoll.toString()

        val toast = Toast.makeText(applicationContext, diceRoll.toString(), Toast.LENGTH_SHORT)
        toast.show()

}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
}

