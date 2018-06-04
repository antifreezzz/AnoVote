package xyz.antifreezzz.anovote

import org.junit.Assert
import org.junit.Test

class CryptoTests {
    private var textForCrypt = "Text"
    private val keyPair = Cryptography().keyGenerate()
    private val privateKey = keyPair!!.private
    private val publicKey = keyPair!!.public

    @Test
    fun keysGenerateTest() {
        Cryptography().keyGenerate()
    }
    @Test
    fun encryptDecrypt(){


        val encodedData = Cryptography().encoder(textForCrypt, privateKey)

        val decodedData = Cryptography().decoder(encodedData, publicKey)
        Assert.assertEquals(textForCrypt, decodedData)

    }

}