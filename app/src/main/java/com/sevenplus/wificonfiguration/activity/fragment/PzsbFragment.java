package com.sevenplus.wificonfiguration.activity.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sevenplus.wificonfiguration.activity.R;
import com.sevenplus.wificonfiguration.activity.ShebeiActivity;
import com.sevenplus.wificonfiguration.api.PublicStatic;
import com.sevenplus.wificonfiguration.net.UDP10003Server;
import com.sevenplus.wificonfiguration.net.UdpClient;
import com.sevenplus.wificonfiguration.net.been.ShebeiDataPackage;
import com.sevenplus.wificonfiguration.utils.TimeCommonUtils;


public class PzsbFragment extends Fragment implements View.OnClickListener {

    Activity mActivity;
    View mainView;
    LinearLayout layout0;
    TextView mytest_tv, moni_tv;
    RelativeLayout search_layout;

    private UDP10003Server udpServer;
    private UIHandler mUihandler = new UIHandler();
    ShebeiDataPackage sbdp = new ShebeiDataPackage();

    class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String ssidString = msg.getData().getString("data");
                    String s = mytest_tv.getText().toString().trim() + ">>>";
                    mytest_tv.setText(s + ssidString);
                    break;

                default:
                    break;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.pzsb_layout, null);
        mActivity = getActivity();
        layout0 = (LinearLayout) mainView.findViewById(R.id.layout0);
        layout0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, ShebeiActivity.class);
                intent.putExtra("ShebeiDataPackage",sbdp);
                startActivity(intent);
            }
        });

        mytest_tv = (TextView) mainView.findViewById(R.id.mytest_tv);
        moni_tv = (TextView) mainView.findViewById(R.id.moni_tv);
        moni_tv.setText("模拟数据："+PublicStatic.data3);

        search_layout = (RelativeLayout) mActivity.findViewById(R.id.search_layout);
        search_layout.setOnClickListener(this);
        String[] as = PublicStatic.data3.split(" ");
         sbdp = analysisData(as, 0);

        View view = inflater.inflate(R.layout.pzsb_layout_item, null);
        TextView item_tv0 = (TextView) view.findViewById(R.id.item_tv0);
        TextView item_tv1 = (TextView) view.findViewById(R.id.item_tv1);
        TextView item_tv2 = (TextView) view.findViewById(R.id.item_tv2);

        item_tv0.setText(sbdp.getNum());
        item_tv1.setText(sbdp.getDeviceID());
        item_tv2.setText(sbdp.getFar_ip_140()+"."+sbdp.getFar_ip_141()+"."+sbdp.getFar_ip_142()+"."+sbdp.getFar_ip_143());
        layout0.addView(view);
        return mainView;
    }


    @Override
    public void onClick(final View v) {
        if (TimeCommonUtils.isFastDoubleClick()) {
            return;
        }

        switch (v.getId()) {
            case R.id.search_layout:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UdpClient.getInstance().send("41 35 41 35 44 00 00 00 00 00 00 00 00 00 56");
                        if (udpServer == null) {
                            udpServer = new UDP10003Server(10003, mUihandler);
                        }

                    }
                }).start();

                break;

        }

    }

    private ShebeiDataPackage analysisData(String[] as, int num) {
        ShebeiDataPackage sp = new ShebeiDataPackage();
        sp.setNum("" + num);
        sp.setTou(hexStr2Str(as[0] + as[1] + as[2] + as[3]));
        sp.setOrder(as[4]);
        sp.setDeviceID(as[5] + as[6] + as[7] + as[8] + as[9] + as[10]);
        sp.setSoftwareVersion(as[11]);

        sp.setGongzuomoshi(as[35]);
        sp.setJimifangshi(as[36]);
        sp.setAnquanmoshi(as[37]);
        sp.setWifi_duomeiti(as[38]);
        sp.setGongzuoxindao(as[39]);

        String wifi_name = "";
        for (int i = 40; i <= 72; i++) {
            wifi_name = wifi_name + as[i];
        }
        sp.setWifi_name(hexStr2Str(wifi_name));

        String wifi_password = "";
        for (int i = 73; i <= 136; i++) {
            wifi_password = wifi_password + as[i];
        }
        sp.setWifi_password(hexStr2Str(wifi_password));
        sp.setWifi_password_length("" + Integer.parseInt(as[137], 16));
        sp.setTcpOrUdp(as[138]);
        sp.setClientOrServer(as[139]);
        sp.setFar_ip_140("" + Integer.parseInt(as[140], 16));
        sp.setFar_ip_141("" + Integer.parseInt(as[141], 16));
        sp.setFar_ip_142("" + Integer.parseInt(as[142], 16));
        sp.setFar_ip_143("" + Integer.parseInt(as[143], 16));
        sp.setFar_port("" + Integer.parseInt(as[144] + as[145], 16));
        sp.setSerial_port(as[148]);
        sp.setdHCP(as[149]);

        sp.setLoc_ip_150("" + Integer.parseInt(as[150], 16));
        sp.setLoc_ip_151("" + Integer.parseInt(as[151], 16));
        sp.setLoc_ip_152("" + Integer.parseInt(as[152], 16));
        sp.setLoc_ip_153("" + Integer.parseInt(as[153], 16));

        sp.setZiwangyanma_154("" + Integer.parseInt(as[154], 16));
        sp.setZiwangyanma_155("" + Integer.parseInt(as[155], 16));
        sp.setZiwangyanma_156("" + Integer.parseInt(as[156], 16));
        sp.setZiwangyanma_157("" + Integer.parseInt(as[157], 16));

        sp.setWangguan_158("" + Integer.parseInt(as[158], 16));
        sp.setWangguan_159("" + Integer.parseInt(as[159], 16));
        sp.setWangguan_160("" + Integer.parseInt(as[160], 16));
        sp.setWangguan_161("" + Integer.parseInt(as[161], 16));

        sp.setdNS_162("" + Integer.parseInt(as[162], 16));
        sp.setdNS_163("" + Integer.parseInt(as[163], 16));
        sp.setdNS_164("" + Integer.parseInt(as[164], 16));
        sp.setdNS_165("" + Integer.parseInt(as[165], 16));


        return sp;
    }

    /**
     * 十六进制转换字符串
     *
     * @return String 对应的字符串
     */
    public static String hexStr2Str(String hexStr) {
        String str = "0123456789ABCDEF";
        char[] hexs = hexStr.toCharArray();
        byte[] bytes = new byte[hexStr.length() / 2];
        int n;

        for (int i = 0; i < bytes.length; i++) {
            n = str.indexOf(hexs[2 * i]) * 16;
            n += str.indexOf(hexs[2 * i + 1]);
            bytes[i] = (byte) (n & 0xff);
        }
        return new String(bytes);
    }
}
