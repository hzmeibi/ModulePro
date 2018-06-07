package com.module.a.app;

import android.app.Application;
import android.util.Log;

import com.module.a.BuildConfig;
import com.module.base.ApplicationService;

/**
 * Created by milo on 2018/5/15.
 * application
 */
public class MyApp implements ApplicationService {
    private Application mApplication;

    public static MyApp getInstance() {
        return MyAppHolder.INSTANCE;
    }

    private static class MyAppHolder {
        private static MyApp INSTANCE = new MyApp();
    }

    /**
     * 获取application 根据不同状态
     *
     * @return
     */
    @Override
    public Application getApplication() {
        if (BuildConfig.IS_DEBUG_TYPE && mApplication == null) {
            //debug状态下获取debug的application
            mApplication = DebugMyApp.getInstance().getApplication();
        }
        return mApplication;
    }

    /**
     * 用作初始化一些第三方框架内容
     *
     * @param application
     */
    @Override
    public void loadModuleApplicationService(Application application) {
        if (BuildConfig.IS_DEBUG_TYPE) {
            DebugMyApp.getInstance().loadModuleApplicationService(getApplication());
        } else {
            mApplication = application;
        }
        //初始化第三方library
        Log.e("b MyApp: ", getApplication() + "loadModuleApplicationService");
    }
}
