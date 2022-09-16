package com.linliangxu.framework.base;

import android.view.ViewGroup;

import com.linliangxu.framework.R;


/**
 * @author : Linxu
 * @create : 2018/12/11
 * 　　       ^__^
 * 　　       (**)\ _ __ _
 * 　　       (__)\       )\/\
 * 　　        U  ||------|
 * 　　           ||     ||
 * ==============================
 * @desc : RootActivity
 */
public abstract class RootActivity<T extends BasePresenter> extends BaseActivity<T>{

    private static final int STATE_MAIN = 0x00;
    private static final int STATE_LOADING = 0x01;
    private static final int STATE_EMPTY = 0x02;
    private static final int STATE_ERROR = 0x03;

    private ViewGroup viewMain;

    private int mErrorResource = R.layout.view_error;
    private int mEmptyResource = R.layout.view_empty;

    private int currentState = STATE_LOADING;
    private boolean isErrorViewAdded = false;
    private boolean isEmptyViewAdded = false;

    @Override
    protected void onViewCreated() {
        super.onViewCreated();

        viewMain = (ViewGroup) findViewById(R.id.view_main);
        viewRoot().onViewCreated(viewMain);

    }

    @Override
    public void error(String msg) {
        viewRoot().error(msg);
    }

    @Override
    public void error() {
        error(null);
    }

    @Override
    public void empty(String msg) {
        viewRoot().empty(msg);
    }

    @Override
    public void empty() {
        empty(null);
    }

    @Override
    public void loading() {
        viewRoot().loading();
    }

    @Override
    public void main() {
        viewRoot().main();
    }


    public void setErrorResource(int errorLayoutResource) {
        viewRoot().setErrorResource(errorLayoutResource);
        //this.mErrorResource = errorLayoutResource;
    }

    public void setEmptyResource(int emptyResource) {
        viewRoot().setEmptyResource(emptyResource);
        //this.mEmptyResource = emptyResource;
    }

    public void setLoadingResource(int loadingResource) {
        viewRoot().setLoadingResource(loadingResource);
        //this.mEmptyResource = emptyResource;
    }
}