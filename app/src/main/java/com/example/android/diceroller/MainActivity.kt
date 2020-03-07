package com.example.android.diceroller

import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var selectedDie = String()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        //access & store the list of dice from the string resources
        val diceList = resources.getStringArray(R.array.diceTypes_array)

        //access the spinner
        val spinner = findViewById<Spinner>(R.id.diceTypes_spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, diceList)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                    selectedDie = diceList[position]

                    Toast.makeText(this@MainActivity,
                        getString(R.string.selected_dice) + " " +
                                "" + selectedDie, Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    private fun rollDice(){
        when (selectedDie) {
            "d4" -> {val randomInt = (1..4).random()
                val resultText: TextView = findViewById(R.id.result_text)
                resultText.text = randomInt.toString()}
            "d6" -> {val randomInt = (1..6).random()
                val resultText: TextView = findViewById(R.id.result_text)
                resultText.text = randomInt.toString()}
            "d8" -> {val randomInt = (1..8).random()
                val resultText: TextView = findViewById(R.id.result_text)
                resultText.text = randomInt.toString()}
            "d10" -> {val randomInt = (1..10).random()
                val resultText: TextView = findViewById(R.id.result_text)
                resultText.text = randomInt.toString()}
            "d12" -> {val randomInt = (1..12).random()
                val resultText: TextView = findViewById(R.id.result_text)
                resultText.text = randomInt.toString()}
            "d20" -> {val randomInt = (1..20).random()
                val resultText: TextView = findViewById(R.id.result_text)
                resultText.text = randomInt.toString()}
            "d100" -> {val randomInt = (1..100).random()
                val resultText: TextView = findViewById(R.id.result_text)
                resultText.text = randomInt.toString()}
        }
    }
}

