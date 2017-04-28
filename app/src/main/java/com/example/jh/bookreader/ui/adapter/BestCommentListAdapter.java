package com.example.jh.bookreader.ui.adapter;

import android.content.Context;
import android.view.View;

import com.example.jh.bookreader.R;
import com.example.jh.bookreader.base.Constant;
import com.example.jh.bookreader.bean.CommentList;
import com.example.jh.bookreader.common.OnRvItemClickListener;
import com.example.jh.easyadapterlibrary.recyclerview.EasyRVAdapter;
import com.example.jh.easyadapterlibrary.recyclerview.EasyRVHolder;

import java.util.List;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 */

public class BestCommentListAdapter extends EasyRVAdapter<CommentList.CommentsBean> {

    private OnRvItemClickListener listener;

    public BestCommentListAdapter(Context context, List<CommentList.CommentsBean> list) {
        super(context, list, R.layout.item_comment_best_list);
    }

    @Override
    protected void onBindData(final EasyRVHolder viewHolder, final int position, final CommentList.CommentsBean item) {viewHolder.setCircleImageUrl(R.id.ivBookCover, Constant.IMG_BASE_URL + item.author.avatar, R.drawable.avatar_default)
            .setText(R.id.tvBookTitle, item.author.nickname)
            .setText(R.id.tvContent, item.content)
            .setText(R.id.tvBookType, String.format(mContext.getString(R.string.book_detail_user_lv), item.author.lv))
            .setText(R.id.tvFloor, String.format(mContext.getString(R.string.comment_floor), item.floor))
            .setText(R.id.tvLikeCount, String.format(mContext.getString(R.string.comment_like_count), item.likeCount));

        viewHolder.setOnItemViewClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null)
                    listener.onItemClick(viewHolder.getItemView(), position, item);
            }
        });
    }

    public void setOnItemClickListener(OnRvItemClickListener listener){
        this.listener = listener;
    }
}
