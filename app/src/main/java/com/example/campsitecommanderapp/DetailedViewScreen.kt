package com.example.campsitecommanderapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class DetailedViewScreen : AppCompatActivity() {
    lateinit var edtItemName: EditText
    lateinit var edtCategory: EditText
    lateinit var edtQuantity: EditText
    lateinit var edtComments: EditText
    lateinit var btnSave: Button
    lateinit var txtDisplayList: TextView
    lateinit var btnBackToBase: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)
        // Initializing the Views
        edtItemName = findViewById(R.id.edtItemName)
        edtCategory = findViewById(R.id.edtCategory)
        edtQuantity = findViewById(R.id.edtQuantity)
        edtComments = findViewById(R.id.edtComments)
        btnSave = findViewById(R.id.btnSave)
        txtDisplayList = findViewById(R.id.txtDisplayList)
        btnBackToBase = findViewById(R.id.btnBackToBase)

        // Using putExtra logic
        val mode = intent.getStringExtra("MODE")
        if (mode == "VIEW") {
            btnSave.isEnabled = false // Disables the save in view mode
            edtItemName.visibility = View.GONE
            // This hides the other edit texts as needed
        }

        refreshList()

        // The Input Validation (Error Handling)
        btnSave.setOnClickListener {
            if (edtItemName.text.isEmpty() || edtQuantity.text.toString().toIntOrNull() == null) {
                Toast.makeText(this, "Error: Please Check the inputs", Toast.LENGTH_SHORT).show()
                Log.e("CampsiteCommander", "Invalid input detected")
            } else {
                // Adding to the parallel arrays
                MyData.itemNames.add(edtItemName.text.toString())
                MyData.itemCategories.add(edtCategory.text.toString())
                MyData.itemQuantities.add(edtQuantity.text.toString().toInt())
                MyData.itemComments.add(edtComments.text.toString())

                Toast.makeText(this, "Gear Added!", Toast.LENGTH_SHORT).show()
                refreshList()
            }
        }
        btnBackToBase.setOnClickListener { finish() }
    }

    private fun refreshList() {

        // Using a loop to display the array content
        val sb = StringBuilder()
        for (i in MyData.itemNames.indices) {
            sb.append("${MyData.itemNames[i]} | ${MyData.itemCategories[i]} | Qty: ${MyData.itemQuantities[i]}\n")
            sb.append("Note: ${MyData.itemComments[i]}\n\n")
        }
        txtDisplayList.text = sb.toString()
    }
}

