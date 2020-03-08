package com.example.android.diceroller

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionManager
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.android.diceroller.R.layout.die_faces_menu
import com.example.android.diceroller.R.layout.roll_mode_menu
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var mContext: Context? = null
    private var mActivity: Activity? = null
    private var mRelativeLayout: RelativeLayout? = null
    private val mButton: Button? = null
    private val mPopupWindow: PopupWindow? = null

    var selectedDie = String()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //listener: ROLL BUTTON
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        //function: CHANGE DIE TYPE BUTTON
        changeDiceButton.setOnClickListener{
            // inflate the die type popup
            val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val dieFaces = inflater.inflate(die_faces_menu,null)
            val popupWindow = PopupWindow(
                dieFaces, // die type view to show in popup window
                LinearLayout.LayoutParams.WRAP_CONTENT, // Width of popup window
                LinearLayout.LayoutParams.WRAP_CONTENT // Window height
            )

            // how much shadow underneath the popup window
            popupWindow.elevation = 50.0F

            // animations for the pop up window
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val slideIn = Slide()
                slideIn.slideEdge = Gravity.TOP
                popupWindow.enterTransition = slideIn
                val slideOut = Slide()
                slideOut.slideEdge = Gravity.TOP
                popupWindow.exitTransition = slideOut
            }

            //apply the preferences once apply is tapped
            val applyButton = dieFaces.findViewById<Button>(R.id.dieFacesApply_Button)
            applyButton.setOnClickListener{
                // Dismiss the popup window
                popupWindow.dismiss()
            }

            // show a toast to confirm the window closed
            popupWindow.setOnDismissListener {
                Toast.makeText(applicationContext,"Popup closed",Toast.LENGTH_SHORT).show()
            }

            // Show the pop up
            TransitionManager.beginDelayedTransition(mainLayout)
            popupWindow.showAtLocation(
                mainLayout, // Location to display popup window
                Gravity.CENTER, // Exact position of layout to display popup
                0, // X offset
                0 // Y offset
            )
        }

        //function: ROLL MODE BUTTON
        rollModeButton.setOnClickListener{
            // inflate the roll mode popup
            val inflater: LayoutInflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rollMode = inflater.inflate(roll_mode_menu,null)
            val popupWindow = PopupWindow(
                rollMode, // die type view to show in popup window
                LinearLayout.LayoutParams.WRAP_CONTENT, // Width of popup window
                LinearLayout.LayoutParams.WRAP_CONTENT // Window height
            )

            // how much shadow underneath the popup window
            popupWindow.elevation = 50.0F

            // animations for the pop up window
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val slideIn = Slide()
                slideIn.slideEdge = Gravity.TOP
                popupWindow.enterTransition = slideIn
                val slideOut = Slide()
                slideOut.slideEdge = Gravity.TOP
                popupWindow.exitTransition = slideOut
            }

            //apply the preferences once apply is tapped
            val applyButton = rollMode.findViewById<Button>(R.id.rollModeApply_Button)
            applyButton.setOnClickListener{
                // Dismiss the popup window
                popupWindow.dismiss()
            }

            // show a toast to confirm the window closed
            popupWindow.setOnDismissListener {
                Toast.makeText(applicationContext,"Popup closed",Toast.LENGTH_SHORT).show()
            }

            // Show the pop up
            TransitionManager.beginDelayedTransition(mainLayout)
            popupWindow.showAtLocation(
                mainLayout, // Location to display popup window
                Gravity.CENTER, // Exact position of layout to display popup
                0, // X offset
                0 // Y offset
            )
        }

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

