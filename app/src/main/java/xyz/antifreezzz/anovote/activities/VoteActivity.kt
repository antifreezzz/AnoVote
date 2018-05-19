package xyz.antifreezzz.anovote.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.autofill.AutofillId
import android.widget.ImageView
import android.widget.TextView
import xyz.antifreezzz.anovote.R

class VoteActivity : AppCompatActivity() {
    private lateinit var position: TextView
    private lateinit var votingView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vote)
        position = findViewById(R.id.textView)
        votingView = findViewById(R.id.VotingView)

        data class VoteList(val id: Int, val voteListPos: String)

        val layoutManager = LinearLayoutManager(applicationContext)
        votingView.layoutManager = layoutManager

        val voteList = listOf(
                VoteList(1, "Вариант 1"),
                VoteList(2, "Вариант 2"),
                VoteList(3, "Вариант 3"),
                VoteList(4, "Вариант 4")
        )

        //Тестовый код
        val voteAcIntent = intent
        var iPosition = voteAcIntent.getStringExtra("position")

        position.text = iPosition
        ///////////////

    }


}

class RVAdapter : RecyclerView.Adapter<RVAdapter.PersonViewHolder>() {
    class PersonViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var votingView: RecyclerView
        internal var id: Int
        internal var personAge: TextView


        init {
            votingView = itemView.findViewById(R.id.VotingView) as RecyclerView
            id = itemView.findViewById(R.id.VotingView)
            personAge = itemView.findViewById(R.id.person_age)
            personPhoto = itemView.findViewById(R.id.person_photo) as ImageView
        }
    }
}


