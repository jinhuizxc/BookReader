package com.example.jh.bookreader.ui.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.example.jh.bookreader.R;
import com.example.jh.bookreader.base.Constant;
import com.example.jh.bookreader.bean.BooksByTag;
import com.example.jh.bookreader.common.OnRvItemClickListener;
import com.example.jh.easyadapterlibrary.recyclerview.EasyRVAdapter;
import com.example.jh.easyadapterlibrary.recyclerview.EasyRVHolder;

import java.util.List;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 */

public class BooksByTagAdapter extends EasyRVAdapter<BooksByTag.TagBook> {

    private OnRvItemClickListener itemClickListener;

    public BooksByTagAdapter(Context context, List<BooksByTag.TagBook> list,
                             OnRvItemClickListener listener) {
        super(context, list, R.layout.item_tag_book_list);
        this.itemClickListener = listener;
    }

    @Override
    protected void onBindData(final EasyRVHolder holder, final int position, final BooksByTag.TagBook item) {
        StringBuffer sbTags = new StringBuffer();
        for (String tag : item.tags) {
            if (!TextUtils.isEmpty(tag)) {
                sbTags.append(tag);
                sbTags.append(" | ");
            }
        }

        holder.setRoundImageUrl(R.id.ivBookCover, Constant.IMG_BASE_URL + item.cover, R.drawable.cover_default)
                .setText(R.id.tvBookListTitle, item.title)
                .setText(R.id.tvShortIntro, item.shortIntro)
                .setText(R.id.tvTags, (item.tags.size() == 0 ? "" : sbTags.substring(0, sbTags
                        .lastIndexOf(" | "))));

        holder.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(holder.getItemView(), position, item);
            }
        });
    }
}
