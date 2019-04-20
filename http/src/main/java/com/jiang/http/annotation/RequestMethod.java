package com.jiang.http.annotation;

import android.support.annotation.IntDef;

import static com.jiang.http.annotation.RequestMethod.Get;
import static com.jiang.http.annotation.RequestMethod.Post;

@IntDef({Get,Post})
public @interface RequestMethod {

    int Get = 1;
    int Post = 2;
}
