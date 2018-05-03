package xyz.antifreezzz.anovote

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.view.View
import android.widget.*
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.view.*
import java.security.GeneralSecurityException
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var createKeys: Button
    private lateinit var keysStatus: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createKeys = findViewById(R.id.createKeys)
        keysStatus = findViewById(R.id.keysStatus)
        createKeys.setOnClickListener(onButtonClickListener)

        val voteList: MutableList<String> = mutableListOf("Text1", "Text2", "Text2")

        // находим список
        val vote = findViewById<ListView>(R.id.voteList)

        // создаем адаптер
        val adapter = ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, voteList)

        // присваиваем адаптер списку
        vote.adapter = adapter
    }


    private val onButtonClickListener = View.OnClickListener {
        toastForTest(it)
        keysGenerate()

    }

    fun toastForTest(view: View){
        val makeToast = Toast.makeText(this, "TestToast", Toast.LENGTH_LONG)

        makeToast.show()
    }


// Генерация пары ключей
    fun keysGenerate(){
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
    fun keysStatus(){
        return keysStatus.setText("Ключи созданы, но не подписаны")
    }
}
