package com.leozkt.module2;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.leozkt.baselib.base.BaseActivity;
import com.leozkt.commonbusiness.UserHelper;

/**
 * @author zhengkaituo
 * @date 2018/4/19
 */
@Route(path = "/module2/test")
public class Module2TestActivity extends BaseActivity {


    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.module2_activity_module2;
    }

    @Override
    public void initView() {
        $(R.id.btn_login_check).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (UserHelper.isLogin()) {
                    Toast.makeText(Module2TestActivity.this, "当前已登录", Toast.LENGTH_SHORT).show();
                } else {
                    ARouter.getInstance().build("/common/login").navigation();
                }
            }

        });
    }


}
