package com.jiang.wvideo.main;

import android.support.v4.app.Fragment;

import com.jiang.mvp.ILifeCycle;
import com.jiang.mvp.IMvpView;
import com.jiang.mvp.MvpController;


public interface IMainActivityContract {

    interface IView extends IMvpView {

        void showFragment(Fragment fragment);

        void addFragment(Fragment fragment);

        void hideFragment(Fragment fragment);
    }

    interface IPresenter extends ILifeCycle {

        void initFragment();
    }

    IView emptyView = new IView() {


        @Override
        public void showFragment(Fragment fragment) {

        }

        @Override
        public void addFragment(Fragment fragment) {

        }

        @Override
        public void hideFragment(Fragment fragment) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
