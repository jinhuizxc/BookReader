package com.example.jh.bookreader.bean.user;

import com.example.jh.bookreader.bean.base.Base;

import java.util.List;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

public class Following extends Base {


    /**
     * _id : 52f840b982cfcc3a74031693
     * avatar : /avatar/56/a9/56a96462a50ca99f9cf83440899e46f3
     * nickname : 追书首席打杂
     * followers : 4662
     * followings : 107
     * tweets : 949
     */

    public List<FollowingsBean> followings;

    public static class FollowingsBean {
        public String _id;
        public String avatar;
        public String nickname;
        public int followers;
        public int followings;
        public int tweets;
    }
}
