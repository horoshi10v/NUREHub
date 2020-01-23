package com.nure.hub;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.nure.hub.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class KafFragment extends Fragment {


    public KafFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((MainActivity)getActivity()).setActionBarTitle("Кафедри");
        View v = inflater.inflate(R.layout.fragment_kaf, container, false);
        WebView webView = (WebView)v.findViewById(R.id.web6);
        webView.loadUrl("file:///android_asset/home/kafedri2.html");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true); //растягивает
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true); webSettings.setDisplayZoomControls(false); //убрать это и низ для инсты
        webSettings.setSupportZoom(true); //webSettings.setDefaultTextEncodingName("utf-8");
        return v;
    }

}
