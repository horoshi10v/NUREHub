package com.nure.hub;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;




/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {

    public ProgressBar progressBar;
    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((MainActivity) getActivity()).setActionBarTitle("Карта");
        final View v = inflater.inflate(R.layout.fragment_map, container, false);


        WebView webView = (WebView) v.findViewById(R.id.webmap);


        webView.getSettings().setJavaScriptEnabled(true);
        progressBar = (ProgressBar) v.findViewById(R.id.prgm);

        webView.setWebViewClient(new WebViewClient() {
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

        webView.loadUrl("http://tss.co.ua:5560/map/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(false);
        webSettings.setUseWideViewPort(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false); //убрать это и низ для инсты
        webSettings.setSupportZoom(false); //webSettings.setDefaultTextEncodingName("utf-8");

        webView.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    WebView webView = (WebView) v;
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_BACK:
                            if (webView.canGoBack()) {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }
                return false;
            }
        });


       /*Button fab = (Button)v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Карта заходиться в розробці. Для зауваженнь та пропозицій писати  в Telegram: @georgesvitenko ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/


        final Button fab = v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Увага!")

                        .setMessage(Html.fromHtml("Карта заходиться в розробці. Для зауваженнь та пропозицій писати  в "+"<b>"+"Telegram:"+"</b>  <a href=\"https://t.me/georgesvitenko \">@georgesvitenko</a>"))

                        .setCancelable(false)

                        .setNegativeButton("Зрозуміло!",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });

        return v;
    }

}