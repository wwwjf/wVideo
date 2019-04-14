package com.jiang.wvideo.utils;

import android.support.annotation.IntDef;

import static com.jiang.wvideo.utils.MainConstantTool.BEIJING;
import static com.jiang.wvideo.utils.MainConstantTool.GUANGZHOU;
import static com.jiang.wvideo.utils.MainConstantTool.SHANGHAI;
import static com.jiang.wvideo.utils.MainConstantTool.SHENZHEN;

@IntDef({BEIJING,SHENZHEN,SHANGHAI,GUANGZHOU})
public @interface MainConstantTool {

    int BEIJING = 0;
    int SHENZHEN = 1;
    int SHANGHAI = 2;
    int GUANGZHOU = 3;
}
