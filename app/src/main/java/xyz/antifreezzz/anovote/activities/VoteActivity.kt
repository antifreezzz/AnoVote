package xyz.antifreezzz.anovote.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import xyz.antifreezzz.anovote.R
import xyz.antifreezzz.anovote.VoteDataAdapter
import xyz.antifreezzz.anovote.VotePos
import xyz.antifreezzz.anovote.VoteItemClickListener





class VoteActivity : AppCompatActivity() {
    private lateinit var position: TextView
    lateinit var votingView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vote)

        val rv = findViewById<RecyclerView>(R.id.recyclerView1)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val voteList = listOf(
                VotePos("Вариант 1"),
                VotePos("Вариант 2"),
                VotePos("Вариант 3"),
                VotePos("Вариант 4")
        )

        var adapter = VoteDataAdapter(voteList)

        rv.adapter = adapter


        rv.addOnItemTouchListener(
                VoteItemClickListener(this, rv, object : VoteItemClickListener.OnItemClickListener {
                    override fun onItemClick(view: View, position: Int) {
                        println("OnItemClick")
                    }

                    override fun onLongItemClick(view: View?, position: Int) {
                        println("LongClick")
                    }
                })
        )

    }


}




