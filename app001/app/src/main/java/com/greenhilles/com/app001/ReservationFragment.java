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
    public static ReservationFragment newInstance() {

        return new ReservationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.reservation, container, false);

        WebView mWebView = (WebView) rootView.findViewById(R.id.WebViewReserve);


        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new ProgressDialgWebViewClient(inflater.getContext(), "Page Loading..."));
        mWebView.loadUrl("https://www.vlcm.net/rc/pc/index.php?action_CRA01_01do=true&cid=00056");
        return rootView;
    }
}
