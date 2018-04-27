package com.greentown.commonbusiness;

import java.util.HashMap;

/**
 * @author zhengkaituo
 * @date 2018/4/19
 */
public class Router {
    private static Router mInstance;

    private static HashMap<String, Object> services = new HashMap<>();

    public static Router getInstance() {
        if (mInstance == null) {
            synchronized (Router.class) {
                if (mInstance == null) {
                    mInstance = new Router();
                }
            }
        }
        return mInstance;
    }

    public synchronized void addService(String serviceName, Object serviceImpl) {
        if (serviceName == null || serviceImpl == null) {
            return;
        }
        services.put(serviceName, serviceImpl);
    }
}
