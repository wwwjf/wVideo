package com.jiang.wvideo.main.categoryr.module;

import com.jiang.http.request.IRequest;
import com.jiang.http.annotation.RequestMethod;
import com.jiang.wvideo.base.JHRequest;

public class CategoryListRequest {

    public static IRequest xiaohuaRequest = JHRequest.sendHttp("/joke/content/list.php", RequestMethod.Get);


}
