package Algorithm;

import java.io.File;


import java.util.ArrayList;

import File_format.Csv2Kml;
import File_format.WriteFileKML;
import GIS.MyGIS_project;

/**
 * This class receives a folder address
This class represents the conversion of all the .kml files in the folder into a layer group
 * @author Israel-PC
 *
 */
public class MultiCSV {



	public   ArrayList<String> filenames = new ArrayList<>();
	public MyGIS_project project = new MyGIS_project();


	/**
	 * constructor
	 */
	public MultiCSV() {
		filenames = new ArrayList<String>();
		project = new MyGIS_project();

	}
	/**
	 *  This function receives a folder address
1. Passes it recursively.
2. Scans all existing cvs files.
3. Converts them to a layer collection.
	 * @param File folder
	 * @return project
	 */
	public  MyGIS_project listFilesForFolder(final File folder) {

		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {

				listFilesForFolder(fileEntry);
			} else {
				if(fileEntry.getName().contains(".csv")) 
					filenames.add(fileEntry.getPath());


			}
		}
		for (int i = 0; i < filenames.size(); i++) {
			Csv2Kml s = new Csv2Kml();
			project.add(s.writeFile(filenames.get(i)));
			System.out.println(filenames.get(i));
		}
		WriteFileKML.writeFileKMLPro(this.project);
		return this.project;

	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final File folder = new File("C:\\Users\\moran\\Downloads\\try");
		MultiCSV m = new MultiCSV();
		m.listFilesForFolder(folder);

	}

}
