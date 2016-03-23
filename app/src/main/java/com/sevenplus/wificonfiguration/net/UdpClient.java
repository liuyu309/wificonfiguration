package com.sevenplus.wificonfiguration.net;

import com.sevenplus.wificonfiguration.utils.MLog;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;


public class UdpClient {

    private static UdpClient instance;

    public static Map<String, UdpConnector> allUdpConnector = new HashMap<String, UdpConnector>();

    private static int broadcast_port = 60001;

    public static String localIp = "";


    public static UdpClient getInstance() {
        if (instance == null) {
            try {
                if (instance == null) {
                    instance = new UdpClient();
                }
            } finally {
                ;
            }
        }

        return instance;
    }


    /**
     * 发送信令,在连续发送时用
     *
     * @param buffer 信令buffer
     */
    public void sendBroadCastSignaling(final String ipAddr, final byte[] buffer) {

        UdpConnector udpConnector = allUdpConnector.get(ipAddr);
        if (udpConnector == null) {
            udpConnector = new UdpConnector(ipAddr, broadcast_port);
            udpConnector.connect();
            udpConnector.sendBroadCasetBuffer(buffer);
            allUdpConnector.put(ipAddr, udpConnector);
        } else if (udpConnector.getUdpSocket().isConnected()) {
            udpConnector.sendBroadCasetBuffer(buffer);
        } else {
            udpConnector.connect();
            udpConnector.sendBroadCasetBuffer(buffer);
        }

    }

    /**
     * @param message
     */
    public void send(String message) {

        int server_port = 10002;
        DatagramSocket s = null;

        try {
            s = new DatagramSocket();

        } catch (Exception e) {
            e.printStackTrace();
        }

        InetAddress local = null;

        try {
            local = InetAddress.getByName("255.255.255.255");
        } catch (Exception e) {
            e.printStackTrace();
        }

//        int msg_length = message.length();
//        byte[] messageByte = message.getBytes();
//        DatagramPacket p = new DatagramPacket(messageByte, msg_length, local, server_port);


        String[] as = message.split(" ");
        byte[] b = new byte[as.length];



        for (int i = 0; i < as.length; i++) {
            b[i] = new Byte(Integer.valueOf(as[i],16).toString());
            MLog.i(">>>>"+b[i]);
        }
        MLog.i("发送byte[]转string》》》"+  new String(b));

        DatagramPacket p = new DatagramPacket(b, b.length, local, server_port);
        try {
            for (int i = 0; i < 3; i++) {
                s.send(p);
                MLog.i("发送10002》》》》》》》"+i);
                Thread.sleep(1000);
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
