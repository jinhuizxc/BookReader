package com.example.jh.bookreader.manager;

import com.example.jh.bookreader.bean.support.RefreshCollectionIconEvent;
import com.example.jh.bookreader.bean.support.RefreshCollectionListEvent;
import com.example.jh.bookreader.bean.support.SubEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

public class EventManager {

    public static void refreshCollectionList() {
        EventBus.getDefault().post(new RefreshCollectionListEvent());
    }

    public static void refreshCollectionIcon() {
        EventBus.getDefault().post(new RefreshCollectionIconEvent());
    }

    public static void refreshSubCategory(String minor, String type) {
        EventBus.getDefault().post(new SubEvent(minor, type));
    }

}

