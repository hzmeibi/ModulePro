package com.module.base;

import android.app.Application;

/**
 * Created by milo on 2018/5/15.
 */

public interface ApplicationService {
    /**
     * 获取 Application
     *
     * @return
     */
    Application getApplication();

    /**
     * 主要处理一些第三方library初始化工作 在主APP 创建的时候调用
     *
     * @param application
     */
    void loadModuleApplicationService(Application application);
}
