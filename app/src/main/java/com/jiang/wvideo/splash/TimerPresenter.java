package com.jiang.wvideo.splash;

import android.util.Log;

import com.jiang.mvp.base.BaseMvpPresenter;


public class TimerPresenter extends BaseMvpPresenter<ISplashActivityContract.IView> implements ISplashActivityContract.IPresenter {

    private static final String TAG = TimerPresenter.class.getSimpleName();
    private CustomCountDownTimer timer;

    public TimerPresenter(ISplashActivityContract.IView view) {
        super(view);
    }


    public void initTimer(int time) {
        timer = new CustomCountDownTimer(time,
                new CustomCountDownTimer.ICountDownListener() {
                    @Override
                    public void onTicker(int time) {
                        getView().onTimerTicker(time);

                    }

                    @Override
                    public void onFinish() {
                        getView().onTimerFinish();
                    }
                });
        timer.start();
    }

    private void timerCancel(){
        timer.cancel();
    }

    @Override
    protected ISplashActivityContract.IView getEmptyView() {
        return ISplashActivityContract.emptyView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timerCancel();
        Log.e(TAG, "onDestroy: =====");
    }
}
