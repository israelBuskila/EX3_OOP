package GUI;

import javax.swing.JFrame;

import Coords.MyCoords;
import Geom.Point3D;


public class Main 
{
	public static void main(String[] args)
	{
		MyFrame window = new MyFrame();
		window.setVisible(true);
		window.setSize(window.myImage.getWidth(),window.myImage.getHeight());
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		MyCoords m = new MyCoords();
//		Point3D p1 = new Point3D( 32.10571,35.20238);
//		Point3D p2 = new Point3D(32.10186,35.21237);
//		System.out.println(m.distance3d(p1, p2));//=1148.9915841381974
//		int w = window.getWidth();
//		int h = window.getWidth();
//		double xn = window.x;
//		double yn = window.y;
//		Map.pixel(w, h, xn, yn);
		
	}
}
