package com.jiang.http;

import com.jiang.http.request.IRequest;

import java.util.Map;

public class WHttpTask {

    public Object execute(IRequest request, Map<String,Object> params){

        return HttpHelper.execute(request,params);

    }
}
