package com.omniknow.tareas;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
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



        webview.loadUrl("http://192.168.20.103:8383/Omniknow/JSP/index.jsp");
//        webview.loadUrl("http://www.google.com");

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



    // Métodos anti teclado
//    public class webViewClient extends WebViewClient
//    {
//        @Override
//        public void onPageStarted( WebView view, String url, Bitmap favicon)
//        {
//            if( view == webview)  super.onPageStarted( view, url, favicon);
//        }
//
//        @Override
//        public void onPageFinished( WebView view, String url)
//        {
//            if( view == webview)  super.onPageFinished( view, url);
//        }
//
//        @Override
//        public boolean shouldOverrideUrlLoading( WebView view, String url)
//        {
//            if( view == webview)  view.loadUrl( url);
//            return false;
//            // return super.shouldOverrideUrlLoading( view, url);
//        }
//
//        @Override
//        public void onReceivedError( WebView view, int errorCode, String description, String failingUrl)
//        {
//            if( view == webview)  ApplicationLeta.fPopup( getString( R.string.sPopupErrorSiteOpen) + " : " + description);
//            // ActivityBrowser.this.finish();
//        }
//
//        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error)
//        {
//            if( view == webview)  handler.proceed();
//        }
//    }
//
//
//    @Override
//    public boolean dispatchTouchEvent( MotionEvent motionEvent)
//    {
//        super.dispatchTouchEvent( motionEvent);
//
//        if( motionEvent.getAction() == MotionEvent.ACTION_MOVE)  return true;
//
//        if( motionEvent.getAction() == MotionEvent.ACTION_UP)
//        {
//            // do something
//        }
//
//        if( motionEvent.getAction() == MotionEvent.ACTION_UP)
//        {
//            // do something
//        }
//        return false;
//    }
//
//
//    @Override
//    public void onBackPressed()
//    {
//    }
//
//
//    @Override
//    public void onWindowFocusChanged( boolean eFocus)
//    {
//        super.onWindowFocusChanged( eFocus);
//        if( eFocus == false)
//        {
//            fKeyboardClose();
//
//            new Thread( new Runnable()
//            {
//                @Override
//                public void run()
//                {
//                    try
//                    {
//                        Instrumentation inst = new Instrumentation();
//                        inst.sendKeyDownUpSync( KeyEvent.KEYCODE_BACK);
//                    }
//                    catch( Exception e) {}
//                }
//            } ).start();
//        }
//    }
//
//
//    private void fKeyboardClose()
//    {
//        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService( Activity.INPUT_METHOD_SERVICE);
//        inputMethodManager.hideSoftInputFromWindow( getCurrentFocus().getWindowToken(), 0);
//    }
//
//
//    public OnGlobalLayoutListener onGlobalLayoutListener = new OnGlobalLayoutListener()
//    {
//        @Override
//        public void onGlobalLayout()
//        {
//            Rect rect = new Rect();
//            viewRootHTML.getWindowVisibleDisplayFrame( rect);
//            iViewRootHTMLHeightDifferent = viewRootHTML.getRootView().getHeight() - (rect.bottom - rect.top);
//            if( iViewRootHTMLHeightDifferent > 50)  fKeyboardClose();
//        }
//    };
}
