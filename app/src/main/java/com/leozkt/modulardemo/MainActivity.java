package com.leozkt.modulardemo;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.leozkt.baselib.base.BaseActivity;
import com.leozkt.commonbusiness.Router;
import com.leozkt.commonservice.module2.Module2PageListService;

public class MainActivity extends BaseActivity {


    LinearLayout rootLayout;
    Module2PageListService service = (Module2PageListService) Router.getInstance().getService(Module2PageListService.class.getSimpleName());

    @NonNull
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

        rootLayout = $(R.id.fl_root);


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

        ((TextView) $(R.id.txt_city)).setText(service.getCurrentCity());


        rootLayout.addView(service.getPageList(1, this));
    }

}
