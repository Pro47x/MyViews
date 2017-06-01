package com.minicart.demo.myviews;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_viewPagerSwitchAnim).setOnClickListener(this);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ContentActivity.class);
        switch (v.getId()) {
            case R.id.btn_viewPagerSwitchAnim:
                intent.setAction(ActionConstant.VIEW_PAGER_SWITCH_ANIM);
                break;

            default:
                break;
        }
        startActivity(intent);
    }
}
