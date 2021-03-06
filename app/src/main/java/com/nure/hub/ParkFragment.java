package com.nure.hub;


import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.nure.hub.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParkFragment extends Fragment {

    public ProgressBar progressBar;
    public ParkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity)getActivity()).setActionBarTitle("Науковий парк");
        View v =  inflater.inflate(R.layout.fragment_park, container, false);
        WebView webView = (WebView)v.findViewById(R.id.web7);
        progressBar = (ProgressBar)v.findViewById(R.id.prgp);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }
        });

        webView.loadUrl("https://www.synergy-park.com/ua/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true); webSettings.setUseWideViewPort(true);
        //webSettings.setBuiltInZoomControls(true); webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true); //webSettings.setDefaultTextEncodingName("utf-8");



        //загрузка файлов
        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Uri myUri = Uri.parse(url);
                Intent superIntent = new Intent(Intent.ACTION_VIEW);
                superIntent.setData(myUri);
                startActivity(superIntent);
            }
        });


        webView.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN) {
                    WebView webView = (WebView) v;
                    switch(keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            if(webView.canGoBack()) {
                                webView.goBack();
                                return true; }
                            break;
                    }
                }
                return false; } });

        return v;
    }

}