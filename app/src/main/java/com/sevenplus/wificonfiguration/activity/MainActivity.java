package com.sevenplus.wificonfiguration.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.sevenplus.wificonfiguration.activity.fragment.PzsbFragment;
import com.sevenplus.wificonfiguration.activity.fragment.RdmsFragment;
import com.sevenplus.wificonfiguration.activity.fragment.ZlmsFragment;
import com.sevenplus.wificonfiguration.utils.TimeCommonUtils;

public class MainActivity extends FragmentActivity implements View.OnClickListener {

    Activity mActivity;

    ImageView bar_iv;
    TextView bar_title_tv;
    LinearLayout tab1_layout, tab2_layout, tab3_layout;
    FrameLayout fragment;


    android.support.v4.app.FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    int now_tab = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        init();
    }

    private void init() {
        bar_iv = (ImageView) findViewById(R.id.bar_iv);
        bar_title_tv = (TextView) findViewById(R.id.bar_title_tv);

        tab1_layout = (LinearLayout) findViewById(R.id.tab1_layout);
        tab2_layout = (LinearLayout) findViewById(R.id.tab2_layout);
        tab3_layout = (LinearLayout) findViewById(R.id.tab3_layout);
        fragment = (FrameLayout) findViewById(R.id.fragment);

        tab1_layout.setOnClickListener(this);
        tab2_layout.setOnClickListener(this);
        tab3_layout.setOnClickListener(this);

        bar_iv.setVisibility(View.GONE);
        bar_title_tv.setText(R.string.bar_title1);

        fragmentTransaction = fragmentManager.beginTransaction();
        ZlmsFragment zlms = new ZlmsFragment();
        fragmentTransaction.replace(R.id.fragment, zlms);
        fragmentTransaction.commit();
        now_tab = 1;
    }


    @Override
    public void onClick(View v) {

        if (TimeCommonUtils.isFastDoubleClick()) {
            return;
        }

        switch (v.getId()) {
            case R.id.tab1_layout:

                if (1 == now_tab) {
                    return;
                } else {
                    now_tab = 1;
                }

                bar_iv.setVisibility(View.GONE);
                bar_title_tv.setText(R.string.bar_title1);

                tab1_layout.setBackgroundColor(getResources().getColor(R.color.titlebar_color_blue1));
                tab2_layout.setBackgroundColor(getResources().getColor(R.color.titlebar_color_blue2));
                tab3_layout.setBackgroundColor(getResources().getColor(R.color.titlebar_color_blue2));

                fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.setCustomAnimations(R.anim.push_left_in,
                        R.anim.push_left_out);
                ZlmsFragment zlms = new ZlmsFragment();
                fragmentTransaction.replace(R.id.fragment, zlms);
                fragmentTransaction.commit();

                break;
            case R.id.tab2_layout:

                if (2 == now_tab) {
                    return;
                } else {
                    now_tab = 2;
                }

                bar_iv.setVisibility(View.GONE);
                bar_title_tv.setText(R.string.bar_title2);

                tab1_layout.setBackgroundColor(getResources().getColor(R.color.titlebar_color_blue2));
                tab2_layout.setBackgroundColor(getResources().getColor(R.color.titlebar_color_blue1));
                tab3_layout.setBackgroundColor(getResources().getColor(R.color.titlebar_color_blue2));

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.push_left_in,
                        R.anim.push_left_out);
                RdmsFragment rdms = new RdmsFragment();
                fragmentTransaction.replace(R.id.fragment, rdms);
                fragmentTransaction.commit();
                break;
            case R.id.tab3_layout:

                if (3 == now_tab) {
                    return;
                } else {
                    now_tab = 3;
                }
                bar_iv.setVisibility(View.VISIBLE);
                bar_title_tv.setText(R.string.bar_title3);

                tab1_layout.setBackgroundColor(getResources().getColor(R.color.titlebar_color_blue2));
                tab2_layout.setBackgroundColor(getResources().getColor(R.color.titlebar_color_blue2));
                tab3_layout.setBackgroundColor(getResources().getColor(R.color.titlebar_color_blue1));

                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.push_left_in,
                        R.anim.push_left_out);
                PzsbFragment pzsb = new PzsbFragment();
                fragmentTransaction.replace(R.id.fragment, pzsb);
                fragmentTransaction.commit();
                break;

        }

    }
}
