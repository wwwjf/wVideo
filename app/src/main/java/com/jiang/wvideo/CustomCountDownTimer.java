package com.jiang.wvideo;


import android.os.Handler;

public class CustomCountDownTimer implements Runnable{

    private final ICountDownListener countDownListener;
    private int time;
    private final Handler handler;
    private boolean isRun;

    public CustomCountDownTimer(int time, ICountDownListener countDownListener){
        this.handler = new Handler();
        this.time = time;
        this.countDownListener = countDownListener;
    }

    @Override
    public void run() {

        if (!isRun){
            return;
        }
        if (countDownListener == null){
            return;
        }
        countDownListener.onTicker(time);
        if (time == 0){
            countDownListener.onFinish();
        } else {
             time--;
             handler.postDelayed(this,1000);
        }
    }

    public void start(){
        isRun = true;
        handler.post(this);
    }


    public void cancel(){
        isRun = false;
        handler.removeCallbacks(this);
    }

    public interface ICountDownListener {

        void onTicker(int time);

        void onFinish();
    }
}
