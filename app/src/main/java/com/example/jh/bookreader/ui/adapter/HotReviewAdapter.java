package com.example.jh.bookreader.ui.adapter;

import android.content.Context;
import android.view.View;

import com.example.jh.bookreader.R;
import com.example.jh.bookreader.base.Constant;
import com.example.jh.bookreader.bean.HotReview;
import com.example.jh.bookreader.common.OnRvItemClickListener;
import com.example.jh.bookreader.view.XLHRatingBar;
import com.example.jh.easyadapterlibrary.recyclerview.EasyRVAdapter;
import com.example.jh.easyadapterlibrary.recyclerview.EasyRVHolder;

import java.util.List;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 */

public class HotReviewAdapter extends EasyRVAdapter<HotReview.Reviews> {
    private OnRvItemClickListener itemClickListener;

    public HotReviewAdapter(Context context, List<HotReview.Reviews> list, OnRvItemClickListener listener) {
        super(context, list, R.layout.item_book_detai_hot_review_list);
        this.itemClickListener = listener;
    }

    @Override
    protected void onBindData(final EasyRVHolder holder, final int position, final HotReview.Reviews item) {
        holder.setCircleImageUrl(R.id.ivBookCover, Constant.IMG_BASE_URL + item.author.avatar, R.drawable.avatar_default)
                .setText(R.id.tvBookTitle, item.author.nickname)
                .setText(R.id.tvBookType, String.format(mContext.getString(R.string
                        .book_detail_user_lv), item.author.lv))
                .setText(R.id.tvTitle, item.title)
                .setText(R.id.tvContent, String.valueOf(item.content))
                .setText(R.id.tvHelpfulYes, String.valueOf(item.helpful.yes));
        XLHRatingBar ratingBar = holder.getView(R.id.rating);
        ratingBar.setCountSelected(item.rating);
        holder.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(holder.getItemView(), position, item);
            }
        });
    }

}