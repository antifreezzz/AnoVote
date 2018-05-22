package xyz.antifreezzz.anovote

import org.junit.Test
import java.security.KeyPair
import java.security.PrivateKey
import java.security.PublicKey

class CryptoTests {
    @Test
    fun keysGenerateTest() {
        val keyPair = Cryptography().keyGenerate()

        println(keyPair!!.private.toString() + " " + keyPair.public.toString())
    }
}