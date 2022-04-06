package com.linliangxu.framework.base;

import android.app.Activity;

/**
 * Created by codeest on 2016/8/2.
 * View基类
 */
public interface BaseView {

    Activity getActivity();

    void message(String msg);

    void success(String msg);

    void notice(String msg);

    void fail(String msg);

    void request();

    void response();

    void useNightMode(boolean isNight);

    //=======  State  =======
    void error(String msg);
    void error();

    void empty(String msg);
    void empty();

    void loading();

    void main();

    void retry();
}
