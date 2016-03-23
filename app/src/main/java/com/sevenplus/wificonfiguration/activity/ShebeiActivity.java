package com.sevenplus.wificonfiguration.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sevenplus.wificonfiguration.activity.fragment.Shebei_GuanliyuanFragment;
import com.sevenplus.wificonfiguration.activity.fragment.Shebei_PeizhiFragment;
import com.sevenplus.wificonfiguration.net.been.ShebeiDataPackage;
import com.sevenplus.wificonfiguration.utils.TimeCommonUtils;

public class ShebeiActivity extends FragmentActivity implements View.OnClickListener {
    Activity mActivity;

    LinearLayout bar_back_layout;
    TextView bar_title_tv;
    LinearLayout tab1_layout, tab2_layout;
    FrameLayout fragment;

    public  static  ShebeiDataPackage sbdp;
    android.support.v4.app.FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    int now_tab = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shebei);

        sbdp = (ShebeiDataPackage) getIntent().getSerializableExtra("ShebeiDataPackage");
        fragmentManager = getSupportFragmentManager();

        init();
    }

    private void init() {
        bar_back_layout = (LinearLayout) findViewById(R.id.bar_back_layout);
        bar_back_layout.setOnClickListener(this);

        bar_title_tv = (TextView) findViewById(R.id.bar_title_tv);

        tab1_layout = (LinearLayout) findViewById(R.id.tab1_layout);
        tab2_layout = (LinearLayout) findViewById(R.id.tab2_layout);
        fragment = (FrameLayout) findViewById(R.id.fragment);

        tab1_layout.setOnClickListener(this);
        tab2_layout.setOnClickListener(this);

        bar_title_tv.setText(R.string.bar_title4);

        fragmentTransaction = fragmentManager.beginTransaction();
        Shebei_GuanliyuanFragment gly = new Shebei_GuanliyuanFragment();
        fragmentTransaction.replace(R.id.fragment, gly);
        fragmentTransaction.commit();
        now_tab = 1;
    }


    @Override
    public void onClick(View v) {

        if (TimeCommonUtils.isFastDoubleClick()) {
            return;
        }

        switch (v.getId()) {

            case R.id.bar_back_layout:
                finish();
                break;
            case R.id.tab1_layout:

                if (1 == now_tab) {
                    return;
                } else {
                    now_tab = 1;
                }

                bar_title_tv.setText(R.string.bar_title4);

                tab1_layout.setBackgroundColor(getResources().getColor(R.color.titlebar_color_blue1));
                tab2_layout.setBackgroundColor(getResources().getColor(R.color.titlebar_color_blue2));
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.push_left_in,
                        R.anim.push_left_out);
                Shebei_GuanliyuanFragment gly = new Shebei_GuanliyuanFragment();
                fragmentTransaction.replace(R.id.fragment, gly);
                fragmentTransaction.commit();

                break;
            case R.id.tab2_layout:
                if (2 == now_tab) {
                    return;
                } else {
                    now_tab = 2;
                }

                bar_title_tv.setText(R.string.bar_title5);
                tab1_layout.setBackgroundColor(getResources().getColor(R.color.titlebar_color_blue2));
                tab2_layout.setBackgroundColor(getResources().getColor(R.color.titlebar_color_blue1));

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.push_left_in,
                        R.anim.push_left_out);
                Shebei_PeizhiFragment pz = new Shebei_PeizhiFragment();
                fragmentTransaction.replace(R.id.fragment, pz);
                fragmentTransaction.commit();
                break;


        }

    }
}
