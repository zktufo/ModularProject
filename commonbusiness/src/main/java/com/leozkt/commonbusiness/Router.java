package com.leozkt.commonbusiness;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.HashMap;

/**
 * @author zhengkaituo
 * @date 2018/4/19
 */
public class Router {
    private static Router mInstance;

    private static HashMap<String, Object> services = new HashMap<>();
    private static HashMap<String, Object> components = new HashMap<>();


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

    /**
     * Register the component
     *
     * @param classname
     */
    public void registerComponent(@Nullable String classname) {
        if (TextUtils.isEmpty(classname)) {
            return;
        }
        if (components.keySet().contains(classname)) {
            return;
        }
        try {
            Class clazz = Class.forName(classname);
            IApplicationLike applicationLike = (IApplicationLike) clazz.newInstance();
            applicationLike.onCreate();
            components.put(classname, applicationLike);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void addService(String serviceName, Object serviceImpl) {
        if (serviceName == null || serviceImpl == null) {
            return;
        }
        services.put(serviceName, serviceImpl);
    }

    public synchronized void removeServcie(String serviceName) {
        if (TextUtils.isEmpty(serviceName)) {
            return;
        }
        services.remove(serviceName);
    }

    public synchronized Object getService(String serviceName) {
        if (services.containsKey(serviceName)) {
            return services.get(serviceName);
        }
        return null;
    }
}
