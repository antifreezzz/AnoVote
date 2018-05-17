package xyz.antifreezzz.anovote.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.ArrayAdapter
import java.security.GeneralSecurityException
import java.security.KeyPair
import java.security.KeyPairGenerator
import android.widget.AdapterView.OnItemClickListener
import android.content.Intent
import android.view.WindowId
import xyz.antifreezzz.anovote.R
import java.text.FieldPosition


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
/*        voteList.onItemClickListener = OnItemClickListener { parent, view, position, id ->
            startActivity(voteAcIntent)

        }*/

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
        keysGenerate()

    }


    fun toast(text: String) {
        val makeToast = Toast.makeText(this, text, Toast.LENGTH_LONG)
        makeToast.show()
    }


    // Генерация пары ключей
    fun keysGenerate(): KeyPair? {
        lateinit var keyPair: KeyPair
        //       val keyPair = generateKeys()



        try {
            // get instance of rsa cipher
            val keyGen = KeyPairGenerator.getInstance("RSA")
            keyGen.initialize(1024)            // initialize key generator
            keyPair = keyGen.generateKeyPair() // generate pair of keys
        } catch (e: GeneralSecurityException) {
            println(e)
        }
        keysStatus()
        val publicKey = keyPair.public?.encoded
        val privateKey = keyPair.private?.encoded
        return keyPair

//        TODO("Код генерации пары ключей и регистрация у авторизованного центра")

    }

    //Проверка статуса пары ключей (Создана, но не подписана и Создана и подписана
    fun keysStatus() {
        return keysStatus.setText("Ключи созданы, но не подписаны")
    }

    fun voteChange(voteID: Int): Int {
        return 0
    }

    data class Vote(val name: String)





}







