package xyz.antifreezzz.anovote

import android.util.Base64
import android.util.Log
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import javax.crypto.Cipher


class Cryptography {

    private lateinit var publicKey: PublicKey
    private lateinit var privateKey: PrivateKey
    private var encodedBytes: ByteArray? = null
    private var decodedBytes: ByteArray? = null

    fun keyGenerate(): KeyPair? {

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

    fun encoder(data: String, privateKey: PrivateKey): ByteArray? {
        // Encode the original data with RSA private key

        try {
            val c = Cipher.getInstance("RSA")
            c.init(Cipher.ENCRYPT_MODE, privateKey)
            encodedBytes = c.doFinal(data.toByteArray())



            Base64.encodeToString(encodedBytes, Base64.DEFAULT)
        } catch (e: Exception) {
            Log.e("Crypto", "RSA encryption error")
        }

        return encodedBytes
    }

    // Decode the encoded data with RSA public key

    fun decoder(encodedBytes: ByteArray?, publicKey: PublicKey): String {

        try {
            val c = Cipher.getInstance("RSA")
            c.init(Cipher.DECRYPT_MODE, publicKey)
            decodedBytes = c.doFinal(encodedBytes)
        } catch (e: Exception) {
            Log.e("Crypto", "RSA decryption error")
        }
        return String(decodedBytes!!)

    }

}