package com.example.testwebapp

import android.os.Bundle
import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.testwebapp.ui.theme.TestWebAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestWebAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    WebSite()
                }
            }
        }
    }
}

@Composable
fun WebSite() {
    val context = LocalContext.current
    AndroidView(factory = {
        WebView(context).apply {
            webViewClient = WebViewClient()
            settings.apply {
                javaScriptEnabled = true
//                domStorageEnabled = true
//                mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
//                userAgentString = "$userAgentString (App; wv)"
            }

//            webChromeClient = object : WebChromeClient() {
//                override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
//                    // Hier wird das Web-Ereignisprotokoll erfasst
//                    val logMessage = "${consoleMessage.message()} at ${consoleMessage.sourceId()}:${consoleMessage.lineNumber()}"
//                    Log.d("WebView Console", logMessage)
//
//                    // Aktualisiere die Composable-Anzeige mit den Protokollen
////                    consoleLogs += logMessage + "\n"
//                    return true
//                }
//            }

            loadUrl("https://dev-oneepaper.goettinger-tageblatt.de/epaper/?outputType=app")
        }
    })
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestWebAppTheme {
        WebSite()
    }
}