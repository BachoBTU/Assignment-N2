package com.example.assignmentn2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1 = findViewById<EditText>(R.id.editTextNumber)
        val num2 = findViewById<EditText>(R.id.editTextNumber2)

        val plusbtn = findViewById<Button>(R.id.button1)
        val minusbtn = findViewById<Button>(R.id.button2)
        val multibtn = findViewById<Button>(R.id.button3)
        val divbtn = findViewById<Button>(R.id.button4)

        fun clearfields () {
            num1.setText("")
            num2.setText("")
        }

        plusbtn.setOnClickListener{
            val firstnum = num1.text.toString()
            val secondnum = num2.text.toString()

            if(firstnum != "" && secondnum != "") {
                val result = firstnum.toInt() + secondnum.toInt()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("RESULT", result.toString())
                startActivity(intent)

                clearfields()
            }
        }

        minusbtn.setOnClickListener{
            val firstnum = num1.text.toString()
            val secondnum = num2.text.toString()

            if(firstnum != "" && secondnum != "") {
                val result = firstnum.toInt() - secondnum.toInt()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("RESULT", result.toString())
                startActivity(intent)

                clearfields()
            }
        }

        multibtn.setOnClickListener{
            val firstnum = num1.text.toString()
            val secondnum = num2.text.toString()

            if(firstnum != "" && secondnum != "") {
                val result = firstnum.toInt() * secondnum.toInt()
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("RESULT", result.toString())
                startActivity(intent)

                clearfields()
            }
        }

        divbtn.setOnClickListener{
            val firstnum = num1.text.toString()
            val secondnum = num2.text.toString()

            if(firstnum != "" && secondnum != "") {
                if (secondnum.toInt() != 0) {
                    val result: Double = firstnum.toDouble() / secondnum.toDouble()
                    val round: Double = String.format("%.2f", result).toDouble()
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("RESULT", round.toString())
                    startActivity(intent)
                    clearfields()
                } else {
                    val result = "ERROR"
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("RESULT", result)
                    startActivity(intent)

                    clearfields()
                }
            }
        }

    }
}