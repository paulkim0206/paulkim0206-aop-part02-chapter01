package fastcampus.aop.part2.chapter01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText: EditText = findViewById(R.id.heightEditText)
        val weightEditText = findViewById<EditText>(R.id.weightEditText)
        val resultButton = findViewById<Button>(R.id.resultButton)

        resultButton.setOnClickListener {
            if (heightEditText.text.isEmpty() || weightEditText.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 있습니다.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            //값을 가져오는 변수
            val height: Int = heightEditText.text.toString().toInt()
            val weight: Int = weightEditText.text.toString().toInt()

            val bmi = weight / (height / 100.0).pow(2.0)
            val bmi2 = round(bmi*100)/100
            val resultText = when {
                bmi >= 35.0 -> "고도 비만"
                bmi >= 30.0 -> "중정도 비만"
                bmi >= 25.0 -> "경도 비만"
                bmi >= 23.0 -> "과체중"
                bmi >= 18.5 -> "정상체중"
                else -> "저체중"
            }

            val resultText1 = findViewById<TextView>(R.id.resultBMI)
            val resultText2 = findViewById<TextView>(R.id.resultText)

            resultText1.text = bmi2.toString()
            resultText2.text = "$resultText 입니다."


        }


    }
}