package com.leozkt.module1;

import com.leozkt.commonbusiness.IApplicationLike;
import com.leozkt.commonbusiness.Router;
import com.leozkt.commonservice.module1.Module1Service;

/**
 * @author zhengkaituo
 * @date 2018/4/27
 */
public class Module1AppLike implements IApplicationLike {

    Router mRouter = Router.getInstance();

    @Override
    public void onCreate() {
        mRouter.addService(Module1Service.class.getSimpleName(), new Module1ServiceImpl());
    }

    @Override
    public void onStop() {

    }
}
