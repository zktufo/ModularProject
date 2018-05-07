package com.leozkt.baselib.base;

import android.app.Application;
import android.support.annotation.Nullable;

/**
 * @author zhengkaituo
 * @date 2018/4/19
 */
public class BaseApplication extends Application {
    private static BaseApplication mAppCotext;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppCotext = this;
    }

    @Nullable
    public static Application getAppContext() {
        return mAppCotext;
    }
}
