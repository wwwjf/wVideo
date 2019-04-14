package com.jiang.wvideo.main.BeijingFragment;

import android.util.Log;

import com.jiang.wvideo.R;
import com.jiang.wvideo.base.BaseFragment;
import com.jiang.wvideo.base.ViewInject;


@ViewInject(contentViewId = R.layout.fragment_beijing)
public class BeijingFrgment extends BaseFragment {

    private static final String TAG = BeijingFrgment.class.getSimpleName();

    @Override
    public void onCreateBaseFragment() {
        Log.e(TAG, "onCreateBaseFragment: +++++");
    }
}
