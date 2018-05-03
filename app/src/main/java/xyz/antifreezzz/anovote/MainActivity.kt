package xyz.antifreezzz.anovote

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.security.GeneralSecurityException
import java.security.KeyPair
import java.security.KeyPairGenerator
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.R.array
import android.util.Log


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
        voteList.setOnItemClickListener(onItemClickListener)

//        val voteList: MutableList<String> = mutableListOf("Text1", "Text2", "Text2")

        val voteList = listOf(
                Vote(1, "FirstVote"),
                Vote(2, "SecondVote"),
                Vote(3, "Third Vote")
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

    private val onItemClickListener = View.OnClickListener {
        toast("ListClick")
    }



    fun toast(text: String) {
        val makeToast = Toast.makeText(this, text, Toast.LENGTH_LONG)
        makeToast.show()
    }


    // Генерация пары ключей
    fun keysGenerate() {
        val keyPair = generateKeys()
        val publicKey = keyPair?.public?.encoded
        val privateKey = keyPair?.private?.encoded




        keysStatus()
//        TODO("Код генерации пары ключей и регистрация у авторизованного центра")

    }

    fun generateKeys(): KeyPair? {
        var keyPair: KeyPair? = null
        try {
            // get instance of rsa cipher
            val keyGen = KeyPairGenerator.getInstance("RSA")
            keyGen.initialize(1024)            // initialize key generator
            keyPair = keyGen.generateKeyPair() // generate pair of keys
        } catch (e: GeneralSecurityException) {
            System.out.println(e)
        }

        return keyPair
    }

    //Проверка статуса пары ключей (Создана, но не подписана и Создана и подписана
    fun keysStatus() {
        return keysStatus.setText("Ключи созданы, но не подписаны")
    }

    data class Vote(val id: Int, val name: String)


}

private fun ListView.setOnItemClickListener(onItemClickListener: View.OnClickListener) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}


