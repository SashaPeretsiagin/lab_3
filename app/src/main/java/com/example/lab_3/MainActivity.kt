package com.example.lab_3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_input_field_button.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val ANSWER_KEY = "answer"
        const val ANSWERING_ACTIVITY_REQUEST_CODE = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        ok_button.setOnClickListener {
            val questionIntent = Intent(this, AnswerQuestionActivity::class.java);
            val question = input_field.text.toString()
            questionIntent.putExtra(AnswerQuestionActivity.QUESTION_KEY, question)
            startActivityForResult(questionIntent, ANSWERING_ACTIVITY_REQUEST_CODE)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == ANSWERING_ACTIVITY_REQUEST_CODE)
            if(resultCode == Activity.RESULT_OK)
                if(data != null)
                    answer_view.text = data.getStringExtra(ANSWER_KEY)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
