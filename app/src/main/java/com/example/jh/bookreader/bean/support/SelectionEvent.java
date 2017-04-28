package com.example.jh.bookreader.bean.support;

import com.example.jh.bookreader.base.Constant;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 */

public class SelectionEvent {

    public String distillate;

    public String type;

    public String sort;

    public SelectionEvent(@Constant.Distillate String distillate,
                          @Constant.BookType String type,
                          @Constant.SortType String sort) {
        this.distillate = distillate;
        this.type = type;
        this.sort = sort;
    }

    public SelectionEvent(@Constant.SortType String sort) {
        this.sort = sort;
    }
}

