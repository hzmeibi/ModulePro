package com.module.b.app;

import android.app.Application;
import android.util.Log;

import com.module.b.BuildConfig;
import com.module.base.ApplicationService;

/**
 * Created by milo on 2018/5/15.
 */

public class MyApp implements ApplicationService {
    private Application mApplication;

    public static MyApp getInstance() {
        return MyAppHolder.INSTANCE;
    }

    private static class MyAppHolder {
        private static MyApp INSTANCE = new MyApp();
    }

    @Override
    public Application getApplication() {
        if (BuildConfig.IS_DEBUG_TYPE && mApplication == null) {
            mApplication = DebugMyApp.getInstance().getApplication();
        }
        return mApplication;
    }

    @Override
    public void loadModuleApplicationService(Application application) {
        if (BuildConfig.IS_DEBUG_TYPE) {
            DebugMyApp.getInstance().loadModuleApplicationService(getApplication());
        }else {
            mApplication = application;
        }
        Log.e("b MyApp: ", getApplication() + "loadModuleApplicationService");

    }
}
