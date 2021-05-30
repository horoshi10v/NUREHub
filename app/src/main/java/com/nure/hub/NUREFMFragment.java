package com.nure.hub;


import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.nure.hub.R;



/**
 * A simple {@link Fragment} subclass.
 */
public class NUREFMFragment extends Fragment {


    public ProgressBar progressBar;

    public NUREFMFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity)getActivity()).setActionBarTitle("DL NURE");
        View v =inflater.inflate(R.layout.fragment_nurefm, container, false);

        progressBar = (ProgressBar)v.findViewById(R.id.prgr);

        WebView webView = (WebView)v.findViewById(R.id.web2);



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
        webView.loadUrl("https://dl.nure.ua/");
        webView.getSettings().setJavaScriptEnabled(true);
        WebSettings webSettings = webView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true); webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true); webSettings.setDisplayZoomControls(false); //убрать это и низ для инсты
        //webSettings.setSupportZoom(true); webSettings.setDefaultTextEncodingName("utf-8");




        webView.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) { if(event.getAction() == KeyEvent.ACTION_DOWN) { WebView webView = (WebView) v; switch(keyCode) { case KeyEvent.KEYCODE_BACK: if(webView.canGoBack()) { webView.goBack(); return true; } break; } } return false; } });


        return v;

    }

}
