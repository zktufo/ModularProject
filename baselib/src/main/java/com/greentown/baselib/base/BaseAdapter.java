package com.greentown.baselib.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.greentown.baselib.exception.ResNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengkaituo
 * @date 2018/4/27
 */
public abstract class BaseAdapter<T> extends RecyclerView.Adapter {
    public LayoutInflater mLayoutInflater;
    public List<T> mDatas;
    public Context mContext;
    private int resource;


    public BaseAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mDatas = new ArrayList<T>();
        mContext = context;
    }

    public BaseAdapter(Context context, List<T> list) {
        mLayoutInflater = LayoutInflater.from(context);
        mDatas = new ArrayList<T>();
        mContext = context;
        mDatas = list;
    }

    public BaseAdapter(Context context, List<T> list, int resource) {
        mLayoutInflater = LayoutInflater.from(context);
        mDatas = new ArrayList<T>();
        mContext = context;
        mDatas = list;
        this.resource = resource;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //R.layout.item_view_home_model
        return new RecyclerView.ViewHolder(mLayoutInflater.inflate(resource, parent, false)) {
        };
    }


    public void addAll(List<T> list) {
        mDatas.clear();
        mDatas.addAll(list);
        notifyDataSetChanged();
    }

    public void clear() {
        mDatas.clear();
    }

    public void add(T data) {
        mDatas.add(data);
    }


    @Override
    public int getItemCount() {
        return mDatas.size() > 0 ? mDatas.size() : 0;
    }

    public <T extends View> T getViewById(RecyclerView.ViewHolder holder, int resId) throws ResNotFoundException {

        T view = holder.itemView.findViewById(resId);

        if (view != null) {
            return view;
        }

        throw new ResNotFoundException();

    }
}
