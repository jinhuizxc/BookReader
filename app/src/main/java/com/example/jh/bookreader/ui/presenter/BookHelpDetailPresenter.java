package com.example.jh.bookreader.ui.presenter;

import com.example.jh.bookreader.api.BookApi;
import com.example.jh.bookreader.base.RxPresenter;
import com.example.jh.bookreader.bean.BookHelp;
import com.example.jh.bookreader.bean.CommentList;
import com.example.jh.bookreader.ui.contract.BookHelpDetailContract;
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

public class BookHelpDetailPresenter extends RxPresenter<BookHelpDetailContract.View> implements BookHelpDetailContract.Presenter {

    private BookApi bookApi;

    @Inject
    public BookHelpDetailPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getBookHelpDetail(String id) {
        Subscription rxSubscription = bookApi.getBookHelpDetail(id).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookHelp>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookHelpDetail:" + e.toString());
                    }

                    @Override
                    public void onNext(BookHelp bookHelp) {
                        mView.showBookHelpDetail(bookHelp);
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
    public void getBookHelpComments(String disscussionId, int start, int limit) {
        Subscription rxSubscription = bookApi.getBookReviewComments(disscussionId, start + "", limit + "")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentList>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookHelpComments:" + e.toString());
                    }

                    @Override
                    public void onNext(CommentList list) {
                        mView.showBookHelpComments(list);
                    }
                });
        addSubscrebe(rxSubscription);
    }

}
