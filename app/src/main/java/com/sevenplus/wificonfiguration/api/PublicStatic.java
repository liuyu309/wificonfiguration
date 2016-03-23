package com.sevenplus.wificonfiguration.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/12/25.
 */
public class PublicStatic {
    public  static  String data1= "41 35 41 35 44 00 " +
            "00 00 00 00 00 01 10 00 18 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 00 00 00 00 04 03 " +
            "01 0b 43 68 69 6e 61 4e 65 74 2d 73 76 62 5a 00 " +
            "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 73 61 67 6e 64 66 70 62 39 30 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 08 01 01 64 00 a8 c0 1f a5 00 00 09 01 " +
            "c0 a8 00 01 ff ff ff 00 c0 a8 00 01 c0 a8 00 01 " +
            "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
            "00 00";

    public  static  String data2 = "41 35 41 35 44 57" +
            "7d f1 0a 00 01 01 10 00 18 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 00 00 00 00 04 03 " +
            "01 0b 43 68 69 6e 61 4e 65 74 2d 73 76 62 5a 00 " +
            "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 73 61 67 6e 64 66 70 62 39 30 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 08 01 01 64 00 a8 c0 1f a5 00 00 09 01 " +
            "c0 a8 00 01 ff ff ff 00 c0 a8 00 01 c0 a8 00 01 " +
            "00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 " +
            "00 00";

    public  static  String data3 ="41 35 41 35 44 57 7D F1 0A 00 " +
            "01 01 10 00 18 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 04 03 01 0B " +
            "43 68 69 6E 61 4E 65 74 2D 73 " +
            "76 62 5A 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 73 61 67 6E 64 66 70 " +
            "62 39 30 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 08 01 01 64 00 A8 C0 " +
            "1F A5 00 00 09 01 C0 A8 00 01 " +
            "FF FF FF 00 C0 A8 00 01 C0 A8 " +
            "00 01 00 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 " +
            "00 00 00 00 00 00 00 00 00 00 ";

    /**
     * @return 加密方式 list
     */
    public static List<String> get_jiamifangshi_List() {
        List<String> list = new ArrayList<String>();
        list.add("none");
        list.add("wep");
        list.add("tkip");
        list.add("ccmp");
        list.add("auto");
        return list;
    }

    /**
     * @return 安全模式 list
     */
    public static List<String> get_anquanmoshi_List() {
        List<String> list = new ArrayList<String>();
        list.add("open");
        list.add("wep");
        list.add("wpa1");
        list.add("wpa2");
        return list;
    }


    /**
     * @return  Wifi多媒体 list
     */
    public static List<String> get_wifiduomeiti_List() {
        List<String> list = new ArrayList<String>();
        list.add("开");
        list.add("关");
        return list;
    }


    /**
     * @return  工作信道 list
     */
    public static List<String> get_gongzuoxindao_List() {
        List<String> list = new ArrayList<String>();
        list.add("信道1");
        list.add("信道2");
        list.add("信道3");
        list.add("信道4");
        list.add("信道5");
        list.add("信道6");
        list.add("信道7");
        list.add("信道8");
        list.add("信道9");
        list.add("信道10");
        list.add("信道11");
        list.add("信道12");
        list.add("信道13");
        return list;
    }



    /**
     * @return  网络协议 list
     */
    public static List<String> get_wangluoxieyi_List() {
        List<String> list = new ArrayList<String>();
        list.add("TCP");
        list.add("UDP");
        return list;
    }



}
