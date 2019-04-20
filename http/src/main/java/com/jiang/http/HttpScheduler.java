package com.jiang.http;

import com.jiang.http.call.ICall;
import com.jiang.http.request.IRequest;

public abstract class HttpScheduler {
    public abstract ICall newCall(IRequest request);

    public Object execute(ICall call){
        return call.execute();
    }
}
