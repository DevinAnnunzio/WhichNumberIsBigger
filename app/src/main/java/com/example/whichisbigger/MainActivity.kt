package com.example.whichisbigger

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var background: View
    private lateinit var leftBtn: Button
    private lateinit var rightBtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        background = findViewById(R.id.backgroundView)
        leftBtn = findViewById(com.example.whichisbigger.R.id.leftBTN)
        rightBtn = findViewById(R.id.rightBTN)

        leftBtn.setOnClickListener{
            checkNumbers(true)
            newNumbers()
        }
        rightBtn.setOnClickListener{
            checkNumbers(false)
            newNumbers()
        }

    }

    private fun checkNumbers(left: Boolean){
        val leftNum = leftBtn.text.toString().toInt()
        val rightNum = rightBtn.text.toString().toInt()
        val leftIsBigger = if (left) leftNum > rightNum else rightNum > leftNum

        if (leftIsBigger){
            background.setBackgroundColor(Color.GREEN)
            Toast.makeText(this, "Nice job!", Toast.LENGTH_SHORT).show()
        } else{
            background.setBackgroundColor(Color.RED)
            Toast.makeText(this, "Incorrect!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun newNumbers(){
        val random = java.util.Random()
        val left = random.nextInt(100)
        var right = random.nextInt(100)

        while(left == right){
            right = random.nextInt(100)
        }

        leftBtn.text = left.toString()
        rightBtn.text = right.toString()
    }

}