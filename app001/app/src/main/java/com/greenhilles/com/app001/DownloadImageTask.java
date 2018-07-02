package com.greenhilles.com.app001;

import java.io.InputStream;
import java.net.URL;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Web上から画像を読み込むタスク
 *
 */
class DownloadImageTask extends AsyncTask<String,Void,Bitmap> {
    private ImageButton imageView;
    private Context context;
    private String tag;

    // 初期化
    public DownloadImageTask(ImageButton imageView, Context context) {
        this.imageView = imageView;
        this.context = context;
        // ImageView に設定したタグをメンバへ
        this.tag = imageView.getTag().toString();
    }

    // execute時のタスク本体。画像をビットマップとして読み込んで返す
    @Override
    protected Bitmap doInBackground(String... params) {
        synchronized (context){
            try {
                String str_url = params[0];
                URL imageUrl = new URL(str_url);
                InputStream imageIs;

                // 読み込み実行
                imageIs = imageUrl.openStream();
                Bitmap bm = BitmapFactory.decodeStream(imageIs);
                Log.d("ListViewTest", "画像読み込み完了");

                return bm;
            } catch (Exception e) {
                Log.d("ListViewTest", "画像読み込みタスクで例外発生："
                        + e.toString());
                return null;
            }
        }
    }

    // タスク完了時
    @Override
    protected void onPostExecute(Bitmap result) {
        if (this.tag.equals(this.imageView.getTag())) {
            if (result != null) {
                this.imageView.setImageBitmap(result);
                this.imageView.setVisibility(View.VISIBLE);
            }
        }
    }
}