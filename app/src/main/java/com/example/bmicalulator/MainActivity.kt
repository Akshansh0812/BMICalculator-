package com.example.bmicalulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //need this two textfield to get the user input, so store in variable
        val weightText = findViewById<EditText>(R.id.etWeight)
        val heightText = findViewById<EditText>(R.id.etHeight)
        // to trigger the operation we need button
        val calcButton = findViewById<Button>(R.id.btnCalculate)

        calcButton.setOnClickListener {
            //get weight and height input values in string format
            val weight = weightText.text.toString()
            val height = heightText.text.toString()

            // calculating bmi
            if(validateInput(weight,height)) {
                val bmi = weight.toFloat() / ((height.toFloat() / 100) * (height.toFloat() / 100))
                val bmi2Digits = String.format("%.2f", bmi).toFloat()
                displayResult(bmi2Digits)
            }
        }
    }
    // if user does not provide inputs
    private fun validateInput(weight:String? , height:String?):Boolean{
        return when{
            weight.isNullOrEmpty() ->{
                Toast.makeText(this,"Weight is empty", Toast.LENGTH_LONG).show()
                return false
            }
            height.isNullOrEmpty() ->{
                Toast.makeText(this,"Height is empty", Toast.LENGTH_LONG).show()
                return false
            }
            else ->{
                return true
            }
        }
    }

    private fun displayResult(bmi:Float){
        val resultIndex = findViewById<TextView>(R.id.tvIndex)
        val resultDescription = findViewById<TextView>(R.id.tvResult)
        val info = findViewById<TextView>(R.id.tvInfo)

        resultIndex.text = bmi.toString()
        info.text = "(Normal range is 18.5 to 24.9)"

        var resultText = ""
        var color = 0

        when {
            bmi<18.50 ->{
                resultText = "Underweight"
                color = R.color.under_weight
            }
            bmi in 18.50..24.99 ->{
                resultText = "Healthy"
                color = R.color.normal
            }
            bmi in 25.00..29.99 ->{
                resultText = "Overweight"
                color = R.color.over_weight
            }
            bmi>29.99 ->{
                resultText = "Obese"
                color = R.color.obese
            }
        }
        // to change the color of the textview
        resultDescription.setTextColor(ContextCompat.getColor(this,color))
        resultDescription.text = resultText
    }
}
// designing part
// add 3 colors (values->colors)
// add bg colour to the layout (search bg->bg->color->layout_bg)
// removing section bar(themes->themes.xml and themes.xml.night) then change the DarkActionBar to NoActionBar
// add card view present in container then set constraints
// give id to card view and set corner radius and elevation and change card bg color
// change the title bar color (values->themes->in both files change colorPrimaryVariant wala part to layout_background
// then add textview in card
// make another card view for the height (exact same as for weight)
// then make calculate button
// make another card view for showing info to user(use vertical layout)



