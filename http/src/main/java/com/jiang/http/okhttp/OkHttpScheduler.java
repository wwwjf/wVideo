package com.jiang.http.okhttp;

import com.jiang.http.HttpScheduler;
import com.jiang.http.annotation.RequestMethod;
import com.jiang.http.call.ICall;
import com.jiang.http.request.IRequest;

import java.util.Map;

import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpScheduler extends HttpScheduler {


    private OkHttpClient client;

    @Override
    public ICall newCall(IRequest request) {
        Map<String, Object> params = request.getParams();
        int requestMethod = request.getRequestMethod();
        Request.Builder requestBuilder = new Request.Builder();

        switch (requestMethod) {
            case RequestMethod.Get:
                StringBuilder urlStrBuilder = new StringBuilder(request.getHost().getHost());
                urlStrBuilder.append(request.getPath());
                HttpUrl.Builder urlBuilder = HttpUrl.parse(urlStrBuilder.toString()).newBuilder();

                if (params!= null && params.size() >0){
                    for (Map.Entry<String, Object> next : params.entrySet()) {
                        urlBuilder.addQueryParameter(next.getKey(), String.valueOf(next.getValue()));
                    }
                }
                requestBuilder.get().url(urlBuilder.build());
                break;
            case RequestMethod.Post:
                break;
            default:
                break;
        }

        Request okhttpRequest = requestBuilder.build();

        Call call = getClient().newCall(okhttpRequest);

        OkHttpCall okhttpCall = new OkHttpCall(request,call);
        return okhttpCall;
    }

    private OkHttpClient getClient() {
        if (client == null){
            client = new OkHttpClient();
        }
        return client;
    }
}
