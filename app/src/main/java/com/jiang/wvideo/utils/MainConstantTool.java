package com.jiang.wvideo.utils;

import android.support.annotation.IntDef;

import static com.jiang.wvideo.utils.MainConstantTool.MAIN_HOME;
import static com.jiang.wvideo.utils.MainConstantTool.MAIN_MINE;
import static com.jiang.wvideo.utils.MainConstantTool.MAIN_SEARCH;
import static com.jiang.wvideo.utils.MainConstantTool.MAIN_CATEGORY;

@IntDef({MAIN_HOME, MAIN_CATEGORY, MAIN_SEARCH, MAIN_MINE})
public @interface MainConstantTool {

    int MAIN_HOME = 0;
    int MAIN_CATEGORY = 1;
    int MAIN_SEARCH = 2;
    int MAIN_MINE = 3;
}
