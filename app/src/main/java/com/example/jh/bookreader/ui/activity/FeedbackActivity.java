package com.example.jh.bookreader.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.example.jh.bookreader.R;
import com.example.jh.bookreader.base.BaseActivity;
import com.example.jh.bookreader.component.AppComponent;
import com.example.jh.bookreader.view.ProgressWebView;

import butterknife.Bind;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

public class FeedbackActivity extends BaseActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, FeedbackActivity.class));
    }

    @Bind(R.id.feedbackView)
    ProgressWebView feedbackView;

    @Override
    public int getLayoutId() {
        return R.layout.activity_feedback;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setTitle("反馈建议");
        mCommonToolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {
        feedbackView.loadUrl("https://github.com/JustWayward/BookReader/issues/new");
    }
}
