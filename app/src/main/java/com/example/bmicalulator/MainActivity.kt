package com.example.bmicalulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

//add 3 colors (values->colors)
// add bg colour to the layout (search bg->bg->color->layout_bg)
// removing section bar(themes->themes.xml and themes.xml.night) then change the DarkActionBar to NoActionBar
// add card view present in container then set constraints
// give id to card view and set cornerradius and elevation and change card bg color
// change the title bar color (values->themes->in both files change colorPrimaryVariant wala part to layout_background


