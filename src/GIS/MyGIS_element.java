package GIS;

import Coords.MyCoords;
import Geom.Geom_element;
import Geom.Point3D;

public class MyGIS_element implements GIS_element {



	private MyMeta_data m;
	private Point3D p;
	/**
	 * The constructor receives a point and all information about it
	 *@param  pd
	 * @param  md
	 */
	public MyGIS_element(Point3D pd,MyMeta_data md) {
		m = new MyMeta_data(md);
		p=new Point3D(pd);
	}
	/**
	 * A constructor that receives an array of strings and copies all the information of the layer to it
	 * @param  c 
	 */
	public void String(String[] c) {

		m.getMAC();
		m.setSSID(c[1] );
		m.setAuthMode(c[2]);
		m.setFirstSeen(c[3]);
		m.setChannel(c[4]);
		m.setRSSI(c[5]);
		p=new Point3D(Double.parseDouble(c[6]),Double.parseDouble(c[7]),Double.parseDouble(c[8]));
		m.setAccuracyMeters(c[9]);
		m.setTyep(c[10]);
	}
	/**
	 * @return point 3D
	 */
	@Override
	public Geom_element getGeom() {

		return new Point3D (p);	}
	/**
	 * @return MyMeta_data
	 */
	@Override
	public Meta_data getData() {


		return new MyMeta_data(m);
	}
	/**
	 * This function receives a vector and updates the position of the point after adding the vector
	 * @param vec
	 */
	@Override
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub
		MyCoords n = new MyCoords();
		p=n.add(p, vec);
	}
	/**
	 * 
	 * @return MyMeta_data
	 */
	public MyMeta_data getM() {
		return new MyMeta_data(m);
	}
	/**
	 * Updating metadata information
	 * @param  m
	 */
	public void setM(MyMeta_data m) {
		this.m = m;
	}
	/**
	 * 
	 * @return Point3D
	 */
	public Point3D getP() {
		return new  Point3D(p);
	}
	/**
	 * Updating point information
	 * @param p
	 */
	public void setP(Point3D p) {
		this.p = p;
	}

}
