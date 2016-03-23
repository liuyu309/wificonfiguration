package com.sevenplus.wificonfiguration.net.been;

import java.io.Serializable;

public class ShebeiDataPackage implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public String num;
    public String tou;
    public String order;
    public String deviceID;
    public String softwareVersion;
    public String sendOrRecive;
    public String other;
    public String gongzuomoshi;
    public String jimifangshi;
    public String anquanmoshi;
    public String wifi_duomeiti;
    public String gongzuoxindao;
    public String wifi_name;
    public String wifi_password;
    public String wifi_password_length;
    public String tcpOrUdp;
    public String clientOrServer;
    public String far_ip_140;
    public String far_ip_141;
    public String far_ip_142;
    public String far_ip_143;
    public String far_port;
    public String loc_port;
    public String serial_port;
    public String dHCP;
    public String loc_ip_150;
    public String loc_ip_151;
    public String loc_ip_152;
    public String loc_ip_153;
    public String ziwangyanma_154;
    public String ziwangyanma_155;
    public String ziwangyanma_156;
    public String ziwangyanma_157;
    public String wangguan_158;
    public String wangguan_159;
    public String wangguan_160;
    public String wangguan_161;
    public String dNS_162;
    public String dNS_163;
    public String dNS_164;
    public String dNS_165;


    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTou() {
        return tou;
    }

    public void setTou(String tou) {
        this.tou = tou;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getSoftwareVersion() {

        if ("01".equals(softwareVersion)) {
            softwareVersion = "Main version";
        } else if ("10".equals(softwareVersion)) {
            softwareVersion = "Sub version";
        } else {
            softwareVersion = "Internal version ";
        }
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getSendOrRecive() {
        return sendOrRecive;
    }

    public void setSendOrRecive(String sendOrRecive) {
        this.sendOrRecive = sendOrRecive;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getGongzuomoshi() {


        return gongzuomoshi;
    }

    public void setGongzuomoshi(String gongzuomoshi) {
        this.gongzuomoshi = gongzuomoshi;
    }

    public String getJimifangshi() {
        switch (jimifangshi) {
            case "01":
                jimifangshi = "none";
                break;

            case "02":
                jimifangshi = "wep";
                break;
            case "03":
                jimifangshi = "tkip";
                break;
            case "04":
                jimifangshi = "ccmp";
                break;
            case "05":
                jimifangshi = "auto";
                break;
            default:
                jimifangshi = "none";
                break;
        }

        return jimifangshi;
    }

    public void setJimifangshi(String jimifangshi) {
        this.jimifangshi = jimifangshi;
    }

    public String getAnquanmoshi() {
        switch (anquanmoshi) {
            case "01":
                anquanmoshi = "open";
                break;

            case "02":
                anquanmoshi = "wep";
                break;
            case "03":
                anquanmoshi = "wpa1";
                break;
            case "04":
                anquanmoshi = "wpa2";
                break;
            default:
                anquanmoshi = "open";
                break;
        }


        return anquanmoshi;
    }

    public void setAnquanmoshi(String anquanmoshi) {
        this.anquanmoshi = anquanmoshi;
    }

    public String getWifi_duomeiti() {
        return wifi_duomeiti;
    }

    public void setWifi_duomeiti(String wifi_duomeiti) {
        this.wifi_duomeiti = wifi_duomeiti;
    }

    public String getGongzuoxindao() {
        switch (gongzuoxindao) {
            case "01":
                gongzuoxindao = "信道1";
                break;

            case "02":
                gongzuoxindao = "信道2";
                break;
            case "03":
                gongzuoxindao = "信道3";
                break;
            case "04":
                gongzuoxindao = "信道4";
                break;
            case "05":
                gongzuoxindao = "信道5";
                break;
            case "06":
                gongzuoxindao = "信道6";
                break;
            case "07":
                gongzuoxindao = "信道7";
                break;
            case "08":
                gongzuoxindao = "信道8";
                break;
            case "09":
                gongzuoxindao = "信道9";
                break;
            case "0A":
                gongzuoxindao = "信道10";
                break;
            case "0B":
                gongzuoxindao = "信道11";
                break;
            case "0C":
                gongzuoxindao = "信道12";
                break;
            case "0D":
                gongzuoxindao = "信道13";
                break;
            default:
                gongzuoxindao = "信道1";
                break;
        }


        return gongzuoxindao;
    }

    public void setGongzuoxindao(String gongzuoxindao) {
        this.gongzuoxindao = gongzuoxindao;
    }

    public String getWifi_name() {
        return wifi_name;
    }

    public void setWifi_name(String wifi_name) {
        this.wifi_name = wifi_name;
    }

    public String getWifi_password() {
        return wifi_password;
    }

    public void setWifi_password(String wifi_password) {
        this.wifi_password = wifi_password;
    }

    public String getWifi_password_length() {
        return wifi_password_length;
    }

    public void setWifi_password_length(String wifi_password_length) {
        this.wifi_password_length = wifi_password_length;
    }

    public String getTcpOrUdp() {
        if ("00".equals(tcpOrUdp)){
            tcpOrUdp = "UDP";
        }else {
            tcpOrUdp="TCP";
        }


        return tcpOrUdp;
    }

    public void setTcpOrUdp(String tcpOrUdp) {
        this.tcpOrUdp = tcpOrUdp;
    }

    public String getClientOrServer() {
        return clientOrServer;
    }

    public void setClientOrServer(String clientOrServer) {
        this.clientOrServer = clientOrServer;
    }

    public String getFar_ip_140() {
        return far_ip_140;
    }

    public void setFar_ip_140(String far_ip_140) {
        this.far_ip_140 = far_ip_140;
    }

    public String getFar_ip_141() {
        return far_ip_141;
    }

    public void setFar_ip_141(String far_ip_141) {
        this.far_ip_141 = far_ip_141;
    }

    public String getFar_ip_142() {
        return far_ip_142;
    }

    public void setFar_ip_142(String far_ip_142) {
        this.far_ip_142 = far_ip_142;
    }

    public String getFar_ip_143() {
        return far_ip_143;
    }

    public void setFar_ip_143(String far_ip_143) {
        this.far_ip_143 = far_ip_143;
    }

    public String getFar_port() {
        return far_port;
    }

    public void setFar_port(String far_port) {
        this.far_port = far_port;
    }

    public String getLoc_port() {
        return loc_port;
    }

    public void setLoc_port(String loc_port) {
        this.loc_port = loc_port;
    }

    public String getSerial_port() {
        switch (serial_port) {
            case "00":
                serial_port = "110";
                break;
            case "01":
                serial_port = "300";
                break;

            case "02":
                serial_port = "1200";
                break;
            case "03":
                serial_port = "2400";
                break;
            case "04":
                serial_port = "4800";
                break;
            case "05":
                serial_port = "9600";
                break;
            case "06":
                serial_port = "19200";
                break;
            case "07":
                serial_port = "38400";
                break;
            case "08":
                serial_port = "57600";
                break;
            case "09":
                serial_port = "115200";
                break;
            case "0A":
                serial_port = "156250";
                break;
            case "0B":
                serial_port = "250000";
                break;
            case "0C":
                serial_port = "312500";
                break;
            case "0D":
                serial_port = "500000";
                break;
            case "0E":
                serial_port = "625000";
                break;
            case "0F":
                serial_port = "1250000";
                break;
            default:
                serial_port = "信道1";
                break;
        }



        return serial_port;
    }

    public void setSerial_port(String serial_port) {
        this.serial_port = serial_port;
    }

    public String getdHCP() {
        return dHCP;
    }

    public void setdHCP(String dHCP) {
        this.dHCP = dHCP;
    }

    public String getLoc_ip_150() {
        return loc_ip_150;
    }

    public void setLoc_ip_150(String loc_ip_150) {
        this.loc_ip_150 = loc_ip_150;
    }

    public String getLoc_ip_151() {
        return loc_ip_151;
    }

    public void setLoc_ip_151(String loc_ip_151) {
        this.loc_ip_151 = loc_ip_151;
    }

    public String getLoc_ip_152() {
        return loc_ip_152;
    }

    public void setLoc_ip_152(String loc_ip_152) {
        this.loc_ip_152 = loc_ip_152;
    }

    public String getLoc_ip_153() {
        return loc_ip_153;
    }

    public void setLoc_ip_153(String loc_ip_153) {
        this.loc_ip_153 = loc_ip_153;
    }


    public String getZiwangyanma_154() {
        return ziwangyanma_154;
    }

    public void setZiwangyanma_154(String ziwangyanma_154) {
        this.ziwangyanma_154 = ziwangyanma_154;
    }

    public String getZiwangyanma_155() {
        return ziwangyanma_155;
    }

    public void setZiwangyanma_155(String ziwangyanma_155) {
        this.ziwangyanma_155 = ziwangyanma_155;
    }

    public String getZiwangyanma_156() {
        return ziwangyanma_156;
    }

    public void setZiwangyanma_156(String ziwangyanma_156) {
        this.ziwangyanma_156 = ziwangyanma_156;
    }

    public String getZiwangyanma_157() {
        return ziwangyanma_157;
    }

    public void setZiwangyanma_157(String ziwangyanma_157) {
        this.ziwangyanma_157 = ziwangyanma_157;
    }

    public String getWangguan_158() {
        return wangguan_158;
    }

    public void setWangguan_158(String wangguan_158) {
        this.wangguan_158 = wangguan_158;
    }

    public String getWangguan_159() {
        return wangguan_159;
    }

    public void setWangguan_159(String wangguan_159) {
        this.wangguan_159 = wangguan_159;
    }

    public String getWangguan_160() {
        return wangguan_160;
    }

    public void setWangguan_160(String wangguan_160) {
        this.wangguan_160 = wangguan_160;
    }

    public String getWangguan_161() {
        return wangguan_161;
    }

    public void setWangguan_161(String wangguan_161) {
        this.wangguan_161 = wangguan_161;
    }

    public String getdNS_162() {
        return dNS_162;
    }

    public void setdNS_162(String dNS_162) {
        this.dNS_162 = dNS_162;
    }

    public String getdNS_163() {
        return dNS_163;
    }

    public void setdNS_163(String dNS_163) {
        this.dNS_163 = dNS_163;
    }

    public String getdNS_164() {
        return dNS_164;
    }

    public void setdNS_164(String dNS_164) {
        this.dNS_164 = dNS_164;
    }

    public String getdNS_165() {
        return dNS_165;
    }

    public void setdNS_165(String dNS_165) {
        this.dNS_165 = dNS_165;
    }

    //	public ShebeiDataPackage() {
//		// TODO Auto-generated constructor stub
//		totalsize = "";
//		reqNum = "";
//		funType = "";
//		mesType = "";
//		exb = "";
//		exo = "";
//		exd = "";
//		resd = "";
//		appdata = "";
//	}
//
//	public void Clear(){
//		totalsize = "";
//		reqNum = "";
//		funType = "";
//		mesType = "";
//		exb = "";
//		exo = "";
//		exd = "";
//		resd = "";
//		appdata = "";
//	}
}	
