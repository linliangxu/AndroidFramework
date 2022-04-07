package com.linliangxu.framework.base;

import android.view.ViewGroup;

import com.linliangxu.framework.R;


/**
 * @author: Est <codeest.dev@gmail.com>
 * @date: 2017/4/21
 * @desciption:
 */

public abstract class RootFragment<T extends BasePresenter> extends BaseFragment<T> {

    private ViewGroup viewMain;

    @Override
    protected void onViewCreated() {
        if (getView() == null)
            return;
        viewMain = (ViewGroup) getView().findViewById(R.id.view_main);
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
    }

    public void setEmptyResource(int emptyResource) {
        getCommonView().setEmptyResource(emptyResource);
    }
}
