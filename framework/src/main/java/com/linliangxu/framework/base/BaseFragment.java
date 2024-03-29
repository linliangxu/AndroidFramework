package com.linliangxu.framework.base;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.linliangxu.framework.util.ToastUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author : Linxu
 * @create : 2018/12/11
 * 　　       ^__^
 * 　　       (**)\ _ __ _
 * 　　       (__)\       )\/\
 * 　　        U  ||------|
 * 　　           ||     ||
 * ==============================
 * @desc : MVP Fragment基类
 */
public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView {

    protected T mPresenter;

    private RootView mRootView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        inject();

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void onViewCreated() {
        super.onViewCreated();

        //mPresenter.attachView(this);
        //通过获得泛型类的父类，拿到泛型的接口类实例，通过反射来实例化 presenter
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType)
            mPresenter = viewRoot().createPresenter((ParameterizedType)type);
        viewRoot().bindPresenter();
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) mPresenter.detachView();
        viewRoot().onDestroyView();
        super.onDestroyView();
    }

    @Override
    public void message(String msg) {
        ToastUtil.showSnackBar(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void success(String msg) {
        viewRoot().success(msg, getActivity());
    }

    @Override
    public void notice(String msg) {
        message(msg);
    }

    @Override
    public void fail(String msg) {
        message(msg);
    }

    @Override
    public void useNightMode(boolean isNight) {

    }

    @Override
    public void request() {
        viewRoot().request();
    }

    @Override
    public void response() {
        viewRoot().response();
    }

    @Override
    public int getRequestNumber() {
        return viewRoot().getRequestNumber();
    }

    protected RootView viewRoot() {
        if (mRootView == null)
            mRootView = new RootView(getActivity(), this);
        return mRootView;
    }

    @Override
    public void error() {}

    @Override
    public void error(String msg) {}

    @Override
    public void empty() {}

    @Override
    public void loading() {}

    @Override
    public void main() {}

    @Override
    public void retry() {}

    protected void inject() {}
}