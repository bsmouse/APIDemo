/*
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.apis.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.android.apis.R;


/**
 * Sample creating 10 webviews.
 */
public class WebView1 extends Activity {
    
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        
        setContentView(R.layout.webview_1);
        
        final String mimeType = "text/html";
        final String encoding = "utf-8";
        
        WebView wv;
        
        /**
        wv = (WebView) findViewById(R.id.wv1);
        wv.loadData("<a href='http://www.google.com/mobile/android'>Hello World! - 1</a>", mimeType, encoding);
               
        wv = (WebView) findViewById(R.id.wv2);
        wv.loadData("<a href='x'>Hello World! - 2</a>", mimeType, encoding);
        **/
        
        
        // bsmouse - 2014-06-11 
        // WebView 내장
        String url = "http://m.naver.com/";
        
        WebView webview = (WebView) findViewById(R.id.wv1);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(url);
        webview.setWebViewClient(new HelloWebViewClient());         

        wv = (WebView) findViewById(R.id.wv2);
        wv.loadData("<a href='x'>Hello World! - 2</a>", mimeType, encoding);
        wv.setVisibility(View.GONE); // 화면에 안보이게 처리

    }
    
    
    // bsmouse - 2014-06-11 
    // WebView 내장
    private class HelloWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
      
        @Override
        public void onPageFinished(WebView view, String url){
            Log.d("bs_Tag", "#### onPageFinished()  ");      
        }

        public boolean shouldOverrideKeyEvent (WebView view, KeyEvent event) {
            int keyCode = event.getKeyCode();
            Log.d("bs_Tag", "#### shouldOverrideKeyEvent()  " + keyCode);  
            /*
            if ((keyCode == KeyEvent.KEYCODE_DPAD_LEFT) && webview.canGoBack()) {
                webview.goBack();
                return true;
            }else if ((keyCode == KeyEvent.KEYCODE_DPAD_RIGHT) && webview.canGoForward()) {
                webview.goForward();
                return true;
            }
            */
            return false;
        }    
    }
    
}
