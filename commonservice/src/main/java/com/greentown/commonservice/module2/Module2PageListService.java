package com.greentown.commonservice.module2;

import android.content.Context;
import android.view.View;

/**
 * @author zhengkaituo
 * @date 2018/4/27
 */
public interface Module2PageListService {
    View getPageList(int pageId, Context context);

    String getCurrentCity();
}
