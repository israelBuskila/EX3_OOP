package GIS;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Geom.Geom_element;
import Geom.Point3D;

class MyGIS_elementUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

//	@Test
//	void testString() {
//		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
//		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
//		MyMeta_data m = new MyMeta_data(c);
//		MyGIS_element e = new MyGIS_element(p, m);
//		//MyGIS_element e2 = String(c);
//	}

	@Test
	void testGetGeom() {
		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyGIS_element e = new MyGIS_element(p, m);
		if(!e.getGeom().equals((Geom_element)p))
			fail("The elements are not equal");
			
	}

	@Test
	void testGetM() {
		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyGIS_element e = new MyGIS_element(p, m);
		if(!e.getM().equals(m))
			fail("The elements are not equal");
	}

}
