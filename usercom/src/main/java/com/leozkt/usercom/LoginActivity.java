package com.leozkt.usercom;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.leozkt.baselib.base.BaseActivity;
import com.leozkt.commonbusiness.UserHelper;

/**
 * @author zhengkaituo
 * @date 2018/4/20
 */
@Route(path = "/user/login")
public class LoginActivity extends BaseActivity {

    EditText txtUserName;

    @NonNull
    @Override
    public int getLayoutId() {
        return com.leozkt.commonbusiness.R.layout.activity_login;
    }

    @Override
    public void initView() {

        txtUserName = $(com.leozkt.commonbusiness.R.id.txt_username);
        $(com.leozkt.commonbusiness.R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(txtUserName.getText().toString())) {
                    if (TextUtils.isEmpty(UserHelper.getUserName())) {
                        Toast.makeText(LoginActivity.this, "请先注册", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (txtUserName.getText().toString().equals(UserHelper.getUserName())) {
                        UserHelper.putIsLogin(true);
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "请先注册", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}
