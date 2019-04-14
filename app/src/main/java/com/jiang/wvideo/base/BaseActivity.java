package com.jiang.wvideo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.jiang.wvideo.mvp.view.LifeCycleMvpActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends LifeCycleMvpActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation == null) {
            throw new RuntimeException("annotation 为 null");
        }
        int contentViewId = annotation.contentViewId();
        if (contentViewId <= 0) {
            throw new RuntimeException("contentViewId 为 0");
        }
        setContentView(contentViewId);
        bindView();
        onCreateBaseActivity();
    }

    private void bindView() {
        ButterKnife.bind(this);
    }

    //模板方法设计模式
    public abstract void onCreateBaseActivity();
}
