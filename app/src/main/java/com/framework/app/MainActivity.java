package com.framework.app;

import android.widget.TextView;

import com.framework.app.contract.MainContract;
import com.framework.app.presenter.MainPresenter;
import com.linliangxu.framework.base.RootActivity;
import com.linliangxu.framework.util.LogUtil;

import butterknife.BindView;

public class MainActivity extends RootActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.content)
    TextView content;

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
        //empty("空数据了");
        LogUtil.e(content);
        main();
        request();
    }

    @Override
    public void show() {
    }
}