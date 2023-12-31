package com.example.myapptwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView browser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        browser = findViewById(R.id.webview);

        browser.getSettings().setLoadsImagesAutomatically(true);
        browser.getSettings().setJavaScriptEnabled(true);
        browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        browser.loadUrl("https://developer.android.com/docs");
    }
}