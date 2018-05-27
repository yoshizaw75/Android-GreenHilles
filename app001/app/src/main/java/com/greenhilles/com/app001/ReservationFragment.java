package com.greenhilles.com.app001;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.graphics.Bitmap;
/**
 * Created by toshiyukiyoshizawa on 2018/05/15.
 */

public class ReservationFragment extends Fragment {

    private WebView mWebView;
    private Bundle webViewBundle;

    public static ReservationFragment newInstance() {

        return new ReservationFragment();
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
            mWebView.loadUrl("https://www.vlcm.net/rc/pc/index.php?action_CRA01_01do=true&cid=00056");
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
