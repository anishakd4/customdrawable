package com.example.customdrawable

import android.R
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatToggleButton


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val image: ImageView = findViewById(R.id.image) as ImageView
        val button = findViewById(R.id.button) as AppCompatToggleButton
        button.setOnClickListener {
            val drawable = image.getDrawable()
            if (button.isChecked) {
                drawable.startTransition(500)
            } else {
                drawable.reverseTransition(500)
            }
        }
    }
}