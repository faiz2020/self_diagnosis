package com.myapp.selfdiagnosis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        val score = intent.getStringExtra(setData.score.toString())
        val totalQuestion = intent.getStringExtra("total size")



        Score.text = "${score} "
        if (score != null) {
            if (score < 5.toString()) {
                congo.text = "minor symptoms "

                idquote.text = "take the vaccine and stay at home"
            } else {
                idquote.text =
                    "It's Dangerous!! you have severe symptoms of covid-19 Consult with the docter do take care of yourself  "
                congo.text = "Major symptoms"

            }
            if (score < 3.toString()) {
                congo.text = "congratulations"
                idquote.text = "Don't worry!! you have minor symptoms but stay safe"
            }
        }
        button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))

        }
    }
}






