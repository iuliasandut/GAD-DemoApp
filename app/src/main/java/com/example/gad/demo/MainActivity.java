package com.example.gad.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView browser = findViewById(R.id.actMain_wvBrowser);

        // enable javascript
        WebSettings settings = browser.getSettings();
        settings.setJavaScriptEnabled(true);

        // if we wish to open the webpage in place, we need to specify a client that will render the page
        browser.setWebViewClient(new MyWebClient());

        browser.loadUrl("https://www.polygon.com");
    }

    public class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // specifies that we should load the page in the webview we have and not an external browser window
            view.loadUrl(url);
            return true;
        }
    }
}
