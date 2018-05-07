package com.leozkt.commonbusiness;

import android.content.Context;
import android.text.TextUtils;

/**
 * @author zhengkaituo
 * @date 2018/4/20
 */
public class UserHelper {
    private static SharedPreferenceHelper helper;
    private static final String USERNAME = "userName";
    private static final String ISLOGIN = "isLogin";
    private static String userName;
    private static boolean isLogin;

    public static void init(Context context) {
        helper = SharedPreferenceHelper.getHelper("user", context);
    }

    public synchronized static void putUserName(String userName) {
        UserHelper.userName = userName;
        helper.put(USERNAME, userName);
    }

    public synchronized static String getUserName() {
        if (!TextUtils.isEmpty(userName)) {
            return userName;
        }
        if (!helper.contains(USERNAME)) {
            return "";
        }
        String userName = helper.getString(USERNAME);
        if (TextUtils.isEmpty(userName)) {
            return "";
        }
        return userName;

    }

    /**
     * 演示登录存储
     *
     * @return
     */
    public synchronized static boolean isLogin() {
        return helper.getBoolean(ISLOGIN);
    }

    public synchronized static void putIsLogin(boolean isLogin) {
        helper.put(ISLOGIN, isLogin);
    }


}
