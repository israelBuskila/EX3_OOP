package GIS;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Geom.Point3D;

class MyGIS_projectUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMyGIS_project() {
		ArrayList<GIS_layer> project=new ArrayList<GIS_layer>();
		MyGIS_project p=new MyGIS_project();
		if(!p.getProject().equals(project))
			fail("The project not equal");
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
		MyGIS_project po=new MyGIS_project();
		po.add(l);
		if(po.size()!=1)
			fail("The project are not equal");
	}

	@Test
	void testIsEmpty() {
		MyGIS_project po=new MyGIS_project();
		if(po.isEmpty()==false)
			fail("The project are not equal");
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
		layer.add(e);
		l.setLayer(layer);
		MyGIS_project po=new MyGIS_project();
		po.add(l);
		if(po.contains(l)==false)
			fail("The project are not equal");
	}

	@Test
	void testGetProject() {
		Point3D p = new Point3D(32.10487307, 35.21134308, 692);
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		MyMeta_data m = new MyMeta_data(c);
		MyGIS_element e = new MyGIS_element(p, m);
		MyGisLayer l=new MyGisLayer();
		ArrayList<GIS_element> layer=new ArrayList<GIS_element>();
		layer.add(e);
		layer.add(e);
		l.setLayer(layer);
		MyGIS_project po=new MyGIS_project();
		po.add(l);
		if(po.getProject().equals(l))
			fail("The project are not equal");
	}

}
