package xyz.antifreezzz.anovote

import android.widget.TextView
import android.os.Bundle
import android.util.Base64
import android.util.Log
import java.security.*
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.SecretKeySpec


class Cryptography() {
    val testText = "А у нас сегодня кошка родила вчера котят"
    lateinit var publicKey: PublicKey
    lateinit var privateKey: PrivateKey
    var encodedBytes: ByteArray? = null
    var decodedBytes: ByteArray? = null

    fun keyGenerate(): KeyPair?{
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        // Original text

//        val originalTextView = findViewById(R.id.textViewOriginal) as TextView
//        originalTextView.text = "[ORIGINAL]:\n$testText\n"

        // Generate key pair for 1024-bit RSA encryption and decryption


        try {
            val kpg = KeyPairGenerator.getInstance("RSA")
            kpg.initialize(1024)
            val kp = kpg.genKeyPair()
            publicKey = kp.public
            privateKey = kp.private
        } catch (e: Exception) {
            Log.e("Crypto", "RSA key pair error")
        }
        return KeyPair(publicKey, privateKey)
    }

    fun encoder() {
        // Encode the original data with RSA private key

        try {
            val c = Cipher.getInstance("RSA")
            c.init(Cipher.ENCRYPT_MODE, privateKey)
            encodedBytes = c.doFinal(testText.toByteArray())
        } catch (e: Exception) {
            Log.e("Crypto", "RSA encryption error")
        }
    }

//        val encodedTextView = findViewById(R.id.textViewEncoded) as TextView
/*        encodedTextView.text = "[ENCODED]:\n" +
                Base64.encodeToString(encodedBytes, Base64.DEFAULT) + "\n"*/

    // Decode the encoded data with RSA public key

    fun decoder() {

        try {
            val c = Cipher.getInstance("RSA")
            c.init(Cipher.DECRYPT_MODE, publicKey)
            decodedBytes = c.doFinal(encodedBytes!!)
        } catch (e: Exception) {
            Log.e("Crypto", "RSA decryption error")
        }

//        val decodedTextView = findViewById(R.id.textViewDecoded) as TextView
//        decodedTextView.text = "[DECODED]:\n" + String(decodedBytes!!) + "\n"
    }

}