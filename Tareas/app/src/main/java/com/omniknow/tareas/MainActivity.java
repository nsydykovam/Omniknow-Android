package com.omniknow.tareas;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webview;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        webView = (WebView) findViewById(R.id.webView1);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("http://192.168.1.81:8383/omnijoinders/JSP/index.jsp");

        webview =(WebView) findViewById(R.id.webView1);
        // below line should be last
        //webview.loadUrl(url);

        //gettin websittings
        WebSettings webSettings=webview.getSettings();

        webSettings.setJavaScriptEnabled(true);

        //**enabled dom storage**
        webSettings.setDomStorageEnabled(true);
        //enabling javascript
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        //database enabled
        webSettings.setDatabaseEnabled(true);
        //setwebcclient
        webview.setWebViewClient(new WebViewClient());



//        webview.loadUrl("http://192.168.1.90:8383/omnijoinders/JSP/index.jsp");
        webview.loadUrl("http://www.google.com");

        webview.setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }
}
