package com.example.campsitecommanderapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

// The Helper object for parallel arrays to keep the data consistent across activities
object MyData {
    var itemNames = arrayListOf("Tent", "Marshmallows","Flashlight" )
    var itemCategories = arrayListOf("Shelter", "Food", "Safety"  )
    var itemQuantities = arrayListOf(1, 3, 2, )
    var itemComments = arrayListOf("4-person waterproof", "For S'mores (Mega size)", "Check batteries (AA)")
}


class MainScreen : AppCompatActivity() {
    lateinit var txtTotalItems: TextView
    lateinit var btnAdd: Button
    lateinit var btnView: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)


        txtTotalItems = findViewById(R.id.txtTotalItems)
        btnAdd = findViewById(R.id.btnAdd)
        btnView = findViewById(R.id.btnView)

        btnAdd.setOnClickListener {
            val intent = Intent(this, DetailedViewScreen::class.java)
            intent.putExtra("MODE", "ADD")
            startActivity(intent)
        }

        btnView.setOnClickListener {
            val intent = Intent(this, DetailedViewScreen::class.java)
            intent.putExtra("MODE", "VIEW")
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        var total = 0
        for (q in MyData.itemQuantities) { total += q }
        txtTotalItems.text = "Total Items Packed: $total"
    }
}
