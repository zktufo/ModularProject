package com.leozkt.module2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.leozkt.baselib.base.BaseAdapter;
import com.leozkt.module2.R;

import java.util.List;

/**
 * @author zhengkaituo
 * @date 2018/4/27
 */
public class CityAdapter extends BaseAdapter<String> {


    public CityAdapter(Context context, List<String> list, int resource) {
        super(context, list, resource);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        TextView txtCity = getViewById(holder, R.id.txt_city);
        txtCity.setText(mDatas.get(holder.getAdapterPosition()));
    }
}
