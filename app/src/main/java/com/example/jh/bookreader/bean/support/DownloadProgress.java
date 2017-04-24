package com.example.jh.bookreader.bean.support;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

public class DownloadProgress {

    public String bookId;

    public String message;

    public boolean isAlreadyDownload = false;

    public DownloadProgress(String bookId, String message, boolean isAlreadyDownload) {
        this.bookId = bookId;
        this.message = message;
        this.isAlreadyDownload = isAlreadyDownload;
    }
}

