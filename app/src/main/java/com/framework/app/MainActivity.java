package com.framework.app;

import android.os.Bundle;

import com.framework.app.contract.MainContract;
import com.framework.app.presenter.MainPresenter;
import com.linliangxu.framework.R;
import com.linliangxu.framework.base.RootActivity;

public class MainActivity extends RootActivity<MainPresenter> implements MainContract.View {

    @Override
    protected void inject() {
        setLoadingResource(R.layout.view_progress_dark);
        setEmptyResource(R.layout.view_empty_custom);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initial() {
        empty("空数据了");

        request();
    }
}