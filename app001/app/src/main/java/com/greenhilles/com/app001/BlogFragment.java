package com.greenhilles.com.app001;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;

/**
 * Created by toshiyukiyoshizawa on 2018/05/15.
 */

public class BlogFragment extends Fragment {
    public static BlogFragment newInstance() {

        BlogFragment fg = new BlogFragment();
        return fg;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.blog, container, false);

        WebView mWebView = (WebView) rootView.findViewById(R.id.WebViewBlog);

        mWebView.loadUrl("https://www.vlcm.net/rc/pc/index.php?action_CRA01_01do=true&cid=00056");
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new WebViewClient());
        return rootView;
    }
}
