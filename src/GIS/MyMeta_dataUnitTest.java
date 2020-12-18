package GIS;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyMeta_dataUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMyMeta_dataStringArray() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		if(!(m.getMAC()==c[0]&&m.getSSID() ==c[1]&&m.getAuthMode() == c[2]&&m.getFirstSeen() == c[3]&&m.getChannel() == c[4]&&m.getRSSI() == c[5]&&m.getAccuracyMeters() == c[9]&&m.getTyep() == c[10]))
			fail("The Meta_data not equal ");
	}

	//	@Test
	//	void testMyMeta_dataMyMeta_data() {
	//		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
	//		MyMeta_data m = new MyMeta_data(c);
	//		MyMeta_data m2 = new MyMeta_data(m);
	//		if(!(m.equals(m2)))
	//			fail("The Meta_data not equal ");
	//	}

	//	@Test
	//	void testGet_Orientation() {
	//		fail("Not yet implemented");
	//	}

	@Test
	void testToString() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		String ans = "MAC: " +m.getMAC() + " , SSID: " + m.getSSID() + "  ,AuthMode: " + m.getAuthMode() + " ,FirstSeen: " + m.getFirstSeen() + " ,Channel: " + m.getChannel() +" ,RSSI: " + m.getRSSI() + "AccuracyMeters: " + m.getAccuracyMeters() + "Tyep: "+m.getTyep();
		if(!(m.toString().equals(ans)))
			fail("The Meta_data not equal ");
	}

	@Test
	void testGetTyep() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		if(!(m.getTyep().equals("WIFI")))
			fail("The type not equal ");


	}

	@Test
	void testSetTyep() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyMeta_data m2 = new MyMeta_data(m);
		m2.setTyep("WIFI");
		if(!(m.getTyep().equals(m2.getTyep())))
			fail("The Meta_data not equal ");

	}

	@Test
	void testGetMAC() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		if(!(m.getMAC().equals("1c:b9:c4:15:47:68")))
			fail("The Meta_data not equal ");
	}

	@Test
	void testSetMAC() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyMeta_data m2 = new MyMeta_data(m);
		m2.setMAC("1c:b9:c4:15:47:68");
		if(!(m.getMAC().equals(m2.getMAC())))
			fail("The Meta_data not equal ");
	}

	@Test
	void testGetSSID() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		if(!(m.getSSID().equals("moran")))
			fail("The Meta_data not equal ");
	}

	@Test
	void testSetSSID() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyMeta_data m2 = new MyMeta_data(m);
		m2.setSSID("moran");
		if(!(m.getSSID().equals(m2.getSSID())))
			fail("The Meta_data not equal ");
	}

	@Test
	void testGetAuthMode() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		if(!(m.getAuthMode().equals("[ESS]")))
			fail("The Meta_data not equal ");
	}

	@Test
	void testSetAuthMode() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyMeta_data m2 = new MyMeta_data(m);
		m2.setAuthMode("[ESS]");
		if(!(m.getAuthMode().equals(m2.getAuthMode())))
			fail("The Meta_data not equal ");
	}

	@Test
	void testGetChannel() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		if(!(m.getChannel().equals("11")))
			fail("The Meta_data not equal ");
	}

	@Test
	void testSetChannel() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyMeta_data m2 = new MyMeta_data(m);
		m2.setChannel("11");
		if(!(m.getChannel().equals(m2.getChannel())))
			fail("The Meta_data not equal ");
	}

	@Test
	void testGetRSSI() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		if(!(m.getRSSI().equals("-85")))
			fail("The Meta_data not equal ");
	}

	@Test
	void testSetRSSI() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyMeta_data m2 = new MyMeta_data(m);
		m2.setChannel("-85");
		if(!(m.getRSSI().equals(m2.getRSSI())))
			fail("The Meta_data not equal ");
	}

	@Test
	void testGetAccuracyMeters() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		if(!(m.getAccuracyMeters().equals("3")))
			fail("The Meta_data not equal ");
	}

	@Test
	void testSetAccuracyMeters() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyMeta_data m2 = new MyMeta_data(m);
		m2.setAccuracyMeters("3");
		if(!(m.getAccuracyMeters().equals(m2.getAccuracyMeters())))
			fail("The Meta_data not equal ");
	}

	@Test
	void testGetFirstSeen() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		if(!(m.getFirstSeen().equals("03/12/2017 08:53")))
			fail("The Meta_data not equal ");
	}

	@Test
	void testSetFirstSeen() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyMeta_data m2 = new MyMeta_data(m);
		m2.setFirstSeen("03/12/2017 08:53");
		if(!(m.getFirstSeen().equals(m2.getFirstSeen())))
			fail("The Meta_data not equal ");
	}
//
//	@Test
//	void testSetUTC() {
//		fail("Not yet implemented");
//	}

}
