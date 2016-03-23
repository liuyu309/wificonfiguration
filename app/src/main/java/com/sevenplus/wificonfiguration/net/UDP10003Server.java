package com.sevenplus.wificonfiguration.net;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.sevenplus.wificonfiguration.net.been.NetDataPackage;
import com.sevenplus.wificonfiguration.utils.MLog;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDP10003Server {
    public static final String TAG = "UDPServer";
    public static final int LENGTH = 200;
    private int mPort;
    private DatagramSocket serversocket = null;//UDP接收
    private DatagramPacket packet = null;
    private ServerThread mServer;
    private boolean mSure = true;
    //private  ConditionVariable cv =  new  ConditionVariable();
    private NetDataPackage datapackage = new NetDataPackage();

    private boolean flag = false;
    private int index = 0;
    private Handler mhandler;
    private static final int MES_UDP_LOGIN = 0;

    public UDP10003Server(int port, Handler handler) {
        mhandler = handler;
        mPort = port;
        mServer = new ServerThread();
        mServer.start();

    }

    //将指定byte数组以16进制的形式打印到控制台
    public void printHexString(byte[] b) {

//        for (int i = 0; i < b.length; i++) {
//            String hex = Integer.toHexString(b[i] & 0xFF);
//            if (hex.length() == 1) {
//                hex = '0' + hex;
//            }
//        }
        String ss = new String(b);
        Message msg = mhandler.obtainMessage();
        msg.what = 0;
        Bundle bundle = new Bundle();
        bundle.putString("data", ss);
        msg.setData(bundle);
        mhandler.sendMessage(msg);


    }


    public void Receive() throws IOException {


        byte data[] = new byte[LENGTH];
        packet = new DatagramPacket(data, data.length);
        if (serversocket == null) {
            try {
                if (serversocket == null) {
                    serversocket = new DatagramSocket(null);
                    serversocket.setReuseAddress(true);
                    serversocket.bind(new InetSocketAddress(mPort));
                }
//				serversocket = new DatagramSocket(mPort);
            } catch (SocketException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        Log.i(TAG, "start receive !");
        serversocket.receive(packet);
        if (packet != null) {
            Log.i(TAG, "接受receive  data!");
            printHexString(data);
        }

    }

    public void CloseServer() {
        MLog.i("CloseServer 10003");
        if (serversocket != null) {
            serversocket.close();
            serversocket = null;
        }
        if (mServer != null) {
            mServer.interrupted();
            mServer = null;
        }
        mSure = false;

    }

    public class ServerThread extends Thread {
        public void run() {
            while (mSure) {
                if (mSure == false) {
                    break;
                }
                Log.i(TAG, "mSure = " + mSure);
                try {

                    Receive();
                    MLog.i("接受10003》》》》》》》");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
