package com.module.b;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.module.base.BaseActivity;
import com.module.base.router.RouterPath;

/**
 * Created by milo on 2018/5/14.
 */
@Route(path = RouterPath.B_ACTIVITY)
public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("Module B");
        setContentView(textView);
    }
}
