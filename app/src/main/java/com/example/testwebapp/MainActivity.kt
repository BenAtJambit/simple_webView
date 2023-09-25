package com.example.testwebapp

import android.os.Bundle
import android.webkit.WebSettings
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
                domStorageEnabled = true
                mixedContentMode = WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
                userAgentString = "$userAgentString (App; wv)"
            }

            loadUrl("https://dev-oneepaper.goettinger-tageblatt.de/?fcms-opunlock=DyIz9h2KhF")
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