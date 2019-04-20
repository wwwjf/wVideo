package com.jiang.wvideo.base;

import com.jiang.http.request.IHost;

public interface HostManager {

    IHost jhHost = new IHost() {

        @Override
        public String getHost() {
            return "http://v.juhe.cn";
        }

        @Override
        public String getDefaultPath() {
            return "/joke/content/list.php";
        }
    };
}
