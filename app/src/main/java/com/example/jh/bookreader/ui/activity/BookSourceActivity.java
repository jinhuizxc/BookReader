package com.example.jh.bookreader.ui.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;

import com.example.jh.bookreader.R;
import com.example.jh.bookreader.base.BaseRVActivity;
import com.example.jh.bookreader.bean.BookSource;
import com.example.jh.bookreader.component.AppComponent;
import com.example.jh.bookreader.component.DaggerBookComponent;
import com.example.jh.bookreader.ui.contract.BookSourceContract;
import com.example.jh.bookreader.ui.easyadapter.BookSourceAdapter;
import com.example.jh.bookreader.ui.presenter.BookSourcePresenter;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 */

public class BookSourceActivity extends BaseRVActivity<BookSource> implements BookSourceContract.View {

    public static final String INTENT_BOOK_ID = "bookId";

    public static void start(Activity activity, String bookId, int reqId) {
        activity.startActivityForResult(new Intent(activity, BookSourceActivity.class)
                .putExtra(INTENT_BOOK_ID, bookId), reqId);
    }

    @Inject
    BookSourcePresenter mPresenter;

    private String bookId = "";

    @Override
    public int getLayoutId() {
        return R.layout.activity_common_recyclerview;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerBookComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initToolBar() {
        bookId = getIntent().getStringExtra(INTENT_BOOK_ID);
        mCommonToolbar.setTitle("选择来源");
        mCommonToolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initDatas() {
        initAdapter(BookSourceAdapter.class, false, false);
    }

    @Override
    public void configViews() {
        mPresenter.attachView(this);
        mPresenter.getBookSource("summary", bookId);

        new AlertDialog.Builder(this)
                .setMessage("换源功能暂未实现，后续更新...")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
    }

    @Override
    public void onItemClick(int position) {
        BookSource data = mAdapter.getItem(position);
        Intent intent = new Intent();
        intent.putExtra("source", data);
        setResult(RESULT_OK, intent);
        finish();
    }


    @Override
    public void showBookSource(List<BookSource> list) {
        mAdapter.clear();
        mAdapter.addAll(list);
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
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

}
