package com.jiang.wvideo;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.File;

/**
 * 启动页
 */
public class SplashActivity extends AppCompatActivity {

    private VideoView mVvPlay;
    private TextView mTvIgnore;
    private CustomCountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        hideSystemStatusBar();
        mVvPlay = findViewById(R.id.vv_splash_play);
        mTvIgnore = findViewById(R.id.tv_splash_ignore);
        mVvPlay.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        mVvPlay.setOnPreparedListener(MediaPlayer::start);
        mVvPlay.setOnCompletionListener(MediaPlayer::start);

        timer = new CustomCountDownTimer(5,
                new CustomCountDownTimer.ICountDownListener() {
                    @Override
                    public void onTicker(int time) {
                        mTvIgnore.setText(time + "s跳过");

                    }

                    @Override
                    public void onFinish() {
                        startActivity(new Intent(SplashActivity.this, MainActivity.class));
                        finish();
                    }
                });
        timer.start();

        mTvIgnore.setOnClickListener(v -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideSystemStatusBar();
    }

    private void hideSystemStatusBar() {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            View view = this.getWindow().getDecorView();
            view.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
