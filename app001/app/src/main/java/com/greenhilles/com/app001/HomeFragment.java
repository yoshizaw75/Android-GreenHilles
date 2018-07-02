package com.greenhilles.com.app001;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by toshiyukiyoshizawa on 2018/05/15.
 */

public class HomeFragment extends Fragment {
    public static HomeFragment newInstance() {

        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View rootView =inflater.inflate(R.layout.home, container, false);

        ListView bannerList = (ListView)rootView.findViewById(R.id.BannerListView);
        ArrayList<Map<String, Object>> list_data
                = new ArrayList<Map<String, Object>>();

        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("imgUrl_1", "http://www.ghfutsal.jp/img/wp/campaign/banner-ouen2018.jpg");
        map1.put("linkUrl_1", "http://www.ghfutsal.jp/img/wp/campaign/banner-ouen2018.jpg");
        map1.put("imgUrl_2", "http://www.ghfutsal.jp/img/wp/campaign/banner-ouen2018.jpg");
        map1.put("linkUrl_2", "http://www.ghfutsal.jp/img/wp/campaign/banner-ouen2018.jpg");
        list_data.add(map1);

        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map2.put("imgUrl_1", "http://www.ghfutsal.jp/img/wp/campaign/banner-ouen2018.jpg");
        map2.put("linkUrl_1", "http://www.ghfutsal.jp/img/wp/campaign/banner-ouen2018.jpg");
        map2.put("imgUrl_2", "http://www.ghfutsal.jp/img/wp/campaign/banner-ouen2018.jpg");
        map2.put("linkUrl_2", "http://www.ghfutsal.jp/img/wp/campaign/banner-ouen2018.jpg");
        list_data.add(map2);

        HashMap<String, Object> map3 = new HashMap<String, Object>();
        map3.put("imgUrl_1", "http://www.ghfutsal.jp/img/wp/campaign/banner-ouen2018.jpg");
        map3.put("linkUrl_1", "http://www.ghfutsal.jp/img/wp/campaign/banner-ouen2018.jpg");
        map3.put("imgUrl_2", "http://www.ghfutsal.jp/img/wp/campaign/banner-ouen2018.jpg");
        map3.put("linkUrl_2", "http://www.ghfutsal.jp/img/wp/campaign/banner-ouen2018.jpg");
        list_data.add(map3);


        // アダプタを生成
        String[] from_template = {};
        int[] to_template = {};
        ImageListAdapter il_adapter = new ImageListAdapter(
                inflater.getContext(),
                list_data,
                R.layout.listview_one_line,
                from_template,
                to_template
        );


        // リストビューにアダプタをセット
        bannerList.setAdapter( il_adapter );
        return rootView;
    }
}
