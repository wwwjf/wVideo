package com.jiang.wvideo.main;

import android.support.v4.app.Fragment;

import com.jiang.wvideo.R;
import com.jiang.wvideo.main.BeijingFragment.BeijingFrgment;
import com.jiang.wvideo.main.GuanzhouFragment.GuanzhouFrgment;
import com.jiang.wvideo.main.shenzhen.shenzhenFrgment;
import com.jiang.wvideo.main.shanghai.ShangHaiFrgment;
import com.jiang.wvideo.mvp.base.BaseMvpPresenter;
import com.jiang.wvideo.utils.MainConstantTool;

public class MainActivityPresenter extends BaseMvpPresenter<IMainActivityContract.IView> implements IMainActivityContract.IPresenter {


    /**
     * 当前fragment的下标
     */
    private int mCurrentFragmentIndex;
    private Fragment[] mFragments = new Fragment[4];
    private int mCurrentCheckId;

    public MainActivityPresenter(IMainActivityContract.IView view) {
        super(view);
    }

    @Override
    protected IMainActivityContract.IView getEmptyView() {
        return IMainActivityContract.emptyView;
    }

    @Override
    public void initFragment() {

        mCurrentFragmentIndex = MainConstantTool.BEIJING;
        replaceFragment(mCurrentFragmentIndex);
    }

    /**
     * 切换fragment的方法
     *
     * @param mCurrentFragmentIndex
     */
    public void replaceFragment(int mCurrentFragmentIndex) {
        for (int i = 0; i < mFragments.length; i++) {
            if (mCurrentFragmentIndex != i) {
                if (mFragments[i] != null) {
                    hideFragment(mFragments[i]);
                }
            }
        }


        Fragment fragment = mFragments[mCurrentFragmentIndex];
        if (fragment != null) {
            addAndShowFragment(fragment);
            setCurrentChecked(mCurrentFragmentIndex);
        } else {
            newCurrentFragment(mCurrentFragmentIndex);
            setCurrentChecked(mCurrentFragmentIndex);
        }

    }

    /**
     * 记录当前下标
     *
     * @param mCurrentFragmentIndex
     */
    private void setCurrentChecked(int mCurrentFragmentIndex) {

        this.mCurrentFragmentIndex = mCurrentFragmentIndex;
        switch (mCurrentFragmentIndex) {
            case MainConstantTool.BEIJING:
                mCurrentCheckId = R.id.rb_main_nav_home_beijing;
                break;
            case MainConstantTool.SHENZHEN:
                mCurrentCheckId = R.id.rb_main_nav_home_shenzhen;
                break;
            case MainConstantTool.SHANGHAI:
                mCurrentCheckId = R.id.rb_main_nav_home_shanghai;
                break;
            case MainConstantTool.GUANGZHOU:
                mCurrentCheckId = R.id.rb_main_nav_home_guangzhou;
                break;
            default:
                break;
        }
    }

    /**
     * 创建fragment
     *
     * @param mCurrentFragmentIndex
     */
    private void newCurrentFragment(int mCurrentFragmentIndex) {
        Fragment fragment = null;
        switch (mCurrentFragmentIndex) {
            case MainConstantTool.BEIJING:
                fragment = new BeijingFrgment();
                break;
            case MainConstantTool.SHENZHEN:
                fragment = new shenzhenFrgment();
                break;
            case MainConstantTool.SHANGHAI:
                fragment = new ShangHaiFrgment();
                break;
            case MainConstantTool.GUANGZHOU:
                fragment = new GuanzhouFrgment();
                break;
            default:
                break;
        }
        if (fragment != null) {
            mFragments[mCurrentFragmentIndex] = fragment;
            addAndShowFragment(fragment);
        }
    }

    /**
     * 显示fragment
     *
     * @param fragment
     */
    private void addAndShowFragment(Fragment fragment) {
        if (fragment.isAdded()) {

            getView().showFragment(fragment);
        } else {

            getView().addFragment(fragment);
        }

    }

    /**
     * 隐藏fragment
     *
     * @param fragment
     */
    private void hideFragment(Fragment fragment) {
        if (fragment != null && fragment.isVisible()) {
            getView().hideFragment(fragment);
        }

    }
}
