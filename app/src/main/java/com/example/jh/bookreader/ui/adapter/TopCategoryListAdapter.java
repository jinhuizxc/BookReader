package com.example.jh.bookreader.ui.adapter;

import android.content.Context;
import android.view.View;

import com.example.jh.bookreader.R;
import com.example.jh.bookreader.bean.CategoryList;
import com.example.jh.bookreader.common.OnRvItemClickListener;
import com.example.jh.easyadapterlibrary.recyclerview.EasyRVAdapter;
import com.example.jh.easyadapterlibrary.recyclerview.EasyRVHolder;

import java.util.List;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 */

public class TopCategoryListAdapter extends EasyRVAdapter<CategoryList.MaleBean> {
    private OnRvItemClickListener itemClickListener;

    public TopCategoryListAdapter(Context context, List<CategoryList.MaleBean> list, OnRvItemClickListener listener) {
        super(context, list, R.layout.item_top_category_list);
        this.itemClickListener = listener;
    }

    @Override
    protected void onBindData(final EasyRVHolder holder, final int position, final CategoryList.MaleBean item) {
        holder.setText(R.id.tvName, item.name)
                .setText(R.id.tvBookCount, String.format(mContext.getString(R.string
                        .category_book_count), item.bookCount));

        holder.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(holder.getItemView(), position, item);
            }
        });
    }

}

