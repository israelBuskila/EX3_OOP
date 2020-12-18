package Coords;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Geom.Point3D;

class MyCoordsUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAdd() {

		MyCoords m = new MyCoords();	
		Point3D p1 = new Point3D(32.103315,35.209039,670);
		Point3D p2 = new Point3D(32.106352,35.205225,650);

		Point3D v=m.vector3D(p1, p2);
		Point3D pAdd=m.add(p1, v);

		Point3D p3 = new Point3D(32.10008419426304,35.205225,650);
		if(!p3.equals(pAdd))
		{
			fail("Error the Points are not the same");
		}
	}

	@Test
	void testDistance3d() {
		MyCoords m= new MyCoords();
		Point3D p1 = new Point3D (32.103315,35.209039,670);
		Point3D p2 = new Point3D (32.106352,35.205225,650);
		double dis =m.distance3d(p1, p2);
		double x=493.0523316830263;
		if(dis!=x) 
		{
			fail("Error the distances are not the same");
		}

	}

	@Test
	void testVector3D() {
		MyCoords m= new MyCoords();
		Point3D p1 = new Point3D (32.103315,35.209039,670);
		Point3D p2 = new Point3D (32.106352,35.205225,650);
		Point3D vec=m.vector3D(p1, p2);
		Point3D vec2=new Point3D(337.69899206128815,-359.2492067337923,-20);
		if(vec.x()!=vec2.x() && vec.y()!=vec2.y() && vec.z()!=vec2.z())
		{
			fail("Error the vectors are not the same");
		}
	}

	@Test
	void testAzimuth_elevation_dist() {

		double azimuth=313.2304203264989;
		double elevation=92.32476351809129;
		double distance=493.0523316830263;

		MyCoords m= new MyCoords();
		Point3D p1 = new Point3D (32.103315,35.209039,670);
		Point3D p2 = new Point3D (32.106352,35.205225,650);

		double [] ans=new double [3];
		ans=m.azimuth_elevation_dist(p1, p2);
		if(ans[0]!=azimuth && ans[1]!=elevation && distance!=ans[2])
		{
			fail("Error the arrays are not the same");
		}
	}

	@Test
	void testIsValid_GPS_Point() {
		MyCoords m= new MyCoords();
		Point3D p1 = new Point3D (32.103315,35.209039,670);
		boolean flag=m.isValid_GPS_Point(p1);
		if(!flag)
		{
			fail("Error the answers are not the same");
		}

	}
}
