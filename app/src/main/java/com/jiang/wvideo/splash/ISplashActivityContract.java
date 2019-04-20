package com.jiang.wvideo.splash;


import com.jiang.mvp.ILifeCycle;
import com.jiang.mvp.IMvpView;
import com.jiang.mvp.MvpController;

public interface ISplashActivityContract {

    interface IView extends IMvpView {
        void onTimerTicker(int time);

        void onTimerFinish();
    }

    interface IPresenter extends ILifeCycle {
        void initTimer(int time);
    }

    IView emptyView = new IView() {
        @Override
        public void onTimerTicker(int time) {

        }

        @Override
        public void onTimerFinish() {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
