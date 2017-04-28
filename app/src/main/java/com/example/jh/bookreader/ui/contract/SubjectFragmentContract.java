package com.example.jh.bookreader.ui.contract;

import com.example.jh.bookreader.base.BaseContract;
import com.example.jh.bookreader.bean.BookLists;

import java.util.List;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 */

public interface SubjectFragmentContract {

    interface View extends BaseContract.BaseView {
        void showBookList(List<BookLists.BookListsBean> bookLists, boolean isRefresh);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookLists(String duration, String sort, int start, int limit, String tag, String gender);
    }
}

