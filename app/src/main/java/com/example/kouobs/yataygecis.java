package com.example.kouobs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class yataygecis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yataygecis);



        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("https://developer.android.com/guide/webapps/webview#java");
    }
}