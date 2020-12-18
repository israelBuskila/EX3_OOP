package Coords;

import Geom.Point3D;
/**
 * This class is represent fruit bt location id and weight.
 * @author Israel and Moran
 *
 */
public class Fruit {

	/**
	 * Copy constructor
	 *  @param p
	 *  @param id
	 *  @param weight
	 */
	Point3D p;
	int id;
	double weight;
	long minTime = 0;

	public long getMinTime() {
		return minTime;
	}
	public void setMinTime(long minTime) {
		this.minTime = minTime;
	}
	public  Fruit(Point3D p,int id,double speed)
	{
		this.p=new Point3D(p);
		this.id=id;
		this.weight=speed;
	}
	/**
	 * get function for id value
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * set function for id value update the value id to the value we get
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * get function for weight value
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}
	/**
	 * set function for weight value update the value weight to the value we get
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * constructor 
	 */
	public  Fruit()
	{
		p=new Point3D(0,0,0);
	}
	/**
	 * constructor from string array
	 * @param c
	 */
	public  Fruit(String[]c) {
		id=Integer.parseInt(c[1]);
		
		double x,y,z;
		x =Double.parseDouble(c[2]);
		y = Double.parseDouble(c[3]);
		z = Double.parseDouble(c[4]);
		
		p=new Point3D(x,y,z);
		weight=Double.parseDouble(c[5]);
	}

	/**
	 * get function for p value
	 * @return p
	 */
	public Point3D getP() {
		
		return p;
	}

	/**
	 * set function for p value update the value p to the value we get
	 * @param p
	 */
	public void setP(Point3D p) {
		
		this.p = p;
	}



}
