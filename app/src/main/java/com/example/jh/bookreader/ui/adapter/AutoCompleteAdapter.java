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

public class AutoCompleteAdapter extends EasyLVAdapter<String> {

    public AutoCompleteAdapter(Context context, List<String> list) {
        super(context, list, R.layout.item_auto_complete_list);
    }

    @Override
    public void convert(EasyLVHolder holder, int position, String s) {
        holder.setText(R.id.tvAutoCompleteItem, s);
    }
}
