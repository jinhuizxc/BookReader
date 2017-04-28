package com.example.jh.bookreader.ui.fragment;

import android.os.Bundle;

import com.example.jh.bookreader.R;
import com.example.jh.bookreader.base.BaseRVFragment;
import com.example.jh.bookreader.bean.BooksByCats;
import com.example.jh.bookreader.component.AppComponent;
import com.example.jh.bookreader.component.DaggerFindComponent;
import com.example.jh.bookreader.ui.activity.BookDetailActivity;
import com.example.jh.bookreader.ui.contract.SubRankContract;
import com.example.jh.bookreader.ui.easyadapter.SubCategoryAdapter;
import com.example.jh.bookreader.ui.presenter.SubRankPresenter;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 *
 * 二级排行榜
 */

public class SubRankFragment extends BaseRVFragment<SubRankPresenter, BooksByCats.BooksBean> implements SubRankContract.View {

    public final static String BUNDLE_ID = "_id";

    public static SubRankFragment newInstance(String id) {
        SubRankFragment fragment = new SubRankFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_ID, id);
        fragment.setArguments(bundle);
        return fragment;
    }

    private String id;

    @Override
    public int getLayoutResId() {
        return R.layout.common_easy_recyclerview;
    }

    @Override
    public void initDatas() {
        id = getArguments().getString(BUNDLE_ID);
    }

    @Override
    public void configViews() {
        initAdapter(SubCategoryAdapter.class, true, false);

        onRefresh();
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerFindComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void showRankList(BooksByCats data) {
        mAdapter.clear();
        mAdapter.addAll(data.books);
    }

    @Override
    public void showError() {
        loaddingError();
    }

    @Override
    public void complete() {
        mRecyclerView.setRefreshing(false);
    }

    @Override
    public void onItemClick(int position) {
        BookDetailActivity.startActivity(activity, mAdapter.getItem(position)._id);
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        mPresenter.getRankList(id);
    }

}

