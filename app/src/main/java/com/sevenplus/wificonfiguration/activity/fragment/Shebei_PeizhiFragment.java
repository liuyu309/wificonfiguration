package com.sevenplus.wificonfiguration.activity.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sevenplus.wificonfiguration.activity.R;
import com.sevenplus.wificonfiguration.activity.ShebeiActivity;
import com.sevenplus.wificonfiguration.api.PublicStatic;
import com.sevenplus.wificonfiguration.net.been.ShebeiDataPackage;
import com.sevenplus.wificonfiguration.utils.MLog;
import com.sevenplus.wificonfiguration.utils.TimeCommonUtils;
import com.sevenplus.wificonfiguration.view.CheckSwitchButton;
import com.sevenplus.wificonfiguration.view.popwindow.ListSelectPop;


public class Shebei_PeizhiFragment extends Fragment implements View.OnClickListener {


    View mainView;
    Activity mActivity;

    CheckSwitchButton mCheckSwithcButton;
    LinearLayout gzms_layout0, gzms_layout1;
    ImageView gzms_iv0, gzms_iv1;
    int gzms_state = 0;

    RelativeLayout jmfs_layout, aqms_layout, gzxd_layout, wlxy_layout;
    TextView wlmc_tv, jmfs_tv, aqms_tv, gzxd_tv, ckbtl_tv, wlxy_tv;
    TextView far_ip_tv, far_port_tv;
    TextView loc_ip1_tv, loc_ip2_tv, loc_ip3_tv, loc_ip4_tv;
    TextView zwym_tv1, zwym_tv2, zwym_tv3, zwym_tv4;
    TextView wangguang_tv1, wangguang_tv2, wangguang_tv3, wangguang_tv4;
    TextView nds_tv1, nds_tv2, nds_tv3, nds_tv4;
    ShebeiDataPackage sp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.shebei_peizhi, null);
        mActivity = getActivity();
        sp = ShebeiActivity.sbdp;


        init();

        return mainView;
    }

    private void init() {

        gzms_layout0 = (LinearLayout) mainView.findViewById(R.id.gzms_layout0);
        gzms_layout1 = (LinearLayout) mainView.findViewById(R.id.gzms_layout1);
        gzms_layout0.setOnClickListener(this);
        gzms_layout1.setOnClickListener(this);


        gzms_iv0 = (ImageView) mainView.findViewById(R.id.gzms_iv0);
        gzms_iv1 = (ImageView) mainView.findViewById(R.id.gzms_iv1);


        mCheckSwithcButton = (CheckSwitchButton) mainView.findViewById(R.id.mCheckSwithcButton);

        mCheckSwithcButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                MLog.i("isChecked=" + isChecked);
            }
        });

        jmfs_layout = (RelativeLayout) mainView.findViewById(R.id.jmfs_layout);
        aqms_layout = (RelativeLayout) mainView.findViewById(R.id.aqms_layout);
        gzxd_layout = (RelativeLayout) mainView.findViewById(R.id.gzxd_layout);
        wlxy_layout = (RelativeLayout) mainView.findViewById(R.id.wlxy_layout);

        jmfs_layout.setOnClickListener(this);
        aqms_layout.setOnClickListener(this);
        gzxd_layout.setOnClickListener(this);
        wlxy_layout.setOnClickListener(this);


        wlmc_tv = (TextView) mainView.findViewById(R.id.wlmc_tv);
        jmfs_tv = (TextView) mainView.findViewById(R.id.jmfs_tv);
        aqms_tv = (TextView) mainView.findViewById(R.id.aqms_tv);
        gzxd_tv = (TextView) mainView.findViewById(R.id.gzxd_tv);
        ckbtl_tv = (TextView) mainView.findViewById(R.id.ckbtl_tv);
        wlxy_tv = (TextView) mainView.findViewById(R.id.wlxy_tv);
        far_ip_tv = (TextView) mainView.findViewById(R.id.far_ip_tv);
        far_port_tv = (TextView) mainView.findViewById(R.id.far_port_tv);

        loc_ip1_tv = (TextView) mainView.findViewById(R.id.loc_ip1_tv);
        loc_ip2_tv = (TextView) mainView.findViewById(R.id.loc_ip2_tv);
        loc_ip3_tv = (TextView) mainView.findViewById(R.id.loc_ip3_tv);
        loc_ip4_tv = (TextView) mainView.findViewById(R.id.loc_ip4_tv);

        zwym_tv1 = (TextView) mainView.findViewById(R.id.zwym_tv1);
        zwym_tv2 = (TextView) mainView.findViewById(R.id.zwym_tv2);
        zwym_tv3 = (TextView) mainView.findViewById(R.id.zwym_tv3);
        zwym_tv4 = (TextView) mainView.findViewById(R.id.zwym_tv4);

        wangguang_tv1 = (TextView) mainView.findViewById(R.id.wangguang_tv1);
        wangguang_tv2 = (TextView) mainView.findViewById(R.id.wangguang_tv2);
        wangguang_tv3 = (TextView) mainView.findViewById(R.id.wangguang_tv3);
        wangguang_tv4 = (TextView) mainView.findViewById(R.id.wangguang_tv4);

        nds_tv1 = (TextView) mainView.findViewById(R.id.nds_tv1);
        nds_tv2 = (TextView) mainView.findViewById(R.id.nds_tv2);
        nds_tv3 = (TextView) mainView.findViewById(R.id.nds_tv3);
        nds_tv4 = (TextView) mainView.findViewById(R.id.nds_tv4);


        wlmc_tv.setText(sp.getWifi_name());
        jmfs_tv.setText(sp.getJimifangshi());
        aqms_tv.setText(sp.getAnquanmoshi());
        //密码
        gzxd_tv.setText(sp.getGongzuoxindao());

        wlxy_tv.setText(sp.getTcpOrUdp());

        far_ip_tv.setText(sp.getFar_ip_140() + "." + sp.getFar_ip_141() + "." + sp.getFar_ip_142() + "." + sp.getFar_ip_143());
        far_port_tv.setText(sp.getFar_port());
        ckbtl_tv.setText(sp.getSerial_port());

        loc_ip1_tv.setText(sp.getLoc_ip_150());
        loc_ip2_tv.setText(sp.getLoc_ip_151());
        loc_ip3_tv.setText(sp.getLoc_ip_152());
        loc_ip4_tv.setText(sp.getLoc_ip_153());

        zwym_tv1.setText(sp.getZiwangyanma_154());
        zwym_tv2.setText(sp.getZiwangyanma_155());
        zwym_tv3.setText(sp.getZiwangyanma_156());
        zwym_tv4.setText(sp.getZiwangyanma_157());

        wangguang_tv1.setText(sp.getWangguan_158());
        wangguang_tv2.setText(sp.getWangguan_159());
        wangguang_tv3.setText(sp.getWangguan_160());
        wangguang_tv4.setText(sp.getWangguan_161());

        nds_tv1.setText(sp.getdNS_162());
        nds_tv2.setText(sp.getdNS_163());
        nds_tv3.setText(sp.getdNS_164());
        nds_tv4.setText(sp.getdNS_165());

        if ("00".equals(sp.getGongzuomoshi())){
            gzms_state = 0;
            gzms_iv0.setBackgroundResource(R.mipmap.selected);
            gzms_iv1.setBackgroundResource(R.mipmap.not_selected);
        }else {
            gzms_state = 1;
            gzms_iv0.setBackgroundResource(R.mipmap.not_selected);
            gzms_iv1.setBackgroundResource(R.mipmap.selected);
        }



        if ("02".equals(sp.getWifi_duomeiti())) {
            mCheckSwithcButton.setChecked(true);
        } else {
            mCheckSwithcButton.setChecked(false);
        }


    }


    @Override
    public void onClick(View v) {
        if (TimeCommonUtils.isFastDoubleClick()) {
            return;
        }
        switch (v.getId()) {
            case R.id.gzms_layout0:
                gzms_state = 0;
                gzms_iv0.setBackgroundResource(R.mipmap.selected);
                gzms_iv1.setBackgroundResource(R.mipmap.not_selected);

                break;
            case R.id.gzms_layout1:

                gzms_state = 1;
                gzms_iv0.setBackgroundResource(R.mipmap.not_selected);
                gzms_iv1.setBackgroundResource(R.mipmap.selected);


                break;

            case R.id.jmfs_layout:
                new ListSelectPop(mActivity, jmfs_tv, "加密方式", PublicStatic.get_jiamifangshi_List());
                break;

            case R.id.aqms_layout:
                new ListSelectPop(mActivity, aqms_tv, "安全模式", PublicStatic.get_anquanmoshi_List());
                break;

            case R.id.gzxd_layout:
                new ListSelectPop(mActivity, gzxd_tv, "工作信道", PublicStatic.get_gongzuoxindao_List());
                break;


            case R.id.wlxy_layout:
                new ListSelectPop(mActivity, wlxy_tv, "网络协议", PublicStatic.get_wangluoxieyi_List());
                break;


        }

    }

}
