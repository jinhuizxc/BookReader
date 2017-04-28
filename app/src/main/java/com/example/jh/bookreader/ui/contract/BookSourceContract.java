package com.example.jh.bookreader.ui.contract;

import com.example.jh.bookreader.base.BaseContract;
import com.example.jh.bookreader.bean.BookSource;

import java.util.List;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 */

public interface BookSourceContract {

    interface View extends BaseContract.BaseView {
        void showBookSource(List<BookSource> list);
    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getBookSource(String view, String book);
    }

}

