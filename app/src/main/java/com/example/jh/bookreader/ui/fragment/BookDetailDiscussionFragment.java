package com.example.jh.bookreader.ui.fragment;

import android.os.Bundle;

import com.example.jh.bookreader.R;
import com.example.jh.bookreader.base.BaseRVFragment;
import com.example.jh.bookreader.base.Constant;
import com.example.jh.bookreader.bean.DiscussionList;
import com.example.jh.bookreader.bean.support.SelectionEvent;
import com.example.jh.bookreader.component.AppComponent;
import com.example.jh.bookreader.component.DaggerBookComponent;
import com.example.jh.bookreader.ui.activity.BookDiscussionDetailActivity;
import com.example.jh.bookreader.ui.contract.BookDetailDiscussionContract;
import com.example.jh.bookreader.ui.easyadapter.BookDiscussionAdapter;
import com.example.jh.bookreader.ui.presenter.BookDetailDiscussionPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;


/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 *
 * 书籍详情 讨论列表Fragment
 */

public class BookDetailDiscussionFragment extends BaseRVFragment<BookDetailDiscussionPresenter, DiscussionList.PostsBean> implements BookDetailDiscussionContract.View {

    public final static String BUNDLE_ID = "bookId";

    public static BookDetailDiscussionFragment newInstance(String id) {
        BookDetailDiscussionFragment fragment = new BookDetailDiscussionFragment();
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_ID, id);
        fragment.setArguments(bundle);
        return fragment;
    }

    private String bookId;

    private String sort = Constant.SortType.DEFAULT;

    @Override
    public int getLayoutResId() {
        return R.layout.common_easy_recyclerview;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerBookComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initDatas() {
        EventBus.getDefault().register(this);
        bookId = getArguments().getString(BUNDLE_ID);
    }

    @Override
    public void configViews() {
        initAdapter(BookDiscussionAdapter.class, true, true);
        onRefresh();
    }

    @Override
    public void showBookDetailDiscussionList(List<DiscussionList.PostsBean> list, boolean isRefresh) {
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
        if (getUserVisibleHint()) {
            mRecyclerView.setRefreshing(true);
            sort = event.sort;
            onRefresh();
        }
    }

    @Override
    public void onRefresh() {
        super.onRefresh();
        mPresenter.getBookDetailDiscussionList(bookId, sort, 0, limit);
    }

    @Override
    public void onLoadMore() {
        mPresenter.getBookDetailDiscussionList(bookId, sort, start, limit);
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
