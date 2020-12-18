package GIS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
/**
 * This class represents a collection of layers
 * @author Israel-PC
 *
 */
public class MyGIS_project implements GIS_project {


	ArrayList<GIS_layer> project=new ArrayList<GIS_layer>();
	private MyMeta_data pData;

	/**
	 * constructor
	 */
	public MyGIS_project() {
		this.project=new ArrayList<GIS_layer>();
	}

	/**
	 * @return size of project
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return project.size();
	}

	/**
	 * This function checks if the project is empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return project.isEmpty();
	}

	/**
	 * this function checks if the project contains other Object
	 */
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return project.contains(o);
	}

	/**
	 * Iterator
	 */
	@Override
	public Iterator<GIS_layer> iterator() {
		// TODO Auto-generated method stub
		return project.iterator();
	}

	/**
	 * @return project.toArray()
	 */
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return project.toArray();
	}

	/**
	 * 
	 * @return ArrayList<GIS_layer>(project)
	 */
	public ArrayList<GIS_layer> getProject() {
		return new ArrayList<GIS_layer>(project);
	}
	/**
	 * Updating at this project
	 * @param GIS_layer> project
	 */
	public void setProject(ArrayList<GIS_layer> project) {
		this.project = project;
	}
	/**
	 * 
	 * @return MyMeta_data(pData)
	 */
	public MyMeta_data getpData() {
		return new MyMeta_data(pData);
	}
	/**
	 * updating this meta data
	 * @param pData
	 */
	public void setpData(MyMeta_data pData) {
		this.pData = pData;
	}
	/**
	 * @return roject.toArray(a)
	 */
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return project.toArray(a);
	}

	/**
	 * Adding layer to collection
	 * @param GIS_layer e
	 * @return true If successful
	 */
	@Override
	public boolean add(GIS_layer e) {
		// TODO Auto-generated method stub
		boolean flag =project.add(e);
		return flag;
	}

	/**
	 * @param Object o
	 * @return true If successful
	 */
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		boolean flag =project.remove(o);
		return flag;
	}

	/**
	 * @param Collection<?> c
	 * @return true if successful
	 */
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean flag =project.containsAll(c);
		return flag;
	}

	/**
	 * this function add all collection
	 * @param Collection<? extends GIS_layer> c
	 * @return true if successful
	 */
	@Override
	public boolean addAll(Collection<? extends GIS_layer> c) {
		// TODO Auto-generated method stub
		boolean flag =project.addAll(c);
		return flag;
	}

	/**
	 * @param Collection<?> c
	 * @return true if successful
	 */
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean flag =project.retainAll(c);
		return flag;
	}

	/**
	 * @param Collection<?> c
	 * return true if successful
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean flag =project.removeAll(c);
		return flag;
	}

	/**
	 * clear this project
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		project.clear();
	}

	/**
	 * @return meta data
	 */
	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		MyMeta_data m =new MyMeta_data(pData);
		return m;
	}

}
