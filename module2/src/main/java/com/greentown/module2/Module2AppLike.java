package com.greentown.module2;

import com.greentown.commonbusiness.IApplicationLike;
import com.greentown.commonbusiness.Router;
import com.greentown.commonservice.module2.Module2PageListService;

/**
 * @author zhengkaituo
 * @date 2018/4/27
 */
public class Module2AppLike implements IApplicationLike {
    @Override
    public void onCreate() {
        Router.getInstance().addService(Module2PageListService.class.getSimpleName(), new Module2PageListImpl());
    }

    @Override
    public void onStop() {
        Router.getInstance().removeServcie(Module2PageListService.class.getSimpleName());

    }
}
