package com.greenhilles.com.app001;

import java.util.List;
import java.util.Map;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ImageListAdapter extends SimpleAdapter {
    private Context context;
    private LayoutInflater mInflater;
    private List<? extends Map<String, Object>> list_data;

    // 初期化
    public ImageListAdapter(Context context,
                            List<? extends Map<String, Object>> list_data,
                            int resource, String[] from, int[] to)
    {
        super(context, list_data, resource, from, to);

        this.context = context;
        this.list_data = list_data;

        // リストの動的な描画のためにインフレータを生成
        this.mInflater =
                (LayoutInflater) context.getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE
                );

        Log.d("ListViewTest", "アダプタ生成完了");
    }


    // 1行を描画するたびに呼ばれるメソッド
    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {

        Log.d("ListViewTest", position + "の getView() が開始");


        /* ---------- 行を初期化 ------------ */

        // 行を表すビュー
        View v = convertView;
        if(v == null){
            Log.d("ListViewTest", position + "のvを新規生成");
            v = mInflater.inflate(R.layout.listview_one_line, null);
        }

        // この行のためのデータを読み出し
        Map<String, Object> data_for_this_line = list_data.get(position);


        /* ---------- 行内の画像をロードして描画 ------------ */

        // 行内の画像ビュー
        ImageButton imageView1 = (ImageButton)v.findViewById(R.id.BannerImage1);

        // 画像のURL
        String img_url1 = data_for_this_line.get("imgUrl_1").toString();
        imageView1.setTag(img_url1);
        // 非同期で画像読込を実行
        try{
            Log.d("ListViewTest", position + "の画像読み込みを開始");

            DownloadImageTask task1
                    = new DownloadImageTask(imageView1, context);
            task1.execute(img_url1);
        }
        catch(Exception e){
            //
            Log.d("ListViewTest", position + "の画像読み込みに失敗");
        }

        ImageButton imageView2 = (ImageButton)v.findViewById(R.id.BannerImage2);
        // 画像のURL
        String img_url2 = data_for_this_line.get("imgUrl_2").toString();
        imageView2.setTag(img_url2);
        // 非同期で画像読込を実行
        try{
            Log.d("ListViewTest2", position + "の画像読み込みを開始");

            DownloadImageTask task2
                    = new DownloadImageTask(imageView2, context);
            task2.execute(img_url2);
        }
        catch(Exception e){
            //
            Log.d("ListViewTest2", position + "の画像読み込みに失敗");
        }
        /* ---------- 行の描画が完了 ------------ */

        return v;
    }
}
