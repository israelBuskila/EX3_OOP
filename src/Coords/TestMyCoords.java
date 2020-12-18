package Coords;



import Geom.Point3D;

public class TestMyCoords {

	public static void main(String[] args) {


		MyCoords m = new MyCoords();	
		Point3D p1 = new Point3D(32.103315,35.209039,670);
		Point3D p2 = new Point3D(32.106352,35.205225,650);
		
		//TESTING DISTANCE\\
		double x = m.distance3d(p1,p2);
		System.out.println(x);
		
		//TESTING VECTOR3D\\
		Point3D vec=m.vector3D(p1, p2);
		System.out.println(vec);
		
		//TESTING ADD\\
		Point3D pAdd=m.add(p1, vec);
		System.out.println(pAdd);
		
		//TESTING AZIMUTH_ELEVATION_DIST\\
		double[] ans = m.azimuth_elevation_dist(p1,p2);
		System.out.println("ARRAY ANSWER" + "azimuth:"+ans[0] + " elevation:" + ans[1] + "distance:" +ans[2]);
		
		//TESTING ISVALID_GPS_POINT\\
		boolean flag=m.isValid_GPS_Point(p1);
		System.out.println(flag);
	}

}
