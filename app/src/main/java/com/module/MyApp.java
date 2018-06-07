package com.module;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.module.base.ApplicationService;

/**
 * Created by milo on 2018/5/14.
 */

public class MyApp extends Application implements ApplicationService {
    private static MyApp mMyApp;

    public static MyApp getInstance() {
        return mMyApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mMyApp = this;
        Log.e("app MyApp: ", mMyApp + "");
        if (BuildConfig.IS_DEBUG_TYPE) {
            // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this); // 尽可能早，推荐在Application中初始化

        //初始化其他module
        loadModuleApplicationService(null);
    }

    @Override
    public Application getApplication() {
        return this;
    }

    @Override
    public void loadModuleApplicationService(Application application) {
        Log.e("app MyApp: ", getApplication() + "loadModuleApplicationService");
        if (!BuildConfig.IS_DEBUG_TYPE) {
            com.module.a.app.MyApp.getInstance().loadModuleApplicationService(getApplication());
            com.module.b.app.MyApp.getInstance().loadModuleApplicationService(getApplication());
        }
    }
}
