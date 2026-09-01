package dev.isuru.canadaguide

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dev.isuru.canadaguide.navigation.AppNavGraph
import dev.isuru.canadaguide.ui.theme.CanadaGuideTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CanadaGuideTheme {
                AppNavGraph()
            }
        }
    }
}
