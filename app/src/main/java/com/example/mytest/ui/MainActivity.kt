package com.example.mytest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mytest.R
import com.example.mytest.data.TestAPI
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val catAPI = TestAPI()

        findViewById<Button>(R.id.interesting_button)
            .setOnClickListener {
                GlobalScope.launch {
                    catAPI.getFiles()
                }
            }
    }
}