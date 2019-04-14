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
    @BindView(R.id.rb_main_nav_home_beijing)
    RadioButton rbMainNavHomeBeijing;
    @BindView(R.id.rb_main_nav_home_shenzhen)
    RadioButton rbMainNavCarSourceShenzhen;
    @BindView(R.id.rb_main_nav_home_shanghai)
    RadioButton rbMainNavHomeShanghai;
    @BindView(R.id.rb_main_nav_home_guangzhou)
    RadioButton rbMainNavCarSourceGuangzhou;
    @BindView(R.id.rg_main_bottom)
    RadioGroup rgMainBottom;
    private MainActivityPresenter mPresenter = new MainActivityPresenter(this);

    @Override
    public void onCreateBaseActivity() {

        mPresenter.initFragment();
        rbMainNavHomeBeijing.setChecked(true);
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

    @OnClick({R.id.rb_main_nav_home_beijing,
            R.id.rb_main_nav_home_shenzhen,
            R.id.rb_main_nav_home_shanghai,
            R.id.rb_main_nav_home_guangzhou})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rb_main_nav_home_beijing:
                mPresenter.replaceFragment(MainConstantTool.BEIJING);
                break;
            case R.id.rb_main_nav_home_shenzhen:
                mPresenter.replaceFragment(MainConstantTool.SHENZHEN);
                break;
            case R.id.rb_main_nav_home_shanghai:
                mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
                break;
            case R.id.rb_main_nav_home_guangzhou:
                mPresenter.replaceFragment(MainConstantTool.GUANGZHOU);
                break;
        }
    }
}
