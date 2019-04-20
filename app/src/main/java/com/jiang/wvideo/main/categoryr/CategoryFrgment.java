package com.jiang.wvideo.main.categoryr;

import android.util.Log;

import com.jiang.wvideo.R;
import com.jiang.wvideo.base.BaseFragment;
import com.jiang.wvideo.base.ViewInject;
import com.jiang.wvideo.main.categoryr.module.CategoryHttpTask;

import java.io.IOException;

import okhttp3.Response;

@ViewInject(contentViewId = R.layout.fragment_category)
public class CategoryFrgment extends BaseFragment {

    public static final String TAG = CategoryFrgment.class.getSimpleName();
    @Override
    public void onCreateBaseFragment() {


//        new Thread(CategoryFrgment.this::initGetNetData).start();

    }

    private void initGetNetData() {
        Object desc = new CategoryHttpTask().getXiaoHuaList("desc", "1", "1");

        if (desc instanceof Response){
            Response response = (Response) desc;
            try {
                Log.e(TAG, "initGetNetData: "+response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
