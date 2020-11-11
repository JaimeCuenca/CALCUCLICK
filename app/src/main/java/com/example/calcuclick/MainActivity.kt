package com.example.calcuclick

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Bresta = findViewById<Button>(R.id.buttonR)
        val Bsuma = findViewById<Button>(R.id.buttonS)
        val result = findViewById<TextView>(R.id.result)
        val input = findViewById<TextView>(R.id.input)

        Bsuma.setOnClickListener(){
            var num : Int = result.text.toString().toInt()
            num++
            result.setText(num.toString())
            Bsuma.setBackgroundColor(Color.MAGENTA)
            Bresta.setBackgroundColor(Color.MAGENTA)
        }

        Bresta.setOnClickListener(){
            var num : Int = result.text.toString().toInt()
            num--
            if(num>=0){
                result.setText(num.toString())
                Bsuma.setBackgroundColor(Color.MAGENTA)
                Bresta.setBackgroundColor(Color.MAGENTA)
            }
        }

       input.setOnFocusChangeListener { v, hasFocus ->
           if(hasFocus) {
               Bsuma.setBackgroundColor(Color.GRAY)
               Bresta.setBackgroundColor(Color.GRAY)
           }else{
               Bsuma.setBackgroundColor(Color.BLACK)
               Bresta.setBackgroundColor(Color.BLACK)
           }
       }

        input.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if (it.isNotEmpty()) {
                        result.text = it
                    }
                }
            }

        })
    }
}