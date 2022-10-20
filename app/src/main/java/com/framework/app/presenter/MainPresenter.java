package com.framework.app.presenter;


import android.app.Activity;

import com.framework.app.contract.MainContract;
import com.linliangxu.framework.base.RxPresenter;
import com.linliangxu.framework.util.LogUtil;


/**
 * @author : Linxu
 * @create : 2021/9/22
 *            ^__^
 *            (**)\ _ __ _
 *            (__)\       )\/\
 *             U  ||------|
 *                ||     ||
 * ==============================
 * @desc   : TODO
 */
public class MainPresenter extends RxPresenter<MainContract.View> implements MainContract.Presenter{

    @Override
    protected void onCreate() {
        super.onCreate();


        LogUtil.e(viewGet() instanceof Activity);

        mView.show();
    }
}
