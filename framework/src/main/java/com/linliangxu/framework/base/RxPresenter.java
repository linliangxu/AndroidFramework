package com.linliangxu.framework.base;


import android.content.Context;

import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author : Linxu
 * @create : 2018/12/11
 * 　　       ^__^
 * 　　       (**)\ _ __ _
 * 　　       (__)\       )\/\
 * 　　        U  ||------|
 * 　　           ||     ||
 * ==============================
 * @desc : 基于Rx的Presenter封装,控制订阅的生命周期
 */
public class RxPresenter<T extends BaseView> implements BasePresenter<T> {
    private SoftReference<T> mReferenceView;

    protected T mView;
    protected CompositeDisposable mCompositeDisposable;

    public Context getContext() {
        return mView.getActivity() != null ? mView.getActivity() : Frame.getContext();
    }

    public final String getString(int resId) {
        return getContext().getString(resId);
    }

    public final String getString(int resId, Object... formatArgs) {
        return getContext().getString(resId, formatArgs);
    }

    protected void unSubscribe() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.clear();
        }
    }

    protected void addSubscribe(Disposable subscription) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }


    @SuppressWarnings("unchecked")
    @Override
    public void attachView(T view) {
        mReferenceView = new SoftReference<>(view);
        this.mView = (T) Proxy.newProxyInstance(view.getClass().getClassLoader(), view.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                if (mReferenceView == null || mReferenceView.get() == null) {
                    return null;
                }
                return method.invoke(mReferenceView.get(), objects);
            }
        });

        onCreate();
    }

    @Override
    public void detachView() {
        mReferenceView.clear();
        mReferenceView = null;
        unSubscribe();

        onDestroy();
    }

    protected T viewGet() {
        return mReferenceView != null ? mReferenceView.get() : null;
    }

    protected void onCreate() {}
    protected void onDestroy() {}

}
