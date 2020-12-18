package GIS;

import java.util.Date;

import Geom.Point3D;
/**
 * This class represents all the information about the layer except the coordinates
 * @author Israel-PC
 *
 */
public class MyMeta_data implements Meta_data{

	public String Tyep;
	public String MAC;
	public String SSID;
	public String AuthMode;
	public String Channel;
	public String RSSI;
	public String AccuracyMeters;
	public String FirstSeen;
	private long UTC= new Date().getTime();

	/**
	 * constructor
	 */
	public MyMeta_data() {
		MAC = "";
		SSID ="";
		AuthMode = "";
		FirstSeen = "";
		Channel = "";
		RSSI = "";
		AccuracyMeters ="";
		Tyep = "";
		UTC = new Date().getTime();
	}
	/**
	 * constructor
	 * Creates a layer from an array of strings
	 * @param String[] c
	 */
	public MyMeta_data(String[] c) {
		MAC = c[0];
		SSID = c[1];
		AuthMode = c[2];
		FirstSeen = c[3];
		Channel = c[4];
		RSSI = c[5];
		AccuracyMeters = c[9];
		Tyep = c[10];

	}
	/**
	 * Constructor Copier
	 * @param cMyMeta_data c
	 */
	public MyMeta_data(MyMeta_data c) {
		this.MAC = c.MAC;
		this.SSID = c.SSID;
		this.AuthMode = c.AuthMode;
		this.FirstSeen = c.FirstSeen;
		this.Channel = c.Channel;
		this.RSSI = c.RSSI;
		this.AccuracyMeters = c.AccuracyMeters;
		this.Tyep = c.Tyep;

	}

	@Override
	public long getUTC() {
		// TODO Auto-generated method stub

		return this.UTC;
	}
	//this function for teh next assigment
	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * this function print the meta data
	 */
	public String toString() {
		String ans = "MAC: " +MAC + " , SSID: " + SSID + "  ,AuthMode: " + AuthMode + " ,FirstSeen: " + FirstSeen + " ,Channel: " + Channel +" ,RSSI: " + RSSI + "AccuracyMeters: " + AccuracyMeters + "Tyep: "+Tyep;

		return ans;
	}

	/**
	 * get tyep
	 * @return tyep
	 */
	public String getTyep() {
		return Tyep;
	}

	/**
	 * update this tyep
	 * @param tyep
	 */
	public void setTyep(String tyep) {
		Tyep = tyep;
	}

	/**
	 * get mac
	 * @return mac
	 */
	public String getMAC() {
		return MAC;
	}

	/**
	 * update this MAC
	 * @param string  MAC
	 */
	public void setMAC(String mAC) {
		MAC = mAC;
	}

	/**
	 * get SSID
	 * @return SSID
	 */
	public String getSSID() {
		return SSID;
	}

	/**
	 * update SSID
	 * @param sSID
	 */
	public void setSSID(String sSID) {
		SSID = sSID;
	}

	/**
	 * get AuthMode
	 * @return AuthMode
	 */
	public String getAuthMode() {
		return AuthMode;
	}

	/**
	 * update AuthMode
	 * @param string AuthMode
	 */
	public void setAuthMode(String authMode) {
		AuthMode = authMode;
	}

	/**
	 * get Channel
	 * @return Channel
	 */
	public String getChannel() {
		return Channel;
	}

	/**
	 * update this Channel
	 * @param string channel
	 */
	public void setChannel(String channel) {
		Channel = channel;
	}

	/**
	 * get RSSI
	 * @return RSSI
	 */
	public String getRSSI() {
		return RSSI;
	}

	/**
	 * update this RSSI
	 * @param rSSI
	 */
	public void setRSSI(String rSSI) {
		RSSI = rSSI;
	}
	/**
	 * get AccuracyMeters
	 * @return AccuracyMeters
	 */
	public String getAccuracyMeters() {
		return AccuracyMeters;
	}

	/**
	 * update this AccuracyMeters
	 * @param accuracyMeters
	 */
	public void setAccuracyMeters(String accuracyMeters) {
		AccuracyMeters = accuracyMeters;
	}

	/**
	 * get first seen
	 * @return FirstSeen
	 */
	public String getFirstSeen() {
		return FirstSeen;
	}

	/**
	 * update this FirstSeen
	 * @param string firstSeen
	 */
	public void setFirstSeen(String firstSeen) {
		FirstSeen = firstSeen;
	}

	/**
	 * update this UTC
	 * @param long uTC
	 */
	public void setUTC(long uTC) {
		UTC = uTC;
	}



}
