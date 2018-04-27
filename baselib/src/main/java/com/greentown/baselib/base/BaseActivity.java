package com.greentown.baselib.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * @author zhengkaituo
 * @date 2018/4/19
 */
public abstract class BaseActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initView();
    }


    @NonNull
    public abstract int getLayoutId();

    public abstract void initView();



    public <T extends View> T $(int resId) {
        return (T) findViewById(resId);
    }
}
