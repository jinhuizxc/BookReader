package com.example.jh.bookreader.component;

import com.example.jh.bookreader.ui.activity.SubCategoryListActivity;
import com.example.jh.bookreader.ui.activity.SubOtherHomeRankActivity;
import com.example.jh.bookreader.ui.activity.SubRankActivity;
import com.example.jh.bookreader.ui.activity.SubjectBookListActivity;
import com.example.jh.bookreader.ui.activity.SubjectBookListDetailActivity;
import com.example.jh.bookreader.ui.activity.TopCategoryListActivity;
import com.example.jh.bookreader.ui.activity.TopRankActivity;
import com.example.jh.bookreader.ui.fragment.SubCategoryFragment;
import com.example.jh.bookreader.ui.fragment.SubRankFragment;
import com.example.jh.bookreader.ui.fragment.SubjectFragment;

import dagger.Component;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 */

@Component(dependencies = AppComponent.class)
public interface FindComponent {

    /** 分类 **/
    TopCategoryListActivity inject(TopCategoryListActivity activity);

    SubCategoryListActivity inject(SubCategoryListActivity activity);

    SubCategoryFragment inject(SubCategoryFragment fragment);

    /** 排行 **/
    TopRankActivity inject(TopRankActivity activity);

    SubRankActivity inject(SubRankActivity activity);

    SubOtherHomeRankActivity inject(SubOtherHomeRankActivity activity);

    SubRankFragment inject(SubRankFragment fragment);

    /** 主题书单 **/
    SubjectBookListActivity inject(SubjectBookListActivity subjectBookListActivity);

    SubjectFragment inject(SubjectFragment subjectFragment);

    SubjectBookListDetailActivity inject(SubjectBookListDetailActivity categoryListActivity);
}
