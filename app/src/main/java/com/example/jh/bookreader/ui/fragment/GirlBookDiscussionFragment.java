package com.example.jh.bookreader.ui.fragment;

import com.example.jh.bookreader.R;
import com.example.jh.bookreader.base.BaseRVFragment;
import com.example.jh.bookreader.base.Constant;
import com.example.jh.bookreader.bean.DiscussionList;
import com.example.jh.bookreader.bean.support.SelectionEvent;
import com.example.jh.bookreader.component.AppComponent;
import com.example.jh.bookreader.component.DaggerCommunityComponent;
import com.example.jh.bookreader.ui.activity.BookDiscussionDetailActivity;
import com.example.jh.bookreader.ui.contract.GirlBookDiscussionContract;
import com.example.jh.bookreader.ui.easyadapter.BookDiscussionAdapter;
import com.example.jh.bookreader.ui.presenter.GirlBookDiscussionPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 *
 * 女生区Fragment
 */

public class GirlBookDiscussionFragment extends BaseRVFragment<GirlBookDiscussionPresenter, DiscussionList.PostsBean> implements GirlBookDiscussionContract.View {

    private String sort = Constant.SortType.DEFAULT;
    private String distillate = Constant.Distillate.ALL;

    @Override
    public int getLayoutResId() {
        return R.layout.common_easy_recyclerview;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerCommunityComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initDatas() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void configViews() {
        initAdapter(BookDiscussionAdapter.class, true, true);
        onRefresh();
    }

    @Override
    public void showGirlBookDisscussionList(List<DiscussionList.PostsBean> list, boolean isRefresh) {
        if (isRefresh) {
            mAdapter.clear();
            start = 0;
        }
        mAdapter.addAll(list);
        start = start + list.size();
    }

    @Override
    public void showError() {
        loaddingError();
    }

    @Override
    public void complete() {
        mRecyclerView.setRefreshing(false);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void initCategoryList(SelectionEvent event) {
        mRecyclerView.setRefreshing(true);
        sort = event.sort;
        distillate = event.distillate;
        onRefresh();
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        mPresenter.getGirlBookDisscussionList(sort, distillate, 0, limit);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getGirlBookDisscussionList(sort, distillate, start, limit);
    }

    @Override
    public void onItemClick(int position) {
        DiscussionList.PostsBean data = mAdapter.getItem(position);
        BookDiscussionDetailActivity.startActivity(activity, data._id);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

}
