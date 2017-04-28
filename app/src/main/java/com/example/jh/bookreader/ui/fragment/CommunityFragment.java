package com.example.jh.bookreader.ui.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.jh.bookreader.R;
import com.example.jh.bookreader.base.BaseFragment;
import com.example.jh.bookreader.bean.support.FindBean;
import com.example.jh.bookreader.common.OnRvItemClickListener;
import com.example.jh.bookreader.component.AppComponent;
import com.example.jh.bookreader.ui.activity.BookDiscussionActivity;
import com.example.jh.bookreader.ui.activity.BookHelpActivity;
import com.example.jh.bookreader.ui.activity.BookReviewActivity;
import com.example.jh.bookreader.ui.activity.GirlBookDiscussionActivity;
import com.example.jh.bookreader.ui.adapter.FindAdapter;
import com.example.jh.bookreader.view.SupportDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

public class CommunityFragment extends BaseFragment implements OnRvItemClickListener<FindBean> {

    @Bind(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private FindAdapter mAdapter;
    private List<FindBean> mList = new ArrayList<>();

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_find;
    }

    @Override
    public void initDatas() {
        mList.clear();
        mList.add(new FindBean("综合讨论区", R.drawable.discuss_section));
        mList.add(new FindBean("书评区", R.drawable.comment_section));
        mList.add(new FindBean("书荒互助区", R.drawable.helper_section));
        mList.add(new FindBean("女生区", R.drawable.girl_section));
        mList.add(new FindBean("原创区",R.drawable.yuanchuang));
    }

    @Override
    public void configViews() {
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.addItemDecoration(new SupportDividerItemDecoration(mContext, LinearLayoutManager.VERTICAL, true));

        mAdapter = new FindAdapter(mContext, mList, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    public void attachView() {

    }

    @Override
    public void onItemClick(View view, int position, FindBean data) {
        switch (position) {
            case 0:
                BookDiscussionActivity.startActivity(activity,true);
                break;
            case 1:
                BookReviewActivity.startActivity(activity);
                break;
            case 2:
                BookHelpActivity.startActivity(activity);
                break;
            case 3:
                GirlBookDiscussionActivity.startActivity(activity);
                break;
            case 4:
                BookDiscussionActivity.startActivity(activity,false);
                break;
            default:
                break;
        }
    }

}