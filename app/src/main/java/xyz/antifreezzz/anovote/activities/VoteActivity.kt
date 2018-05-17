package xyz.antifreezzz.anovote.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import xyz.antifreezzz.anovote.R

class VoteActivity : AppCompatActivity() {
    private lateinit var position: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vote)
        position = findViewById(R.id.textView)

        val voteAcIntent = intent
        var iPosition = voteAcIntent.getStringExtra("position")

        position.text = iPosition


    }


}
