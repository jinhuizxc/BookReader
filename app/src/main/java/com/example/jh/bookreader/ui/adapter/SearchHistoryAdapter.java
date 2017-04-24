package com.example.jh.bookreader.ui.adapter;

import android.content.Context;

import com.example.jh.bookreader.R;
import com.example.jh.easyadapterlibrary.abslistview.EasyLVAdapter;
import com.example.jh.easyadapterlibrary.abslistview.EasyLVHolder;

import java.util.List;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

public class SearchHistoryAdapter extends EasyLVAdapter<String> {

    public SearchHistoryAdapter(Context context, List<String> list) {
        super(context, list, R.layout.item_search_history);
    }

    @Override
    public void convert(EasyLVHolder holder, int position, String s) {
        holder.setText(R.id.tvTitle, s);
    }
}
