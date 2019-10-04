package com.example.lab_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.BoringLayout
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val ANSWER_KEY = "answer"
        const val ANSWERING_ACTIVITY_REQUEST_CODE = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        ok_button_id.setOnClickListener() {
            sendQuestion()
        }
    }

    fun sendQuestion() {
        val questionIntent = Intent(this, answering_question::class.java)
        val question = question_field_id.text.toString()
        questionIntent.putExtra(answering_question.QUESTION_KEY, question)
        startActivityForResult(questionIntent, ANSWERING_ACTIVITY_REQUEST_CODE)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun check_code(requestCode: Int, resultCode: Int): Boolean {
        return (requestCode == ANSWERING_ACTIVITY_REQUEST_CODE)
                && (resultCode == Activity.RESULT_OK)
    }

    private fun add_answer(data: Intent?) {
        if(data != null) {
            answer_view_id.text = data.getStringExtra(ANSWER_KEY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(check_code(requestCode, resultCode))
            this.add_answer(data)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
