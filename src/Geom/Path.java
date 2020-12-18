package Geom;

import java.util.ArrayList;

import Coords.MyCoords;
/**
 * This Class represent a list of points that are the path of packman.
 * @author Israel and Moran
 *
 */
public class Path {

	public ArrayList<Point3D> path= new ArrayList<Point3D>();

	/**
	 * Constructor
	 */
	public Path() {
		path = new ArrayList<Point3D>();
	}
	/**
	 * Copy Constructor
	 * @param p
	 */
	public Path(Path n) {
		path = new ArrayList<Point3D>(n.getPath());
	}
	/**
	 * This function calculate length of the path
	 * @return l
	 */
	public double length() {
		double l = 0;
		MyCoords m = new MyCoords();
		for (int i = 0; i < path.size()-1; i++) {
			l = l + m.distance3d(path.get(i), path.get(i+1));
		}
		return l;
	}
	/**
	 * get function for ArrayList<Point3D>(path) value
	 * @return path
	 */
	public ArrayList<Point3D> getPath() {
		return path;
	}
	/**
	 * set function for id path update the path id to the value we get
	 * @param path
	 */
	public void setPath(ArrayList<Point3D> path) {
		this.path = path;
	}
	
}
