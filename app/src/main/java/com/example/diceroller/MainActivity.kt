package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

/*
This activity allows users to roll a dice and view the result on screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

        // Do a dice roll when the app starts
        rollDice()
    }

    /*
    Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        //create a new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()


        //Update the screen with the dice roll
        //Usng ImageView in the Layout
        val diceImage: ImageView = findViewById(R.id.imageView)
        // Determine the source ID to use based on when the dice rolls
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //Update the ImageView with the right source ID
        diceImage.setImageResource(drawableResource)
        /*This code calls the `setImageResource()` method on the `ImageView`,
         passing the resource ID for the `dice_2` image. This will update the `ImageView`
          on screen to display the `dice_2` image.
         */
        diceImage.contentDescription = diceRoll.toString()
    }


    class Dice(private val numSides: Int) {
        //This is an actual funtion that "rolls" a int between the numbers 1 and 6(numSides)
        //Randomly
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}