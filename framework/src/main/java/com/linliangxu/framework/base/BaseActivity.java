package com.linliangxu.framework.base;

import android.app.Activity;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatDelegate;

import com.linliangxu.framework.util.ToastUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by codeest on 2016/8/2.
 * MVP activity基类
 */
public abstract class BaseActivity<T extends BasePresenter> extends SimpleActivity implements BaseView {

    protected T mPresenter;

    private CommonView mCommonView;


    @Override
    protected void onViewCreated() {
        super.onViewCreated();
        inject();
        //if (mPresenter != null)
        //    mPresenter.attachView(this);
        //通过获得泛型类的父类，拿到泛型的接口类实例，通过反射来实例化 presenter
        Type type = this.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType)
            mPresenter = getCommonView().createPresenter((ParameterizedType)type);
        getCommonView().bindPresenter();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null)
            mPresenter.detachView();

        getCommonView().onDestroyView();

        super.onDestroy();
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void message(String msg) {
        ToastUtil.showSnackBar(((ViewGroup) findViewById(android.R.id.content)).getChildAt(0), msg);
    }


    @Override
    public void success(String msg) {
        getCommonView().success(msg, this);
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
    public void request() {
        getCommonView().request();
    }

    @Override
    public void response() {
        getCommonView().response();
    }

    @Override
    public int getRequestNumber() {
        return getCommonView().getRequestNumber();
    }

    protected CommonView getCommonView() {
        if (mCommonView == null)
            mCommonView = new CommonView(this, this);
        return mCommonView;
    }


    @Override
    public void useNightMode(boolean isNight) {
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(
                    AppCompatDelegate.MODE_NIGHT_NO);
        }
        recreate();
    }

    @Override
    public void error() {}

    @Override
    public void error(String msg) {}

    @Override
    public void empty() {}

    @Override
    public void empty(String msg) {}

    @Override
    public void loading() {}

    @Override
    public void main() {}

    @Override
    public void retry() {}

    protected void inject() {}
}