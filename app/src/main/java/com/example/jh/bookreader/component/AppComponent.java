package com.example.jh.bookreader.component;

import android.content.Context;

import com.example.jh.bookreader.api.BookApi;
import com.example.jh.bookreader.module.AppModule;
import com.example.jh.bookreader.module.BookApiModule;

import dagger.Component;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

@Component(modules = {AppModule.class, BookApiModule.class})
public interface AppComponent {

    Context getContext();

    BookApi getReaderApi();

}