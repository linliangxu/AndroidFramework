package com.linliangxu.framework.base;

import android.content.Context;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import razerdp.basepopup.BasePopupWindow;


/**
 * @author : Linxu
 * @create : 2022/4/1
 * 　　       ^__^
 * 　　       (**)\ _ __ _
 * 　　       (__)\       )\/\
 * 　　        U  ||------|
 * 　　           ||     ||
 * ==============================
 * @desc : BasePopup
 */
public abstract class BasePopup extends BasePopupWindow {

    private Unbinder mUnBinder;

    protected Context mContext;

    public BasePopup(Context context) {
        super(context);
        View view = createPopupById(getLayout());
        setContentView(view);

        mUnBinder = ButterKnife.bind(this, view);
    }

    protected abstract int getLayout();


    @Override
    public void onDestroy() {
        mUnBinder.unbind();
    }
}

