package com.linliangxu.framework.base;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.linliangxu.framework.util.ToastUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by codeest on 2016/8/2.
 * MVP Fragment基类
 */
public abstract class BaseFragment<T extends BasePresenter> extends SimpleFragment implements BaseView {

    protected T mPresenter;

    private CommonView mCommonView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        inject();
        //mPresenter.attachView(this);
        //通过获得泛型类的父类，拿到泛型的接口类实例，通过反射来实例化 presenter
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType)
            mPresenter = getCommonView().createPresenter((ParameterizedType)type);
        getCommonView().bindPresenter();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        if (mPresenter != null) mPresenter.detachView();
        getCommonView().onDestroyView();
        super.onDestroyView();
    }

    @Override
    public void message(String msg) {
        ToastUtil.showSnackBar(((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0), msg);
    }

    @Override
    public void success(String msg) {
        getCommonView().success(msg, getActivity());
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
        getCommonView().request();
    }

    @Override
    public void response() {
        getCommonView().response();
    }


    protected CommonView getCommonView() {
        if (mCommonView == null)
            mCommonView = new CommonView(getActivity(), this);
        return mCommonView;
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