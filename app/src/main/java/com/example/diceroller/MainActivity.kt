package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
    }

    /*
    Roll the dice and update the screen with the result
     */
    private fun rollDice() {
        //create a new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val dice2 = Dice(99)
        val diceRoll = dice.roll()
        val diceRoll2 = dice2.roll()

        //Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView.text = diceRoll.toString()
        resultTextView2.text = diceRoll2.toString()
    }

    class Dice(private val numSides: Int) {
        //This is an actual funtion that "rolls" a int between the numbers 1 and 6(numSides)
        //Randomly
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}