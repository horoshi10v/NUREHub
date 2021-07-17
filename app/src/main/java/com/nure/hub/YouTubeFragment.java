package com.nure.hub;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.nure.hub.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class YouTubeFragment extends Fragment {


    public YouTubeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity)getActivity()).setActionBarTitle("YOUTUBE");

        View v = inflater.inflate(R.layout.fragment_you_tube, container, false);
        WebView webView = (WebView)v.findViewById(R.id.web3);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.youtube.com/channel/UCFwYsa2_dfuRroZPF8v3ZjA");
        WebSettings webSettings = webView.getSettings();
        //webSettings.setDomStorageEnabled(true);
        //webSettings.setLoadWithOverviewMode(true); webSettings.setUseWideViewPort(true);
        //webSettings.setBuiltInZoomControls(true); webSettings.setDisplayZoomControls(false); //убрать это и низ для инсты
        //webSettings.setSupportZoom(true); //webSettings.setDefaultTextEncodingName("utf-8");


        webView.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN) {
                    WebView webView = (WebView) v;
                    switch(keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            if(webView.canGoBack()) {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }
                return false;
            }
        });


        return v;
    }

}
