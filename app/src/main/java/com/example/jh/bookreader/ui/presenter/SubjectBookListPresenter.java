package com.example.jh.bookreader.ui.presenter;

import com.example.jh.bookreader.api.BookApi;
import com.example.jh.bookreader.base.RxPresenter;
import com.example.jh.bookreader.bean.BookListTags;
import com.example.jh.bookreader.ui.contract.SubjectBookListContract;
import com.example.jh.bookreader.utils.LogUtils;
import com.example.jh.bookreader.utils.RxUtil;
import com.example.jh.bookreader.utils.StringUtils;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 */

public class SubjectBookListPresenter extends RxPresenter<SubjectBookListContract.View> implements SubjectBookListContract.Presenter<SubjectBookListContract.View> {

    private BookApi bookApi;

    @Inject
    public SubjectBookListPresenter(BookApi bookApi) {
        this.bookApi = bookApi;
    }

    @Override
    public void getBookListTags() {
        String key = StringUtils.creatAcacheKey("book-list-tags");
        Observable<BookListTags> fromNetWork = bookApi.getBookListTags()
                .compose(RxUtil.<BookListTags>rxCacheListHelper(key));

        //依次检查disk、network
        Subscription rxSubscription = Observable.concat(RxUtil.rxCreateDiskObservable(key, BookListTags.class), fromNetWork)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BookListTags>() {
                    @Override
                    public void onCompleted() {
                        mView.complete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("getBookListTags:" + e.toString());
                        mView.showError();
                    }

                    @Override
                    public void onNext(BookListTags tags) {
                        mView.showBookListTags(tags);
                    }
                });
        addSubscrebe(rxSubscription);
    }

}