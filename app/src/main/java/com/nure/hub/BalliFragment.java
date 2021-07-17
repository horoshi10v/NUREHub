package com.nure.hub;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class BalliFragment extends Fragment {

    public BalliFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        ((MainActivity)getActivity()).setActionBarTitle("Рейтинговий бал");
        View v = inflater.inflate(R.layout.fragment_balli, container, false);
        WebView webView = (WebView)v.findViewById(R.id.webB);
        webView.loadUrl("file:///android_asset/balli/balli.html");
        WebSettings webSettings = webView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true); //растягивает
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true); webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true); //webSettings.setDefaultTextEncodingName("utf-8");
        return v;
    }
}
