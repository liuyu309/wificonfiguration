package com.sevenplus.wificonfiguration.activity.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.sevenplus.wificonfiguration.activity.R;
import com.sevenplus.wificonfiguration.net.ConfigWireless;
import com.sevenplus.wificonfiguration.net.UDPServer;
import com.sevenplus.wificonfiguration.net.WifiAdmin;
import com.sevenplus.wificonfiguration.utils.MLog;

import java.io.UnsupportedEncodingException;


public class ZlmsFragment extends Fragment {

    Activity mActivity;
    View mainView;

    private EditText ssid;
    private EditText password;
    private Button ok;
    private Button cancel;
    private String ssidString = null;
    private PowerManager.WakeLock mFullWakeLock;
    private UDPServer udpServer;
    private UIHandler mUihandler = new UIHandler();
    public static final int MES_UDP_LOGIN = 0;

    public Dialog dialog;

    class UIHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            // TODO Auto-generated method stub
            super.handleMessage(msg);
            switch (msg.what) {
                case MES_UDP_LOGIN:
                    //			Log.i(TAG,"MSG: MES_UDP_LOGIN");
                    ConfigWireless.getInstance().cancel();
                    ConfigWireless.sendFlag = false;
                    if (udpServer != null) {
                        udpServer.CloseServer();
                        udpServer = null;
                    }
                    ShowLoginDialog();
                    break;

                default:
                    break;
            }
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.zlmspz_layout, null);
        mActivity = getActivity();
        initUI();
        PowerManager pm = (PowerManager) mActivity.getSystemService(Context.POWER_SERVICE);
        mFullWakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK
                | PowerManager.ON_AFTER_RELEASE, MLog.PUBLIC_TAG);
        WifiAdmin wifiAdmin = new WifiAdmin(mActivity);
        if (wifiAdmin.isWifiOpen()) {
            ssidString = wifiAdmin.getSSID();// "NL6621"
            if (ssidString.contains("\"")) {
                ssidString = ssidString.substring(1, ssidString.length() - 1);
            }
            ssid.setText(ssidString);

        }
        if (!isWiFiActive()) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(mActivity);
            dialog.setIcon(R.mipmap.ic_launcher)
                    .setTitle(R.string.warning)
                    .setMessage(
                            getResources().getString(R.string.wifi_not_open))
                    .setCancelable(false)
                    .setPositiveButton(R.string.alert_dialog_ok,
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    mActivity.finish();
                                    System.exit(0);
                                }
                            }).create().show();
        }

        return mainView;
    }


    private boolean isWiFiActive() {
        WifiManager mWifiManager = (WifiManager) mActivity
                .getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = mWifiManager.getConnectionInfo();
        int ipAddress = wifiInfo == null ? 0 : wifiInfo.getIpAddress();
        if (mWifiManager.isWifiEnabled() && ipAddress != 0) {
            return true;
        } else {
            return false;
        }
    }

    private void initUI() {
        // TODO Auto-generated method stub
        this.ssid = (EditText) mainView.findViewById(R.id.ssid);
        this.password = (EditText) mainView.findViewById(R.id.password);
        this.ok = (Button) mainView.findViewById(R.id.ok);
        this.cancel = (Button) mainView.findViewById(R.id.cancel);
        this.ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String apSsid = ssid.getText().toString().trim();
                String key = password.getText().toString().trim();
                ConfigWireless.key = key;

                try {
                    ConfigWireless.ssid = apSsid.getBytes("UTF-8");
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                ConfigWireless.getInstance().cancel();
                if (!ConfigWireless.sendFlag)
                    Toast("重新广播发送SSID和KEY！");
                else
                    Toast("开始广播发送SSID和KEY！");
                ConfigWireless.sendFlag = true;
                ConfigWireless.getInstance().run();
                if (udpServer == null) {
                    udpServer = new UDPServer(60002, mUihandler);
                }
            }
        });

        this.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfigWireless.getInstance().cancel();
                ConfigWireless.sendFlag = false;
                if (udpServer != null) {
                    Toast("停止发送！");
                    udpServer.CloseServer();
                    udpServer = null;
                }


            }
        });

    }


    private void Toast(String text) {
        android.widget.Toast.makeText(mActivity.getApplicationContext(), text,
                android.widget.Toast.LENGTH_SHORT).show();
    }

    public void ShowLoginDialog() {
        dialog = onCreateDialog(2);
        dialog.show();
    }

    private void releaseAll() {
        if (mFullWakeLock.isHeld()) {
            mFullWakeLock.release();
        }

        ConfigWireless.getInstance().cancel();
        ConfigWireless.sendFlag = false;
        if (udpServer != null) {
            Toast("停止发送！");
            udpServer.CloseServer();
            udpServer = null;
        }

    }


    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        //	Log.i(TAG,"onResume");
        if (!mFullWakeLock.isHeld()) {
            mFullWakeLock.acquire();
        }
    }


    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        //	Log.i(TAG,"onDestroy");
        if (mFullWakeLock.isHeld()) {
            mFullWakeLock.release();
        }
    }


    @Override
    public void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        //	Log.i(TAG,"onPause");
        releaseAll();
    }


    public Dialog onCreateDialog(int id) {
        AlertDialog.Builder builder;
        if (id == 0) {
            builder = new AlertDialog.Builder(mActivity);

            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle(R.string.app_name);
            builder.setMessage(String.format(
                    getResources().getString(R.string.alert_dialog_text),
                    getResources().getString(R.string.app_name)));

            builder.setCancelable(true);
            builder.setPositiveButton(R.string.alert_dialog_ok,
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ConfigWireless.getInstance().cancel();
                            ConfigWireless.sendFlag = false;
                            if (udpServer != null) {
                                udpServer.CloseServer();
                            }
                            mActivity.finish();
                            System.exit(0);
                        }
                    });
            builder.setNegativeButton(R.string.alert_dialog_cancel, null);
            return builder.create();
        } else if (id == 1) {

        } else if (id == 2) {
            builder = new AlertDialog.Builder(mActivity);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setTitle(R.string.app_name);
            builder.setMessage(String.format(
                    getResources().getString(R.string.device_isconnected),
                    getResources().getString(R.string.app_name)));

            builder.setCancelable(true);
            builder.setPositiveButton(R.string.alert_dialog_ok,
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            return builder.create();
        }
        return null;
    }

}
