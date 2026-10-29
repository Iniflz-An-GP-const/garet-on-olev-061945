package anuvix.garetonolev.hubapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import anuvix.garetonolev.hubapp.ui.composable.approot.AppRoot
import anuvix.garetonolev.hubapp.ui.theme.AXOVPAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AXOVPAppTheme {
                AppRoot()
            }
        }
    }
}
