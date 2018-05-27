package com.greenhilles.com.app001;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebSettings;


public class BlogFragment extends Fragment {

    private WebView mWebView;
    private Bundle webViewBundle;

    public static BlogFragment newInstance() {

        BlogFragment fg = new BlogFragment();
        return fg;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.blog, container, false);

        mWebView = (WebView) rootView.findViewById(R.id.WebViewBlog);
        mWebView.setWebViewClient(new ProgressDialgWebViewClient(inflater.getContext(), "Page Loading..."));
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        if (webViewBundle == null) {

            mWebView.loadUrl("http://www.ghfutsal.jp/wordpress/");
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
