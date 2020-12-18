package File_format;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import GIS.GIS_element;
import GIS.MyGIS_element;
import GIS.MyGisLayer;
import GIS.MyMeta_data;
import Geom.Point3D;
/**
 * This class represents a conversion from a CVS file to a data structure
 * @author Israel-PC
 *
 */
public class Csv2Kml {
	/**
	 * This function accepts a file location. CVS
	 *  reads the data, creates a layer, and returns it
	 * @param String fileLocation
	 * @return layer
	 */
	public static MyGisLayer writeFile(String fileLocation){
		String line = "";
		String comma = ",";
		ArrayList<String[]> arr = new ArrayList<String[]>();
		MyMeta_data m=new MyMeta_data();
		Point3D p=new Point3D(0,0,0);
		MyGIS_element element =new MyGIS_element(p,m);
		MyGisLayer layer =new MyGisLayer();
		int i = 0;
		try (BufferedReader b = new BufferedReader(new FileReader(fileLocation))) 
		{
			while ((line = b.readLine()) != null) 
			{
				
				arr.add(i++, line.split(comma));
			}
			
			for(i=2;i<arr.size();i++)
			{
				m=new MyMeta_data(arr.get(i));
				p=new Point3D(arr.get(i));
				element=new MyGIS_element(p,m);
				layer.add(element);
			}
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return layer;
	}
	public static void main (String[] args) {
		String fileLocation = "C:\\Users\\moran\\Downloads\\123.csv";
		WriteFileKML.writeFileKML(writeFile(fileLocation));
	}
	

}
