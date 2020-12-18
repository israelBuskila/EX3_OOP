package GIS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Geom.Geom_element;
import Geom.Point3D;

class MyGisLayerUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetLayer() {
		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyGIS_element e = new MyGIS_element(p, m);
		MyGisLayer l=new MyGisLayer();
		l.add(e);
		l.add(e);
		ArrayList<GIS_element> layer=new ArrayList<GIS_element>();
		layer.add(e);
		layer.add(e);
		if(!l.getLayer().equals(layer))
			fail("The layers are not equal");


	}
	@Test
	void testSetLayer() {
		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyGIS_element e = new MyGIS_element(p, m);
		MyGisLayer l=new MyGisLayer();
		ArrayList<GIS_element> layer=new ArrayList<GIS_element>();
		layer.add(e);
		layer.add(e);
		l.setLayer(layer);
		if(!l.getLayer().equals(layer))
			fail("The layers are not equal");
	}

	@Test
	void testSize() {
		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyGIS_element e = new MyGIS_element(p, m);
		MyGisLayer l=new MyGisLayer();
		ArrayList<GIS_element> layer=new ArrayList<GIS_element>();
		layer.add(e);
		layer.add(e);
		l.setLayer(layer);
		if(l.size()!=2)
			fail("The layers are not equal");
	}

	@Test
	void testIsEmpty() {
		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyGIS_element e = new MyGIS_element(p, m);
		MyGisLayer l=new MyGisLayer();
		if(l.isEmpty()==false)
			fail("The layers are not equal");
	}

	@Test
	void testContains() {
		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyGIS_element e = new MyGIS_element(p, m);
		MyGisLayer l=new MyGisLayer();
		ArrayList<GIS_element> layer=new ArrayList<GIS_element>();
		layer.add(e);
		l.setLayer(layer);
		if(l.contains(e)==false)
			fail("The layers are not equal");
	}
	@Test
	void testRemove() {
		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyGIS_element e = new MyGIS_element(p, m);
		MyGisLayer l=new MyGisLayer();
		ArrayList<GIS_element> layer=new ArrayList<GIS_element>();
		layer.add(e);
		l.setLayer(layer);
		if(l.remove(e)==false)
			fail("The layers are not equal");
	}

	//	@Test
	//	void testContainsAll() {
	//		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
	//		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
	//		MyMeta_data m = new MyMeta_data(c);
	//		MyGIS_element e = new MyGIS_element(p, m);
	//		MyGisLayer l=new MyGisLayer();
	//		ArrayList<GIS_element> layer=new ArrayList<GIS_element>();
	//		layer.add(e);
	//		l.setLayer(layer);
	//		if(l.remove(layer)==false)
	//			fail("The layers are not equal");
	//	}


	//	@Test
	//	void testRemoveAll() {
	//		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
	//		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
	//		MyMeta_data m = new MyMeta_data(c);
	//		MyGIS_element e = new MyGIS_element(p, m);
	//		MyGisLayer l=new MyGisLayer();
	//		ArrayList<GIS_element> layer=new ArrayList<GIS_element>();
	//		layer.add(e);
	//		l.setLayer(layer);
	//		if(l.remove(layer)==false)
	//			fail("The layers are not equal");
	//	}

	@Test
	void testClear() {
		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyGIS_element e = new MyGIS_element(p, m);
		MyGisLayer l=new MyGisLayer();
		ArrayList<GIS_element> layer=new ArrayList<GIS_element>();
		layer.add(e);
		l.setLayer(layer);
		//		if(l.clear())
		//			fail("The layers are not equal");
	}
}



