package com.greentown.module1;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.greentown.baselib.base.BaseActivity;
import com.greentown.commonbusiness.UserHelper;

/**
 * @author zhengkaituo
 * @date 2018/4/19
 */
@Route(path = "/module1/test")
public class TestActivity extends BaseActivity {

    Button btnLogin;

    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.module1_activity_module1;
    }

    @Override
    public void initView() {

        $(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/common/login").navigation();
            }
        });

        $(R.id.btn_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserHelper.putIsLogin(false);
            }
        });

        $(R.id.btn_jump2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/module2/test").navigation();
            }
        });

        $(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/common/register").navigation();
            }
        });
    }


}
