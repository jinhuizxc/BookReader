package com.example.jh.bookreader.view.epubview;

/**
 * @author yuyh.
 * @date 2016/12/15.
 */
public interface ReaderCallback {

    String getPageHref(int position);

    void toggleToolBarVisible();

    void hideToolBarIfVisible();


}
