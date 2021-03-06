package xyz.antifreezzz.anovote.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import xyz.antifreezzz.anovote.R
import xyz.antifreezzz.anovote.VoteDataAdapter
import xyz.antifreezzz.anovote.VoteItemClickListener
import xyz.antifreezzz.anovote.VotePos


class VoteActivity : AppCompatActivity() {
    private lateinit var position: TextView
    lateinit var votingView: RecyclerView
    lateinit var cancelBtn: Button
    lateinit var confirmBtn: Button
    lateinit var mainActivityIntent: Intent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vote)

        val actionBar = supportActionBar
        (actionBar ?: throw NullPointerException("Expression 'actionBar' must not be null")).setHomeButtonEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)



        confirmBtn = findViewById(R.id.confirmBtn)
        cancelBtn = findViewById(R.id.cancelBtn)


        confirmBtn.setOnClickListener(onConfirmButtonClickListener)
        cancelBtn.setOnClickListener(onCancelButtonClickListener)

        mainActivityIntent = Intent(this, MainActivity::class.java)



        val rv = findViewById<RecyclerView>(R.id.recyclerView1)
        rv.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val voteList = listOf(
                VotePos("Вариант 1"),
                VotePos("Вариант 2"),
                VotePos("Вариант 3"),
                VotePos("Вариант 4")
        )

        val adapter = VoteDataAdapter(voteList)

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

    private val onCancelButtonClickListener = View.OnClickListener {
        val makeToast = Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT)
        makeToast.show()
        startActivity(mainActivityIntent)
    }
    private val onConfirmButtonClickListener = View.OnClickListener {
        //todo confirm vote and send to server
        val makeToast = Toast.makeText(this, "Confirm", Toast.LENGTH_SHORT)
        makeToast.show()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}




