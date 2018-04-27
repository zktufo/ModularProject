package com.greentown.usercom;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.greentown.baselib.base.BaseActivity;
import com.greentown.commonbusiness.UserHelper;

/**
 * @author zhengkaituo
 * @date 2018/4/20
 */
@Route(path = "/user/register")
public class RegisterActivity extends BaseActivity {

    EditText txtUserName;

    @NonNull
    @Override
    public int getLayoutId() {
        return com.greentown.commonbusiness.R.layout.activity_register;
    }

    @Override
    public void initView() {

        txtUserName = $(com.greentown.commonbusiness.R.id.txt_username);
        $(com.greentown.commonbusiness.R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(txtUserName.getText().toString())) {
                    UserHelper.putUserName(txtUserName.getText().toString());
                    Toast.makeText(getApplicationContext(), "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }
}
