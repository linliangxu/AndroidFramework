package com.linliangxu.framework.base;

/**
 * @author : Linxu
 * @create : 2018/12/11
 * 　　       ^__^
 * 　　       (**)\ _ __ _
 * 　　       (__)\       )\/\
 * 　　        U  ||------|
 * 　　           ||     ||
 * ==============================
 * @desc : Presenter基类
 */
public interface BasePresenter<T extends BaseView>{

    void attachView(T view);

    void detachView();
}
