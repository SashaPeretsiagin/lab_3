package com.example.lab_2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_answering_question.*


class answering_question : AppCompatActivity() {

    companion object {
        const val QUESTION_KEY = "question_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_answering_question)
        extra_activity_question_view_id.text = intent.getStringExtra(QUESTION_KEY)
        extra_activity_ok_button.setOnClickListener() {
            val intent = put_answer()
            destroy_activity(intent)
        }
    }

    fun put_answer(): Intent {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(MainActivity.ANSWER_KEY, extra_activity_answer_field_id.text.toString())
        return intent
    }

    fun destroy_activity(intent: Intent) {
        setResult(Activity.RESULT_OK, intent)
        finish()
    }

}
