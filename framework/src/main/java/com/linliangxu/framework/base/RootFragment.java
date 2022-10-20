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
 * @desc : RootFragment
 */
public abstract class RootFragment<T extends BasePresenter> extends BaseFragment<T> {

    private ViewGroup viewMain;

    @Override
    protected void onViewCreated() {
        if (getView() == null)
            return;

        super.onViewCreated();

        viewMain = (ViewGroup) getView().findViewById(R.id.view_main);
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
    }

    public void setEmptyResource(int emptyResource) {
        viewRoot().setEmptyResource(emptyResource);
    }

    public void setLoadingResource(int loadingResource) {
        viewRoot().setLoadingResource(loadingResource);
    }
}
