package com.example.jh.bookreader.bean.support;

import java.io.Serializable;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

public class BookMark implements Serializable {

    public int chapter;

    public String title;

    public int startPos;

    public int endPos;

    public String desc = "";
}
