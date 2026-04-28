package com.jaros.saarekeel.crypto

private const val SAAR_BINARY_SYMBOLS = "ӧö"
private const val EST_ALPHABET = "abcdefghijklmnopqrsšzžtuvwõä" +
    SAAR_BINARY_SYMBOLS[1] +
    "üx" +
    SAAR_BINARY_SYMBOLS[0]

object SaarCipher {
    fun toSaar(text: String): String {
        val out = StringBuilder()

        for (i in text.indices) {
            val current = text[i]
            val next = text.getOrNull(i + 1)

            val upperMode = when {
                current.lowercaseChar() != current && next != null && next.lowercaseChar() != next -> 2
                current.lowercaseChar() != current -> 1
                else -> 0
            }

            val index = EST_ALPHABET.indexOf(current.lowercaseChar())
            if (index != -1) {
                var binary = index.toString(2)

                if (next != null && EST_ALPHABET.indexOf(next.lowercaseChar()) != -1) {
                    binary = binary.padStart(5, '0')
                }

                var encoded = binary
                    .replace('0', SAAR_BINARY_SYMBOLS[0])
                    .replace('1', SAAR_BINARY_SYMBOLS[1])

                if (upperMode == 1) {
                    encoded = encoded.replaceFirstChar { it.titlecase() }
                } else if (upperMode == 2) {
                    encoded = encoded.uppercase()
                }

                out.append(encoded)
            } else {
                out.append(current)
            }
        }

        return out.toString()
    }

    fun toEst(text: String): String {
        val out = StringBuilder()
        val binaryBuffer = StringBuilder()
        var hasUpper = false
        val preparedText = text + "x"

        fun flushBuffer() {
            if (binaryBuffer.isEmpty()) return

            val value = binaryBuffer.toString().toIntOrNull(2)
            if (value != null && value in EST_ALPHABET.indices) {
                var decoded = EST_ALPHABET[value].toString()
                if (hasUpper) {
                    decoded = decoded.uppercase()
                }
                out.append(decoded)
            }
            binaryBuffer.clear()
            hasUpper = false
        }

        for (char in preparedText) {
            val binaryIndex = SAAR_BINARY_SYMBOLS.indexOf(char.lowercaseChar())
            if (binaryIndex != -1) {
                if (char.lowercaseChar() != char) {
                    hasUpper = true
                }
                binaryBuffer.append(binaryIndex)

                if (binaryBuffer.length > 4) {
                    flushBuffer()
                }
            } else {
                flushBuffer()
                out.append(char)
            }
        }

        return if (out.isNotEmpty()) out.dropLast(1).toString() else ""
    }
}

