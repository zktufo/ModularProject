package com.greentown.modulardemo;

import android.support.annotation.NonNull;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.greentown.baselib.base.BaseActivity;

public class MainActivity extends BaseActivity {


    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        $(R.id.btn_module1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/module1/test")
                        .navigation();
            }
        });

        $(R.id.btn_module2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/module2/test")
                        .navigation();
            }
        });
    }

}
