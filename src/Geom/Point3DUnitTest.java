package Geom;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Point3DUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPoint3DStringArray() {
		String []c= {"1c:b9:c4:15:47:68","moran","[ESS]","03/12/2017 08:53","11","-85","32.10487307","35.21134308","692","3","WIFI"};
		Point3D p=new Point3D (c);
		Point3D p2=new Point3D(32.10487307,35.21134308,692);
		if(!p.equals(p2))
			fail("The points not equal");
	}

	@Test
	void testPoint3DDoubleDoubleDouble() {
		Point3D p=new Point3D(32.10487307,35.21134308,692);
		double x=32.10487307, y=35.21134308, z=692;
		if(!(p.x()==x&&p.y()==y&&p.z()==z))
			fail("The points not equal");
	}

	@Test
	void testPoint3DPoint3D() {
		Point3D p=new Point3D(32.10487307,35.21134308,692);
		Point3D p2=new Point3D(p);
		if(!p.equals(p2))
			fail("The points not equal");

	}

	@Test
	void testPoint3DDoubleDouble() {
		Point3D p=new Point3D(32.10487307,35.21134308,0);
		double x=32.10487307, y=35.21134308, z=0;
		if(!(p.x()==x&&p.y()==y&&p.z()==z))
			fail("The points not equal");
	}

	@Test
	void testPoint3DString() {
		String s= ""+32.10487307+","+35.21134308+","+692.0;
		Point3D p=new Point3D (s);
		Point3D p2=new Point3D(32.10487307,35.21134308,692);
		if(!p.equals(p2))
			fail("The points not equal");
	}

	@Test
	void testToString() {
		Point3D p2=new Point3D(32.10487307,35.21134308,692);
		String s=""+32.10487307+","+35.21134308+","+692.0;
		String s2=p2.toString();
		if(!s.equals(s2))
			fail("The points not equal");
	}

	@Test
	void testDistance3DPoint3D() {
		String s= ""+0.0+","+0.0+","+0.0;
		Point3D p=new Point3D (s);
		Point3D p2=new Point3D(32.10487307,35.21134308,692);
		double t = p.x()*p.x()+p.y()*p.y()+p.z()*p.z();
		double dis= Math.sqrt(t);
		double dis2=p2.distance3D(p2.x(),p2.y(),p2.z());
		if(dis2!=dis)
		fail("The pdistance not equal");
	}

	

	
	

}
