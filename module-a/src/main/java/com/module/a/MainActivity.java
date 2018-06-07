package com.module.a;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.module.a.app.MyApp;
import com.module.base.BaseActivity;
import com.module.base.router.RouterManager;
import com.module.base.router.RouterPath;

@Route(path = RouterPath.A_ACTIVITY)
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tv);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            textView.setText(bundle.getString("appstring"));
        }
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBActivity();
            }
        });

        Application application = MyApp.getInstance().getApplication();
        Log.e("a MyApp: ", application + "");

        textView.setText(R.string.a_app_name);

    }

    public void goBActivity() {
        Log.e("milo package", getPackageName());
        RouterManager.goToActivity(RouterPath.B_ACTIVITY, this);
    }
}
