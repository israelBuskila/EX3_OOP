package File_format;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Coords.Fruit;
import Coords.Packman;

public class Game {

	 ArrayList<Packman> pacman=new ArrayList<Packman>();
	ArrayList<Fruit> fruit=new ArrayList<Fruit>();

	public Game(){

		pacman=new ArrayList<Packman>();
		fruit=new ArrayList<Fruit>();
	}
	public Game(ArrayList<Packman> pack,ArrayList<Fruit> fru){

		this.pacman=new  ArrayList<Packman>(pack);
		this.fruit=new  ArrayList<Fruit>(fru);
		
	}
	public Game(Game g){

		this.pacman=new  ArrayList<Packman>(g.getPacman());
		this.fruit=new  ArrayList<Fruit>(g.getfruit());
		
	}
	public Game(String fileLocation){

		String line = "";
		String comma = ",";
		ArrayList<String[]> arr = new ArrayList<String[]>();
		Packman pack=new Packman();
		Fruit f=new Fruit();


		int i = 0;
		try (BufferedReader b = new BufferedReader(new FileReader(fileLocation))) 
		{
			while ((line = b.readLine()) != null) 
			{

				arr.add(i++, line.split(comma));
			}

			for(i=1;i<arr.size();i++)
			{
				if(arr.get(i)[0].equals("P"))
				{
					pack=new Packman(arr.get(i));

					pacman.add(pack);
				}
				if(arr.get(i)[0].equals("F"))
				{
					f=new Fruit(arr.get(i));

					fruit.add(f);
				}
			}
			

		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public ArrayList<Packman> getPacman() {
		return new ArrayList<Packman>(pacman);
	}
	public void setPacman(ArrayList<Packman> pacman) {
		this.pacman = pacman;
	}
	public ArrayList<Fruit> getfruit() {
		return fruit;
	}
	public void setfruit(ArrayList<Fruit> fruit) {
		this.fruit = fruit;
	}
	public static void main (String[] args) {
		String fileLocation = "C:\\Users\\moran\\Downloads\\pack.csv";
		Game g=new Game(fileLocation);
	}


}
