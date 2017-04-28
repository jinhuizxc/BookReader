package com.example.jh.bookreader.view.pdfview;

import android.graphics.Bitmap;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

public interface BitmapContainer {

    Bitmap get(int position);

    void remove(int position);

    void clear();
}