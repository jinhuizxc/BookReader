package com.example.jh.bookreader.module;

import com.example.jh.bookreader.api.BookApi;
import com.example.jh.bookreader.api.support.HeaderInterceptor;
import com.example.jh.bookreader.api.support.LoggingInterceptor;

import java.util.concurrent.TimeUnit;
import com.example.jh.bookreader.api.support.Logger;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

@Module
public class BookApiModule {

    @Provides
    public OkHttpClient provideOkHttpClient() {

        LoggingInterceptor logging = new LoggingInterceptor(new Logger());
        logging.setLevel(LoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(new HeaderInterceptor())
                .addInterceptor(logging);
        return builder.build();
    }

    @Provides
    protected BookApi provideBookService(OkHttpClient okHttpClient) {
        return BookApi.getInstance(okHttpClient);
    }
}
