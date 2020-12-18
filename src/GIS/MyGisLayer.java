package GIS;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * This class represents a collection of element
 * @author Israel-PC
 *
 */
public class MyGisLayer implements GIS_layer{

	ArrayList<GIS_element> layer=new ArrayList<GIS_element>();
	long utc= new Date().getTime();;
	private MyMeta_data mData;


	/**
	 * get layer
	 * @return layer
	 */
	public ArrayList<GIS_element> getLayer() {
		return layer;
	}
	/**
	 * update this layer
	 * @param layer
	 */
	public void setLayer(ArrayList<GIS_element> layer) {
		this.layer = layer;
	}
	/**
	 * get utc
	 * @return utc
	 */
	public long getUtc() {
		return utc;
	}
	/**
	 * update this utc
	 * @param utc
	 */
	public void setUtc(long utc) {
		this.utc = utc;
	}
	/**
	 * get meta data
	 * @return meta data
	 */
	public MyMeta_data getmData() {
		return mData;
	}
	/**
	 * update this meta data
	 * @param mData
	 */
	public void setmData(MyMeta_data mData) {
		this.mData = mData;
	}

	/**
	 * consttructor
	 */
	public MyGisLayer(){
		Date t = new Date();
		utc = t.getTime();
		mData=new MyMeta_data();

	}
	/**
	 * get utc
	 * @return utc
	 */
	public long getUTC() {
		return utc;
	}

	@Override
	public int size() {

		return layer.size();
	}

	@Override
	public boolean isEmpty() {

		return layer.isEmpty();
	}

	@Override
	public boolean contains(Object o) {

		return layer.contains(o);
	}

	@Override
	public Iterator<GIS_element> iterator() {

		return layer.iterator();
	}

	@Override
	public Object[] toArray() {

		return layer.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {

		return layer.toArray(a);
	}

	@Override
	public boolean add(GIS_element e) {

		boolean flag =layer.add(e);
		return flag;
	}

	@Override
	public boolean remove(Object o) {

		boolean flag =layer.remove(o);
		return flag;
	}

	@Override
	public boolean containsAll(Collection<?> c) {

		boolean flag =layer.containsAll(c);
		return flag;
	}

	@Override
	public boolean addAll(Collection<? extends GIS_element> c) {

		boolean flag =layer.addAll(c);
		return flag;
	}

	@Override
	public boolean retainAll(Collection<?> c) {

		boolean flag =layer.retainAll(c);
		return flag;
	}

	@Override
	public boolean removeAll(Collection<?> c) {

		boolean flag =layer.removeAll(c);
		return flag;
	}

	@Override
	public void clear() {

		layer.clear();
	}

	@Override
	public Meta_data get_Meta_data() {
		MyMeta_data m =new MyMeta_data();
		return m;
	}


}
