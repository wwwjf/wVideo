package com.jiang.wvideo.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.widget.TextView;

import com.jiang.wvideo.base.BaseActivity;
import com.jiang.wvideo.main.MainActivity;
import com.jiang.wvideo.R;
import com.jiang.wvideo.utils.StatusBarUtil;
import com.jiang.wvideo.base.ViewInject;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 启动页
 */

@ViewInject(contentViewId = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashActivityContract.IView {

    private static final String TAG = SplashActivity.class.getSimpleName();
    @BindView(R.id.vv_splash_play)
    FullScreenVideoView mVvPlay;
    @BindView(R.id.tv_splash_ignore)
    TextView mTvIgnore;
    private ISplashActivityContract.IPresenter mTimerPresenter;


    @Override
    public void onCreateBaseActivity() {
        StatusBarUtil.hideSystemStatusBar(SplashActivity.this);
        initTimerPresenter();
        initVideo();
        initListener();
    }

    private void initTimerPresenter() {
        mTimerPresenter = new TimerPresenter(this);
        mTimerPresenter.initTimer(5);
    }

    private void initVideo() {
        mVvPlay.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
    }

    private void initListener() {
        mVvPlay.setOnPreparedListener(MediaPlayer::start);
        mVvPlay.setOnCompletionListener(MediaPlayer::start);
    }

    @Override
    protected void onResume() {
        super.onResume();
        StatusBarUtil.hideSystemStatusBar(SplashActivity.this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: -----");
    }

    @OnClick(R.id.tv_splash_ignore)
    public void onClick() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onTimerTicker(int time) {
        mTvIgnore.setText(time + "s跳过");

    }

    @Override
    public void onTimerFinish() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        finish();
    }
}
