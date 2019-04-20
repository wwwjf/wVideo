package com.jiang.http.request;

import com.jiang.http.annotation.RequestMethod;

import java.util.Map;

public class WRequest implements IRequest {

    protected IHost host;
    protected String path;

    protected Map<String,Object> params;
    @RequestMethod
    protected int requestMethod;


    @Override
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public int getRequestMethod() {
        return requestMethod;
    }

    @Override
    public IHost getHost() {
        return host;
    }

    @Override
    public String getPath() {
        return path;
    }
}
