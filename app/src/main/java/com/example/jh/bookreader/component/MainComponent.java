package com.example.jh.bookreader.component;

import com.example.jh.bookreader.ui.activity.MainActivity;
import com.example.jh.bookreader.ui.activity.SettingActivity;
import com.example.jh.bookreader.ui.activity.WifiBookActivity;
import com.example.jh.bookreader.ui.fragment.RecommendFragment;

import dagger.Component;

/**
 * Created by jinhui  on 2017/4/24
 * 邮箱: 1004260403@qq.com
 */

@Component(dependencies = AppComponent.class)
public interface MainComponent {

    MainActivity inject(MainActivity activity);

    RecommendFragment inject(RecommendFragment fragment);
//
    SettingActivity inject(SettingActivity activity);
    WifiBookActivity inject(WifiBookActivity activity);
}