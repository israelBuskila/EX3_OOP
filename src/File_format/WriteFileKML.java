package File_format;

import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import GIS.MyGIS_element;
import GIS.MyGIS_project;
import GIS.MyGisLayer;
import GIS.MyMeta_data;
import Geom.Point3D;
/**
 * This class represents a conversion from a data structure to a kml file
 * @author Israel-PC
 *
 */
public class WriteFileKML {
	/**
	 * This function accepts a layer and converts it to a .kml file
	 * @param layer
	 */
	public static void writeFileKML(MyGisLayer layer) {

		String kmlend = "</kml>";
		String output = "output.kml";

		PrintWriter pw = null;
		File file = new File(output);
		//<?xml version="1.0" encoding="UTF-8"?>
		String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +

"<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\n";


		try 

		{

			pw = new PrintWriter(file);

		} 

		catch (FileNotFoundException e) 

		{

			e.printStackTrace();

		}

		MyMeta_data m=new MyMeta_data();
		Point3D p=new Point3D(0,0,0);
		MyGIS_element element =new MyGIS_element(p,m);
		Date date = new Date(element.getM().getUTC());
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		pw.append(kmlstart);
		for (int i = 0; i <layer.size(); i++) {
			element=(MyGIS_element) layer.getLayer().get(i);
			String kmlelement = 
					"<Placemark>\n" +
							"<name><![CDATA["+element.getM().getSSID()+"]]></name>\n"+
							"<description><![CDATA[BSSID: <b>"+element.getM().getMAC()+"</b><br/>Capabilities: <b>"+element.getM().getAuthMode()+"</b><br/>Frequency: <b>"+element.getM().getRSSI()+"</b><br/>Timestamp: <b>"+dateFormat.format(date) +"</b><br/>Date: <b>"+element.getM().getFirstSeen()+"</b>]]></description><styleUrl>#red</styleUrl>\n"
							+"<Point>\n"+
							"<coordinates>"+element.getP().y()+","+element.getP().x()+"</coordinates>"+"</Point>\n"+
							"</Placemark>\n";




			pw.append(kmlelement);
		}
		pw.append("</Folder>\n"+"</Document>\n"+kmlend);

		pw.close();

		System.out.println("done");

	}
	/**
	 * This function accepts a collection of layers and converts them to a .kml file
	 * @param project
	 */
	public static void writeFileKMLPro(MyGIS_project project) {

		String kmlend = "</kml>";
		String output = "output.kml";

		PrintWriter pw = null;
		File file = new File(output);
		//<?xml version="1.0" encoding="UTF-8"?>
		String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +

"<kml xmlns=\"http://www.opengis.net/kml/2.2\"><Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style><Folder><name>Wifi Networks</name>\n";


		try 

		{

			pw = new PrintWriter(file);

		} 

		catch (FileNotFoundException e) 

		{

			e.printStackTrace();

		}

		MyGisLayer l = new MyGisLayer();
		MyMeta_data m=new MyMeta_data();
		Point3D p=new Point3D(0,0,0);
		MyGIS_element element =new MyGIS_element(p,m);
		Date date = new Date(element.getM().getUTC());
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		pw.append(kmlstart);
		for (int j = 0; j < project.size(); j++) {
			l = (MyGisLayer) project.getProject().get(j);

			for (int i = 0; i <l.size(); i++) {
				element=(MyGIS_element) l.getLayer().get(i);
				String kmlelement = 
						"<Placemark>\n" +
								"<name><![CDATA["+element.getM().getSSID()+"]]></name>\n"+
								"<description><![CDATA[BSSID: <b>"+element.getM().getMAC()+"</b><br/>Capabilities: <b>"+element.getM().getAuthMode()+"</b><br/>Frequency: <b>"+element.getM().getRSSI()+"</b><br/>Timestamp: <b>"+dateFormat.format(date) +"</b><br/>Date: <b>"+element.getM().getFirstSeen()+"</b>]]></description><styleUrl>#red</styleUrl>\n"
								+"<Point>\n"+
								"<coordinates>"+element.getP().y()+","+element.getP().x()+"</coordinates>"+"</Point>\n"+
								"</Placemark>\n";




				pw.append(kmlelement);
			}
		}
		pw.append("</Folder>\n"+"</Document>\n"+kmlend);

		pw.close();

		System.out.println("done");

	}


}
