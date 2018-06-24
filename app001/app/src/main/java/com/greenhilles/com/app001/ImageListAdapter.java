package com.greenhilles.com.app001;

import java.util.List;
import java.util.Map;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        // この行のためのテキストをセット
        String text_for_this_line
                = data_for_this_line.get("name").toString();
        Log.d("ListViewTest", position + "のtextは" + text_for_this_line);
        TextView tv = (TextView)v.findViewById(R.id.textView1);
        tv.setText( text_for_this_line );


        /* ---------- 行内の画像をロードして描画 ------------ */

        // 行内の画像ビュー
        ImageView imageView = (ImageView)v.findViewById(R.id.ImageView1);

        // 画像のURL
        String img_url = data_for_this_line.get("imgUrl").toString();
        // ※Yahooのロゴ

        // 非同期で画像読込を実行
        try{
            Log.d("ListViewTest", position + "の画像読み込みを開始");

            DownloadImageTask task
                    = new DownloadImageTask(imageView, context);
            task.execute(img_url);
        }
        catch(Exception e){
            //
            Log.d("ListViewTest", position + "の画像読み込みに失敗");
        }

        /* ---------- 行の描画が完了 ------------ */

        return v;
    }
}
