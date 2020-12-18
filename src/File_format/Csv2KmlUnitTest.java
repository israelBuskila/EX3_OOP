package File_format;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GIS.MyGIS_element;
import GIS.MyGisLayer;
import GIS.MyMeta_data;
import Geom.Point3D;

class Csv2KmlUnitTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testWriteFile() {
		MyGisLayer l = new MyGisLayer();
		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyGIS_element e = new MyGIS_element(p, m);
		l.add(e);
		MyGisLayer l2 = new MyGisLayer();
		l2 = Csv2Kml.writeFile("C:\\Users\\moran\\Downloads\\123.csv");
		boolean equal=l.getLayer().equals(l2.getLayer());
		if(equal==false)
			fail("not equals");
		}
		
	

}