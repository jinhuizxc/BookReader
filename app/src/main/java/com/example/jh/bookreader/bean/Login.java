package com.example.jh.bookreader.bean;

import com.example.jh.bookreader.bean.base.Base;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

public class Login extends Base {


    /**
     * _id : 57cbf0278b37eb5f05496f8b
     * nickname : ✘。
     * avatar : /avatar/eb/a0/eba095c72cc992bdea6539ce1cfd0aff
     * exp : 0
     * lv : 1
     * gender : female
     * type : normal
     */

    public UserBean user;
    /**
     * user : {"_id":"57cbf0278b37eb5f05496f8b","nickname":"✘。","avatar":"/avatar/eb/a0/eba095c72cc992bdea6539ce1cfd0aff","exp":0,"lv":1,"gender":"female","type":"normal"}
     * token : gmPcsbwQ41UfTQEc7yMnBiRY
     */

    public String token;

    public static class UserBean {
        public String _id;
        public String nickname;
        public String avatar;
        public int exp;
        public int lv;
        public String gender;
        public String type;

        @Override
        public String toString() {
            return "UserBean{" +
                    "_id='" + _id + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", exp=" + exp +
                    ", lv=" + lv +
                    ", gender='" + gender + '\'' +
                    ", type='" + type + '\'' +
                    '}';
        }
    }


}
