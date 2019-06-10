package com.jiang.wvideo.main;

import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jiang.wvideo.R;
import com.jiang.wvideo.base.BaseActivity;
import com.jiang.wvideo.base.ViewInject;
import com.jiang.wvideo.utils.MainConstantTool;

import butterknife.BindView;
import butterknife.OnClick;


@ViewInject(contentViewId = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainActivityContract.IView {

    @BindView(R.id.fl_main_content)
    FrameLayout flMainContent;
    @BindView(R.id.rb_main_nav_home)
    RadioButton rbMainNavHome;
    @BindView(R.id.rb_main_nav_mine)
    RadioButton rbMainNavMine;
    @BindView(R.id.rb_main_nav_category)
    RadioButton rbMainNavCategory;
    @BindView(R.id.rb_main_nav_search)
    RadioButton rbMainNavSearch;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;
    private MainActivityPresenter mPresenter = new MainActivityPresenter(this);

    @Override
    public void onCreateBaseActivity() {

        mPresenter.initFragment();
        rbMainNavHome.setChecked(true);
    }

    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main_content, fragment).commit();
    }

    @Override
    public void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }

    @OnClick({R.id.rb_main_nav_home,
            R.id.rb_main_nav_mine,
            R.id.rb_main_nav_category,
            R.id.rb_main_nav_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_main_nav_home:
                mPresenter.replaceFragment(MainConstantTool.MAIN_HOME);
                break;
            case R.id.rb_main_nav_category:
                mPresenter.replaceFragment(MainConstantTool.MAIN_CATEGORY);
                break;
            case R.id.rb_main_nav_search:
                mPresenter.replaceFragment(MainConstantTool.MAIN_SEARCH);
                break;
            case R.id.rb_main_nav_mine:
                mPresenter.replaceFragment(MainConstantTool.MAIN_MINE);
                break;
        }
    }
}
