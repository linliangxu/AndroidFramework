package com.linliangxu.framework.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.llx.adapter.recyclerview.MultiItemTypeAdapter;
import com.llx.adapter.recyclerview.base.ItemViewDelegate;
import com.llx.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by zhy on 16/4/9.
 */
public abstract class BaseAdapter<T> extends MultiItemTypeAdapter<T>
{
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    protected OnClickItemListener mOnClickItemListener;

    public BaseAdapter(final Context context, final int layoutId, List<T> datas)
    {
        super(context, datas);
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mLayoutId = layoutId;
        mDatas = datas;

        addItemViewDelegate(new ItemViewDelegate<T>()
        {
            @Override
            public int getItemViewLayoutId()
            {
                return layoutId;
            }

            @Override
            public boolean isForViewType( T item, int position)
            {
                return true;
            }

            @Override
            public void convert(final ViewHolder holder, T t, final int position)
            {
                BaseAdapter.this.convert(holder, t, position);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mOnClickItemListener != null)
                            mOnClickItemListener.onItemClick(holder, position);
                    }
                });
            }
        });
    }

    protected abstract void convert(ViewHolder holder, T t, int position);


    public interface OnClickItemListener {
        void onItemClick(RecyclerView.ViewHolder holder, int position);
    }

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.mOnClickItemListener = onClickItemListener;
    }


}
