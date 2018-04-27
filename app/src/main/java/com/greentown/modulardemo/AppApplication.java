package com.greentown.modulardemo;

import com.alibaba.android.arouter.launcher.ARouter;
import com.greentown.baselib.base.BaseApplication;
import com.greentown.commonbusiness.Router;
import com.greentown.commonbusiness.UserHelper;

/**
 * @author zhengkaituo
 * @date 2018/4/19
 */
public class AppApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        UserHelper.init(this);
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
        Router.getInstance().registerComponent("com.greentown.module2.Module2AppLike");

    }
}
