package com.linliangxu.framework.base;

import android.app.Activity;

/**
 * @author : Linxu
 * @create : 2018/12/11
 * 　　       ^__^
 * 　　       (**)\ _ __ _
 * 　　       (__)\       )\/\
 * 　　        U  ||------|
 * 　　           ||     ||
 * ==============================
 * @desc : View基类
 */
public interface BaseView {

    Activity getActivity();

    void message(String msg);

    void success(String msg);

    void notice(String msg);

    void fail(String msg);

    void request();

    void response();

    int getRequestNumber();

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
