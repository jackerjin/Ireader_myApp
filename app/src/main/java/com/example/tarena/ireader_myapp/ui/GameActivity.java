package com.example.tarena.ireader_myapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.tarena.ireader_myapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {
    @BindView(R.id.webView_gameActivity)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        String url = "http://www.eoemarket.com/";
        webView.clearCache(true);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());
    }
}
