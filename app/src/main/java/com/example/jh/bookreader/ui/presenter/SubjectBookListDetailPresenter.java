package com.example.jh.bookreader.ui.presenter;

import com.example.jh.bookreader.api.BookApi;
import com.example.jh.bookreader.base.RxPresenter;
import com.example.jh.bookreader.bean.BookListDetail;
import com.example.jh.bookreader.ui.contract.SubjectBookListDetailContract;
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

public class SubjectBookListDetailPresenter extends RxPresenter<SubjectBookListDetailContract.View> implements SubjectBookListDetailContract.Presenter<SubjectBookListDetailContract.View> {

    private BookApi bookApi;

    @Inject
    public SubjectBookListDetailPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getBookListDetail(String bookListId) {
        Subscription rxSubscription = bookApi.getBookListDetail(bookListId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookListDetail>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookListDetail:" + e.toString());
                        mView.complete();
                    }

                    @Override
                    public void onNext(BookListDetail data) {
                        mView.showBookListDetail(data);
                    }
                });
        addSubscrebe(rxSubscription);
    }

}
