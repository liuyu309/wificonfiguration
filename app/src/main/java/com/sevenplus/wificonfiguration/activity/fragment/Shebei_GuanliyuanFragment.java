package com.sevenplus.wificonfiguration.activity.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sevenplus.wificonfiguration.activity.R;
import com.sevenplus.wificonfiguration.activity.ShebeiActivity;
import com.sevenplus.wificonfiguration.net.been.ShebeiDataPackage;
import com.sevenplus.wificonfiguration.utils.TimeCommonUtils;


public class Shebei_GuanliyuanFragment extends Fragment implements View.OnClickListener {

    Activity mActivity;
    View mainView;
    Button read_data_bt;
TextView version_tv,deviceid_tv;
    ShebeiDataPackage sp;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.shebei_guanliyuan, null);
        mActivity = getActivity();
        sp = ShebeiActivity.sbdp;

        init();
        return mainView;
    }


    private void init() {
        read_data_bt = (Button) mainView.findViewById(R.id.read_data_bt);
        read_data_bt.setOnClickListener(this);
        version_tv = (TextView) mainView.findViewById(R.id.version_tv);
        deviceid_tv = (TextView) mainView.findViewById(R.id.deviceid_tv);
        version_tv.setText(sp.getSoftwareVersion());
        deviceid_tv.setText(sp.getDeviceID());
    }

    @Override
    public void onClick(View v) {
        if (TimeCommonUtils.isFastDoubleClick()) {
            return;
        }
        switch (v.getId()) {
            case R.id.read_data_bt:


                break;


        }

    }
}
