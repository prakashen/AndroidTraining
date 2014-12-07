package com.ncit.android.prakash.androidtraining.WebView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.ncit.android.prakash.androidtraining.R;

public class WebViewActivity extends Activity {

    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView=(WebView) findViewById(R.id.wvBrowser);

        webView.setWebViewClient(new Callback());

        webView.loadUrl("https://www.google.com");

        webView.getSettings().setJavaScriptEnabled(true);
        //webView.loadUrl("http://google.com/");

        String customHtml = "<html><body><h2>Greetings from Android Trainers</h2>" +
                "<p>Pitambar koirala</p></body></html>";
        webView.loadData(customHtml, "text/html", "UTF-8");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.web_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class Callback extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url){
            return false;

        }
    }
}
