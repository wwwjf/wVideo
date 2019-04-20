package com.jiang.wvideo.main.categoryr.module;

import com.jiang.http.WHttpTask;

import java.util.HashMap;
import java.util.Map;

public class CategoryHttpTask extends WHttpTask {

    public Object getXiaoHuaList(String sort,String page,String pageSize){
        Map<String,Object> params = new HashMap<>();
        params.put("sort",sort);
        params.put("page",page);
        params.put("pageszie",pageSize);
        params.put("time",(System.currentTimeMillis()/1000)+"");
        params.put("key","bbc57dd5e4f05991aff09eafd2e667e0");
        return super.execute(CategoryListRequest.xiaohuaRequest,params);
    }
}
