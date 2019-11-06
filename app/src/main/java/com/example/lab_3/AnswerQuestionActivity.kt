package com.example.lab_3

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_answering_question.*
import kotlinx.android.synthetic.main.fragment_input_field_button.*


class AnswerQuestionActivity : AppCompatActivity() {

    companion object {
        const val QUESTION_KEY = "question_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answering_question)
        question_view.text = intent.getStringExtra(QUESTION_KEY)
        ok_button.setOnClickListener {
            val returnIntent = Intent()
            returnIntent.putExtra(MainActivity.ANSWER_KEY, input_field.text.toString())
            setResult(Activity.RESULT_OK, returnIntent)
            finish()
        }
    }
}
