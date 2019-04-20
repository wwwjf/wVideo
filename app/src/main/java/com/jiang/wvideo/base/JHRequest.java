package com.jiang.wvideo.base;

import com.jiang.http.request.IRequest;
import com.jiang.http.annotation.RequestMethod;
import com.jiang.http.request.WRequest;

public class JHRequest extends WRequest {

    public static IRequest sendHttp(String path, @RequestMethod int requestMethod){

        JHRequest request = new JHRequest();

        request.host = HostManager.jhHost;

        request.path = path;

        request.requestMethod = requestMethod;
        return request;

    }
}
