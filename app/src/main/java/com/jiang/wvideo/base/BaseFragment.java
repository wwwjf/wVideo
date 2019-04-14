package com.jiang.wvideo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiang.wvideo.mvp.view.LifeCycleMvpFragment;

import butterknife.ButterKnife;

public abstract class BaseFragment extends LifeCycleMvpFragment {

    private Context mContext;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mView = null;

        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation == null) {
            throw new RuntimeException("annotation 为 null");
        }
        int contentViewId = annotation.contentViewId();
        if (contentViewId <= 0) {
            throw new RuntimeException("contentViewId 为 0");
        }

        mView = initFragmentView(inflater,contentViewId);
        bindView(mView);
        onCreateBaseFragment();

        return mView;

    }

    private View initFragmentView(LayoutInflater inflater, int contentLayoutId){
        return inflater.inflate(contentLayoutId,null);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void bindView(View view) {
        ButterKnife.bind(this,view);
    }

    //模板方法设计模式
    public abstract void onCreateBaseFragment();
}
