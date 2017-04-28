package com.example.jh.bookreader.ui.presenter;

import com.example.jh.bookreader.api.BookApi;
import com.example.jh.bookreader.base.RxPresenter;
import com.example.jh.bookreader.bean.CommentList;
import com.example.jh.bookreader.bean.Disscussion;
import com.example.jh.bookreader.ui.contract.BookDiscussionDetailContract;
import com.example.jh.bookreader.utils.LogUtils;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 */

public class BookDiscussionDetailPresenter extends RxPresenter<BookDiscussionDetailContract.View> implements BookDiscussionDetailContract.Presenter {

    private BookApi bookApi;

    @Inject
    public BookDiscussionDetailPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getBookDisscussionDetail(String id) {
        Subscription rxSubscription = bookApi.getBookDisscussionDetail(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Disscussion>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookDisscussionDetail:" + e.toString());
                    }

                    @Override
                    public void onNext(Disscussion disscussion) {
                        mView.showBookDisscussionDetail(disscussion);
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public void getBestComments(String disscussionId) {
        Subscription rxSubscription = bookApi.getBestComments(disscussionId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBestComments:" + e.toString());
                    }

                    @Override
                    public void onNext(CommentList list) {
                        mView.showBestComments(list);
                    }
                });
        addSubscrebe(rxSubscription);
    }

    @Override
    public void getBookDisscussionComments(String disscussionId, int start, int limit) {
        Subscription rxSubscription = bookApi.getBookDisscussionComments(disscussionId, start + "", limit + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookDisscussionComments:" + e.toString());
                    }

                    @Override
                    public void onNext(CommentList list) {
                        mView.showBookDisscussionComments(list);
                    }
                });
        addSubscrebe(rxSubscription);
    }

}