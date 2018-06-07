package com.module.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.module.base.BaseActivity;
import com.module.base.router.RouterManager;
import com.module.base.router.RouterPath;

/**
 * Created by milo on 2018/5/16.
 */

public class StartActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        MyApp.getMyApp().startAModule(this);
//        MyApp.getMyApp().startBModule(this);

        RouterManager.goToActivity(RouterPath.A_ACTIVITY,this);

//        Bundle bundle = new Bundle();
//        bundle.putString("bundle", "app string");
//        RouterManager.goToActivity(RouterPath.A_ACTIVITY, this, bundle, new RouterCallback() {
//            @Override
//            public void onFound(Postcard postcard) {
//                super.onFound(postcard);
//                Log.e("milo", "onFound: 找到了 ");
//            }
//
//            @Override
//            public void onLost(Postcard postcard) {
//                super.onLost(postcard);
//                Log.e("milo", "onLost: 找不到了 ");
//            }
//
//
//            @Override
//            public void onArrival(Postcard postcard) {
//                Log.e("milo", "onArrival: 跳转完了 ");
//            }
//
//            @Override
//            public void onInterrupt(Postcard postcard) {
//                super.onInterrupt(postcard);
//                Log.e("milo", "onArrival: 被拦截了 ");
//            }
//        });
    }
}
