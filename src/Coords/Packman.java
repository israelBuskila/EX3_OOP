package Coords;

import java.util.ArrayList;

import Geom.Point3D;
/**
 * This class is represent packman by location id and speed,radius,grade.
 * @author Israel and Moran
 *
 */
public class Packman {
	public int id;
	public Point3D p;
	public double Speed;
	public double Radius;
	public double grade;
	ArrayList<Integer> fruitEat = new ArrayList<Integer>();
	
	public ArrayList<Integer> getFruitEat() {
		return fruitEat;
	}
	public void setFruitEat(ArrayList<Integer> fruitEat) {
		this.fruitEat = fruitEat;
	}
	/**
	 * Copy constructor
	 * @param id
	 * @param p1
	 * @param s
	 * @param r
	 * @param g
	 */
	public Packman(int id,Point3D p1,double s,double r) {
		
		this.id = id;
		p=new Point3D(p1);
		this.Speed =s;
		this.Radius = r;
	}
	/**
	 * constructor
	 */
	public Packman() {
		this.id = -1;
		p=new Point3D(0,0,0);
		this.Speed =0;
		this.Radius = 0;
	}
	/**
	 * get function for grade value
	 * @return grade
	 */
	public double getGrade() {
		return grade;
	}
	/**
	 * set function for grade value update the value grade to the value we get
	 * @param grade
	 */
	public void setGrade(double grade) {
		this.grade = grade;
	}
	/**
	 * constructor from string array
	 * @param c
	 */
	public Packman(String []c) {
		this.id = (int)Double.parseDouble(c[1]);
		double x,y,z;
		x = Double.parseDouble(c[2]);
		y = Double.parseDouble(c[3]);
		z = Double.parseDouble(c[4]);
		p=new Point3D(x,y,z);
		this.Speed = Double.parseDouble(c[5]);
		this.Radius = Double.parseDouble(c[6]);
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
	/**
	 * get function for Speed value
	 * @return Speed
	 */
	public double getSpeed() {
		return Speed;
	}
	/**
	 * set function for speed value update the value speed to the value we get
	 * @param speed
	 */
	public void setSpeed(double speed) {
		this.Speed = speed;
	}
	/**
	 * get function for Radius value
	 * @return Radius
	 */
	public double getRadius() {
		return Radius;
	}
	/**
	 * set function for Radius value update the value Radius to the value we get
	 * @param Radius
	 */
	public void setRadius(double radius) {
		this.Radius = radius;
	}
}
