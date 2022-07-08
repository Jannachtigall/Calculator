package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.point).setOnClickListener { setTextFields(".") }
        findViewById<TextView>(R.id.zero).setOnClickListener { setTextFields("0") }
        findViewById<TextView>(R.id.one).setOnClickListener { setTextFields("1") }
        findViewById<TextView>(R.id.two).setOnClickListener { setTextFields("2") }
        findViewById<TextView>(R.id.three).setOnClickListener { setTextFields("3") }
        findViewById<TextView>(R.id.four).setOnClickListener { setTextFields("4") }
        findViewById<TextView>(R.id.five).setOnClickListener { setTextFields("5") }
        findViewById<TextView>(R.id.six).setOnClickListener { setTextFields("6") }
        findViewById<TextView>(R.id.seven).setOnClickListener { setTextFields("7") }
        findViewById<TextView>(R.id.eigth).setOnClickListener { setTextFields("8") }
        findViewById<TextView>(R.id.nine).setOnClickListener { setTextFields("9") }
        findViewById<TextView>(R.id.minus).setOnClickListener { setTextFields("-") }
        findViewById<TextView>(R.id.plus).setOnClickListener { setTextFields("+") }
        findViewById<TextView>(R.id.multiplication).setOnClickListener { setTextFields("*") }
        findViewById<TextView>(R.id.slash).setOnClickListener { setTextFields("/") }
        findViewById<TextView>(R.id.left_skobka).setOnClickListener { setTextFields("(") }
        findViewById<TextView>(R.id.right_skobka).setOnClickListener { setTextFields(")") }
        findViewById<TextView>(R.id.AC).setOnClickListener {
            findViewById<TextView>(R.id.math_operation).text = ""
            findViewById<TextView>(R.id.result_text).text = ""
        }
        findViewById<TextView>(R.id.Deleting).setOnClickListener {
            val str = findViewById<TextView>(R.id.math_operation).text.toString()
            if(str.isNotEmpty()) findViewById<TextView>(R.id.math_operation).text = str.substring(0, str.length-1)
            findViewById<TextView>(R.id.result_text).text = ""
        }

        findViewById<TextView>(R.id.equally).setOnClickListener {
            try {
                val ex = ExpressionBuilder(findViewById<TextView>(R.id.math_operation).text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    findViewById<TextView>(R.id.result_text).text = longRes.toString()
                else
                    findViewById<TextView>(R.id.result_text).text = result.toString()
            } catch (e:Exception){
                findViewById<TextView>(R.id.result_text).text = "Неверный формат данных!"
                Log.d("Ошибка", "сообщение: ${e.message}")
            }
        }

    }

    fun cleanResult(){
        findViewById<TextView>(R.id.result_text).text = ""
    }

    @SuppressLint("CutPasteId")
    fun setTextFields(str: String){
        if (findViewById<TextView>(R.id.result_text).text != "" &&
            findViewById<TextView>(R.id.result_text).text != "Неверный формат данных!"){
            findViewById<TextView>(R.id.math_operation).text = findViewById<TextView>(R.id.result_text).text
            cleanResult()
        }
        if (findViewById<TextView>(R.id.result_text).text == "Неверный формат данных!"){
            findViewById<TextView>(R.id.math_operation).text = ""
            cleanResult()
        }

        findViewById<TextView>(R.id.math_operation).append(str)
    }
}