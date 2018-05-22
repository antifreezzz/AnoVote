package xyz.antifreezzz.anovote.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import xyz.antifreezzz.anovote.Cryptography
import xyz.antifreezzz.anovote.R
import xyz.antifreezzz.anovote.Vote


class MainActivity : AppCompatActivity() {

    private lateinit var createKeys: Button
    private lateinit var keysStatus: TextView
    private lateinit var voteList: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createKeys = findViewById(R.id.createKeys)
        keysStatus = findViewById(R.id.keysStatus)
        createKeys.setOnClickListener(onButtonClickListener)
        voteList = findViewById(R.id.voteList)
        val voteAcIntent = Intent(this, VoteActivity::class.java)

        voteList.onItemClickListener = OnItemClickListener { adapter: AdapterView<*>, view1: View, i: Int, l: Long ->
            adapter.setSelection(i)
            voteAcIntent.putExtra(
                    "position",
                    adapter.getItemIdAtPosition(i).toString()
            )
            startActivity(voteAcIntent)
        }


        val voteList = listOf(
                Vote("FirstVote"),
                Vote("SecondVote"),
                Vote("Third Vote")
        )

        // находим список
        val vote = findViewById<ListView>(R.id.voteList)

        // создаем адаптер
        val adapter = ArrayAdapter<Vote>(this,
                android.R.layout.simple_list_item_1, voteList)

        // присваиваем адаптер списку
        vote.adapter = adapter


    }


    private val onButtonClickListener = View.OnClickListener {
        toast("TestToast")
        Cryptography().keyGenerate()

    }

    private fun toast(text: String) {
        val makeToast = Toast.makeText(this, text, Toast.LENGTH_LONG)
        makeToast.show()
    }

    //Проверка статуса пары ключей (Создана, но не подписана и Создана и подписана
    fun keysStatus() {
        return keysStatus.setText("Ключи созданы, но не подписаны")
    }


}








