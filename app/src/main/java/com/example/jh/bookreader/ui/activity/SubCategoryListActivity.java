package com.example.jh.bookreader.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.ListPopupWindow;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.jh.bookreader.R;
import com.example.jh.bookreader.base.BaseActivity;
import com.example.jh.bookreader.base.Constant;
import com.example.jh.bookreader.bean.CategoryListLv2;
import com.example.jh.bookreader.component.AppComponent;
import com.example.jh.bookreader.component.DaggerFindComponent;
import com.example.jh.bookreader.manager.EventManager;
import com.example.jh.bookreader.ui.adapter.MinorAdapter;
import com.example.jh.bookreader.ui.contract.SubCategoryActivityContract;
import com.example.jh.bookreader.ui.fragment.SubCategoryFragment;
import com.example.jh.bookreader.ui.presenter.SubCategoryActivityPresenter;
import com.example.jh.bookreader.view.RVPIndicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by jinhui  on 2017/4/25
 * 邮箱: 1004260403@qq.com
 */

public class SubCategoryListActivity extends BaseActivity implements SubCategoryActivityContract.View {

    public static final String INTENT_CATE_NAME = "name";
    public static final String INTENT_GENDER = "gender";
    private String cate = "";
    private String gender = "";

    private String currentMinor = "";

    @Bind(R.id.indicatorSub)
    RVPIndicator mIndicator;
    @Bind(R.id.viewpagerSub)
    ViewPager mViewPager;

    @Inject
    SubCategoryActivityPresenter mPresenter;

    private List<Fragment> mTabContents;
    private FragmentPagerAdapter mAdapter;
    private List<String> mDatas;

    private List<String> mMinors = new ArrayList<>();
    private ListPopupWindow mListPopupWindow;
    private MinorAdapter minorAdapter;
    private String[] types = new String[]{Constant.CateType.NEW, Constant.CateType.HOT, Constant.CateType.REPUTATION, Constant.CateType.OVER};

    private MenuItem menuItem = null;

    public static void startActivity(Context context, String name, @Constant.Gender String gender) {
        Intent intent = new Intent(context, SubCategoryListActivity.class);
        intent.putExtra(INTENT_CATE_NAME, name);
        intent.putExtra(INTENT_GENDER, gender);
        context.startActivity(intent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_sub_category_list;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerFindComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initToolBar() {
        cate = getIntent().getStringExtra(INTENT_CATE_NAME);
        if (menuItem != null) {
            menuItem.setTitle(cate);
        }
        gender = getIntent().getStringExtra(INTENT_GENDER);
        mCommonToolbar.setTitle(cate);
        mCommonToolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initDatas() {
        mDatas = Arrays.asList(getResources().getStringArray(R.array.sub_tabs));

        mPresenter.attachView(this);
        mPresenter.getCategoryListLv2();

        mTabContents = new ArrayList<>();
        mTabContents.add(SubCategoryFragment.newInstance(cate, "", gender, Constant.CateType.NEW));
        mTabContents.add(SubCategoryFragment.newInstance(cate, "", gender, Constant.CateType.HOT));
        mTabContents.add(SubCategoryFragment.newInstance(cate, "", gender, Constant.CateType.REPUTATION));
        mTabContents.add(SubCategoryFragment.newInstance(cate, "", gender, Constant.CateType.OVER));

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mTabContents.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mTabContents.get(position);
            }
        };
    }

    @Override
    public void configViews() {
        mIndicator.setTabItemTitles(mDatas);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOffscreenPageLimit(4);
        mIndicator.setViewPager(mViewPager, 0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                EventManager.refreshSubCategory(currentMinor, types[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void showCategoryList(CategoryListLv2 data) {
        mMinors.clear();
        mMinors.add(cate);
        if (gender.equals(Constant.Gender.MALE)) {
            for (CategoryListLv2.MaleBean bean : data.male) {
                if (cate.equals(bean.major)) {
                    mMinors.addAll(bean.mins);
                    break;
                }
            }
        } else {
            for (CategoryListLv2.MaleBean bean : data.female) {
                if (cate.equals(bean.major)) {
                    mMinors.addAll(bean.mins);
                    break;
                }
            }
        }
        minorAdapter = new MinorAdapter(this, mMinors);
        minorAdapter.setChecked(0);
        currentMinor = "";
        EventManager.refreshSubCategory(currentMinor, Constant.CateType.NEW);
    }

    @Override
    public void showError() {

    }

    @Override
    public void complete() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sub_category, menu);
        menuItem = menu.findItem(R.id.menu_major);
        if (!TextUtils.isEmpty(cate)) {
            menuItem.setTitle(cate);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_major) {
            showMinorPopupWindow();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void showMinorPopupWindow() {
        if (mMinors.size() > 0 && minorAdapter != null) {
            if (mListPopupWindow == null) {
                mListPopupWindow = new ListPopupWindow(this);
                mListPopupWindow.setAdapter(minorAdapter);
                mListPopupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                mListPopupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
                mListPopupWindow.setAnchorView(mCommonToolbar);
                mListPopupWindow.setModal(true);
                mListPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        minorAdapter.setChecked(position);
                        if (position > 0) {
                            currentMinor = mMinors.get(position);
                        } else {
                            currentMinor = "";
                        }
                        int current = mViewPager.getCurrentItem();
                        EventManager.refreshSubCategory(currentMinor, types[current]);
                        mListPopupWindow.dismiss();
                        mCommonToolbar.setTitle(mMinors.get(position));
                    }
                });
            }
            mListPopupWindow.show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
