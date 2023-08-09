package com.cinar.webview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    WebView simpleWebView;
    Button loadWebPage, loadFromStaticHtml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initiate buttons and a web view
        loadFromStaticHtml = (Button) findViewById(R.id.statıcWeb);

        loadWebPage = (Button) findViewById(R.id.remoteWeb);

        simpleWebView = (WebView) findViewById(R.id.webView);

    }


    public void stat(View v) {
        // define static html text
        String customHtml = "<html><body><h1>Hello, Selim Cinar</h1>" +
                "<h1>Heading 1</h1><h2>Heading 2</h2><h3>Heading 3</h3>" +
                "<p>This is a sample paragraph of static HTML In Web view</p>" +
                "</body></html>";
        simpleWebView.loadData(customHtml, "text/html", "UTF-8"); // load html string data in a web view

        }

    public  void remote (View v) {
        simpleWebView.setWebViewClient(new MyWebViewClient());
        String url = "https://www.fenerbahce.org/";
        simpleWebView.getSettings().setJavaScriptEnabled(true);
        simpleWebView.loadUrl(url); // load a web page in a web view
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}