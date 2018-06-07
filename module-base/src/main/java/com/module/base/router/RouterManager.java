package com.module.base.router;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.BuildConfig;

/**
 * Created by milo on 2018/5/17.
 * 统一控制跳转路由
 */

public class RouterManager {

    public static void goToActivity(String path, Context context) {
        if (BuildConfig.IS_DEBUG_TYPE) {
            //debug状态下 各个library独立测试，无法跳转
            Log.e("RouterManager", "debug状态下，module之间不能通信");
            return;
        }
        ARouter.getInstance()
                .build(path)
                .navigation(context);
    }

    public static void goToActivity(String path, Context context, Bundle bundle) {
        if (BuildConfig.IS_DEBUG_TYPE) {
            return;
        }
        ARouter.getInstance()
                .build(path)
                .with(bundle)
                .navigation(context);
    }

    public static void goToActivity(String path, Context context, RouterCallback callback) {
        if (BuildConfig.IS_DEBUG_TYPE) {
            return;
        }
        ARouter.getInstance()
                .build(path)
                .navigation(context, callback);
    }

    public static void goToActivity(String path, Context context, Bundle bundle, RouterCallback callback) {
        if (BuildConfig.IS_DEBUG_TYPE) {
            return;
        }
        ARouter.getInstance()
                .build(path)
                .with(bundle)
                .navigation(context, callback);
    }
}
