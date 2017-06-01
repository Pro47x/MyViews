package com.minicart.demo.myviews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.minicart.demo.myviews.view_pager_switch_anim.ViewPagerSwitchFragment;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_content);
        switch (getIntent().getAction()) {
            case ActionConstant.VIEW_PAGER_SWITCH_ANIM:
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_content, new ViewPagerSwitchFragment()).commit();
                break;

            default:
                break;
        }
    }
}
