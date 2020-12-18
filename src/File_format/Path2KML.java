package File_format;

import java.io.BufferedWriter;


import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

//import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import Algorithm.ShortestPathAlgo;
import Coords.Fruit;
import Coords.Packman;
import Geom.Path;
import Geom.Point3D;
/**
 * The Class is making a KML file
 * @author Israel-PC
 *
 */


public class Path2KML {

/**
 * Get gmae and create KML file
 * @param mapWidth
 * @param mapHeight
 * @param g
 * @param output
 */
	public void writeToKML(int mapWidth,int mapHeight,Game g, String output) {

		long cuurrentTime = System.currentTimeMillis();
		ArrayList<String> content = new ArrayList<String>();
		Date date = new Date(cuurrentTime);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		String kmlstart = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +

"<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n"+"<Document><Style id=\"red\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/red-dot.png</href></Icon></IconStyle></Style><Style id=\"yellow\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/yellow-dot.png</href></Icon></IconStyle></Style><Style id=\"green\"><IconStyle><Icon><href>http://maps.google.com/mapfiles/ms/icons/green-dot.png</href></Icon></IconStyle></Style>\n"+"<Folder><name>Game</name>\n";
		//				"<Document>" + "<Style>"+
		//
		//				"<IconStyle>"+	
		//				"<scale>1</scale>"+
		//
		//				"<Icon>"+
		//
		//				"<href>http://maps.google.com/mapfiles/kml/shapes/cycling.png</href>"+
		//
		//				"</Icon>"+
		//
		//				"</IconStyle>"+
		//
		//				"</Style>";

		content.add(kmlstart);

		try{

			FileWriter fw = new FileWriter(output+".kml");

			BufferedWriter bw = new BufferedWriter(fw);



			for (int i = 0; i <g.getPacman().size(); i++) {


				Packman pac = g.getPacman().get(i);



				String kmlelementp ="<Placemark>\n" +" <TimeStamp>\r\n" + 

						"<when>"+dateFormat.format(cuurrentTime) +"Z</when>\r\n" + 

						"</TimeStamp>"+

						"<name>"+"Type: "+"Packmen"+"</name>\n" +

						"<description>"+"ID: "+pac.getId()+", radius: "+pac.getRadius()+", Speed: "+pac.getSpeed()+

						"</description>\n" +

						"<Point>\n" +

						"<coordinates>"+pac.getP().y()+"^"+pac.getP().x()+"^"+pac.getP().z()+"</coordinates>" +

						"</Point>\n" +

						"</Placemark>\n";

				content.add(kmlelementp);

			}

			for(int j=0;j<g.getfruit().size();j++){

				Fruit fru = g.getfruit().get(j);

				String kmlelementF ="<Placemark>\n" +" <TimeStamp>\r\n" + 

							"<when>"+ dateFormat.format(cuurrentTime)+"Z</when>\r\n" + 

							"</TimeStamp>"+

							"<name>"+"Type: "+"Fruit"+"</name>\n" +

							"<description>"+"ID: "+fru.getId()+"Wieght:"+fru.getWeight()+

							"</description>\n" +

							"<Point>\n"+

							"<coordinates>"+fru.getP().y()+"^"+fru.getP().x()+"^"+fru.getP().z()+"</coordinates>" +

							"</Point>\n" +

							"</Placemark>\n";

				content.add(kmlelementF);

			}
			for (int i = 0; i <g.getPacman().size(); i++) {

				String kmlelementF="";
				Packman pac = g.getPacman().get(i);
				for (int j = 0; j < g.getPacman().get(i).getFruitEat().size(); j++) {
					 kmlelementF ="<Placemark>\n" +" <TimeStamp>\r\n" + 

							"<when>"+ dateFormat.format(cuurrentTime+g.getfruit().get(j).getMinTime())+"Z</when>\r\n" + 

							"</TimeStamp>"+

							"<name>"+"Type: "+"Fruit"+"</name>\n" +

							"<description>"+"ID: "+pac.getId()+", radius: "+pac.getRadius()+", Speed: "+pac.getSpeed()+

							"</description>\n" +

							"<Point>\n"+

							"<coordinates>"+g.getfruit().get(j).getP().y()+"^"+g.getfruit().get(j).getP().x()+"^"+g.getfruit().get(j).getP().z()+"</coordinates>" +

							"</Point>\n" +

							"</Placemark>\n";
				}
				content.add(kmlelementF);

			}	

			String end="</Folder>\n"+"</Document>\n"+"</kml>";
			content.add(end);
			String allKML=content.toString().replace("[", "").replace("]", "").replace(",","").replace("^", ",");

			bw.write(allKML);
			bw.close();
		}


		catch (IOException e) {

			e.printStackTrace();

		}

	}




}