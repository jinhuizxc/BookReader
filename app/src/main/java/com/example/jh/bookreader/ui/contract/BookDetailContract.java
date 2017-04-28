package com.example.jh.bookreader.ui.contract;

import com.example.jh.bookreader.base.BaseContract;
import com.example.jh.bookreader.bean.BookDetail;
import com.example.jh.bookreader.bean.HotReview;
import com.example.jh.bookreader.bean.RecommendBookList;

import java.util.List;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 */

public interface BookDetailContract {

    interface View extends BaseContract.BaseView {
        void showBookDetail(BookDetail data);

        void showHotReview(List<HotReview.Reviews> list);

        void showRecommendBookList(List<RecommendBookList.RecommendBook> list);
    }

    interface Presenter<T> extends BaseContract.BasePresenter<T> {
        void getBookDetail(String bookId);

        void getHotReview(String book);

        void getRecommendBookList(String bookId, String limit);
    }

}
