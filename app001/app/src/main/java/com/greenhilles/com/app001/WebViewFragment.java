package com.greenhilles.com.app001;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class WebViewFragment extends Fragment {

    private WebView mWebView;
    private Bundle webViewBundle;
    private static String ViewURL;

    public static WebViewFragment newInstance() {
        WebViewFragment fg = new WebViewFragment();
        return fg;
    }

    public static WebViewFragment newInstance(String url) {
        ViewURL = url;
        WebViewFragment fg = new WebViewFragment();
        return fg;
    }

    public static void setURL(String url){
        ViewURL = url;
        return;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.blog, container, false);

        mWebView = (WebView) rootView.findViewById(R.id.WebViewcom);
        mWebView.setWebViewClient(new ProgressDialgWebViewClient(inflater.getContext(), "Page Loading..."));
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        if (webViewBundle == null) {
            mWebView.loadUrl(ViewURL);
        } else {
            mWebView.restoreState(webViewBundle);
        }

        return rootView;
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        mWebView.restoreState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        mWebView.saveState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onResume() {
        super.onResume();
        mWebView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        webViewBundle = new Bundle();
        mWebView.saveState(webViewBundle);
    }

    @Override
    public void onDestroy() {
        if (mWebView != null) {
            mWebView.destroy();
            mWebView = null;
        }
        super.onDestroy();
    }
}
