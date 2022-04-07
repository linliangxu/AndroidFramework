package com.linliangxu.framework.util;

import android.content.Context;

import com.linliangxu.framework.base.Frame;


/**
 * 博客: http://hackware.lucode.net
 * Created by hackware on 2016/6/26.
 */
public final class UIUtil {

    public static int dip2px(double dpValue) {
        return dip2px(Frame.getContext(), dpValue);
    }

    public static int dip2px(Context context, double dpValue) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * density + 0.5);
    }

    public static int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }
}