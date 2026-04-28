package com.jaros.saarekeel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.jaros.saarekeel.ui.CipherScreen
import com.jaros.saarekeel.ui.theme.SaarekeelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SaarekeelTheme {
                CipherScreen()
            }
        }
    }
}
