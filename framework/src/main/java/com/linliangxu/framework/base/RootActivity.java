package com.linliangxu.framework.base;

import android.view.ViewGroup;

import com.linliangxu.framework.R;


/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @desciption:
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
        getCommonView().onViewCreated(viewMain);

    }

    @Override
    public void error(String msg) {
        getCommonView().error(msg);
    }

    @Override
    public void error() {
        error(null);
    }

    @Override
    public void empty(String msg) {
        getCommonView().empty(msg);
    }

    @Override
    public void empty() {
        empty(null);
    }

    @Override
    public void loading() {
        getCommonView().loading();
    }

    @Override
    public void main() {
        getCommonView().main();
    }


    public void setErrorResource(int errorLayoutResource) {
        getCommonView().setErrorResource(errorLayoutResource);
//        this.mErrorResource = errorLayoutResource;
    }

    public void setEmptyResource(int emptyResource) {
        getCommonView().setEmptyResource(emptyResource);
//        this.mEmptyResource = emptyResource;
    }
}