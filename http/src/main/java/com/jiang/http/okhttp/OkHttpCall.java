package com.jiang.http.okhttp;

import com.jiang.http.call.ICall;
import com.jiang.http.request.IRequest;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;

public class OkHttpCall implements ICall {

    private final Call call;

    public OkHttpCall(IRequest request, Call call) {
        this.call = call;
    }

    @Override
    public Object execute() {
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
