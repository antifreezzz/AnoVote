package xyz.antifreezzz.anovote.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import xyz.antifreezzz.anovote.R
import xyz.antifreezzz.anovote.VoteDataAdapter
import xyz.antifreezzz.anovote.VotePos

class VoteActivity : AppCompatActivity() {
    private lateinit var position: TextView
    lateinit var votingView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vote)
        position = findViewById(R.id.textView)
        votingView = findViewById(R.id.VotingView)


        val layoutManager = LinearLayoutManager(applicationContext)
        votingView.layoutManager = layoutManager

        val voteList = listOf(
                VotePos("Вариант 1"),
                VotePos("Вариант 2"),
                VotePos("Вариант 3"),
                VotePos("Вариант 4")
        )

        var adapter = VoteDataAdapter(voteList)

        votingView.adapter = adapter



        //Тестовый код
        val voteAcIntent = intent
        var iPosition = voteAcIntent.getStringExtra("position")

        position.text = iPosition
        ///////////////

    }


}




