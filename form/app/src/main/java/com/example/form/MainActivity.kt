package com.example.form

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            // Find the WebView by its ID
            val webView: WebView = findViewById(R.id.webView)
            val db = Firebase.firestore
            // Enable JavaScript
            webView.settings.javaScriptEnabled = true

            // Set WebViewClient to handle loading within the WebView
            webView.webViewClient = WebViewClient()

            // Load the Google Form URL
            val googleFormUrl = "https://www.youtube.com/"
            webView.loadUrl(googleFormUrl)
        } catch (e: Exception) {
            // Print the stack trace and show a toast
            e.printStackTrace()
            Toast.makeText(this, "Error loading the form: ${e.message}", Toast.LENGTH_LONG).show()

        }
    }
}
