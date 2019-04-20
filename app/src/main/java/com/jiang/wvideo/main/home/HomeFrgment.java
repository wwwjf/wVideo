package com.jiang.wvideo.main.home;

import android.util.Log;

import com.jiang.wvideo.R;
import com.jiang.wvideo.base.BaseFragment;
import com.jiang.wvideo.base.ViewInject;


@ViewInject(contentViewId = R.layout.fragment_home)
public class HomeFrgment extends BaseFragment {

    private static final String TAG = HomeFrgment.class.getSimpleName();

    @Override
    public void onCreateBaseFragment() {
        Log.e(TAG, "onCreateBaseFragment: +++++");
    }
}
