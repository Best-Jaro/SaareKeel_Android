package com.jaros.saarekeel

import com.jaros.saarekeel.crypto.SaarCipher
import org.junit.Assert.assertEquals
import org.junit.Test

class SaarCipherTest {
    @Test
    fun encodeThenDecode_returnsOriginalText() {
        val input = "Tere, Saaremaa! Proovime 123"

        val encoded = SaarCipher.toSaar(input)
        val decoded = SaarCipher.toEst(encoded)

        assertEquals(input, decoded)
    }

    @Test
    fun decodeSampleFromEncodedBinarySymbols() {
        val encoded = SaarCipher.toSaar("Android")

        val decoded = SaarCipher.toEst(encoded)

        assertEquals("Android", decoded)
    }
}

