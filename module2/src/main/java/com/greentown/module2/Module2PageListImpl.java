package com.greentown.module2;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.greentown.commonservice.module2.Module2PageListService;
import com.greentown.module2.adapter.CityAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengkaituo
 * @date 2018/4/27
 */
public class Module2PageListImpl implements Module2PageListService {


    @Override
    public View getPageList(int pageId, Context context) {
        RecyclerView recyclerView;
        List<String> mDatas = new ArrayList<>();
        mDatas.add("杭州");
        mDatas.add("温州");
        recyclerView = new RecyclerView(context);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        CityAdapter mAdapter = new CityAdapter(context, mDatas, R.layout.module2_item_city);
        recyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        return recyclerView;
    }

    @Override
    public String getCurrentCity() {
        return "杭州";
    }

}
