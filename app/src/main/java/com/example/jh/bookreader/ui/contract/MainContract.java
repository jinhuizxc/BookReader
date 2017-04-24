package com.example.jh.bookreader.ui.contract;

import com.example.jh.bookreader.base.BaseContract;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

public interface MainContract {

    interface View extends BaseContract.BaseView {
        void loginSuccess();

        void syncBookShelfCompleted();
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {

        void login(String uid, String token, String platform);

        void syncBookShelf();
    }

}

