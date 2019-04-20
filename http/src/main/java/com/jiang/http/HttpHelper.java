package com.jiang.http;

import com.jiang.http.call.ICall;
import com.jiang.http.okhttp.OkHttpScheduler;
import com.jiang.http.request.IRequest;

import java.util.Map;

class HttpHelper {

    private volatile static HttpScheduler httpScheduler;


    public static HttpScheduler getHttpScheduler(){
        if (httpScheduler == null){
            synchronized (HttpHelper.class){
                if (httpScheduler == null){
                    httpScheduler = new OkHttpScheduler();
                }
            }
        }
        return httpScheduler;
    }

    public static Object execute(IRequest request, Map<String, Object> params) {

        request.setParams(params);
        ICall call = getHttpScheduler().newCall(request);
        Object object = getHttpScheduler().execute(call);
        return object;
    }
}
