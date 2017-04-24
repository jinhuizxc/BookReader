package com.example.jh.bookreader.ui.activity;

import android.content.Context;
import android.content.Intent;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

public class WifiBookActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, WifiBookActivity.class));
    }
}
