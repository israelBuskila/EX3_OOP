/**
 * 
 */
package GUI;
import java.awt.Color;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.junit.experimental.theories.Theories;

import Algorithm.ShortestPathAlgo;
import Coords.Fruit;
import Coords.Packman;
import File_format.Game;
import File_format.Path2KML;
import Geom.Path;
import Geom.Point3D;
//import sun.awt.windows.ThemeReader;
//import sun.swing.SwingUtilities2.RepaintListener;

/**
 * This Class is a graphical class that allows the robots and fruits to be displayed on the map,activity algorithms, data retention, 
 * and data recovery from csv files,creating a "game" by selecting robots and fruits and positioning them on the map. 
 * 
 * @author Israel and Moran
 *
 */

public class MainWindow extends JFrame implements MouseListener
{
	public BufferedImage myImage,cherryImg,packmanImg;
	MenuBar menuBar;
	Menu menu;

	MenuItem packmanI, fruitI;
	public ArrayList<Packman> packman=new ArrayList<Packman>();
	public ArrayList<Fruit> fruit=new ArrayList<Fruit>();
	String type="";
	int x = -1;
	int y = -1;
	int width=this.getWidth();
	int height=this.getHeight();
	ShortestPathAlgo SPA=new ShortestPathAlgo();


	/**
	 * get function for packman value
	 * @return packman
	 */
	public ArrayList<Packman> getPacman() {
		return packman;
	}
	/**
	 * set function for packman list update the list packman's to the value we get
	 * @param packman
	 */
	public void setPackman(ArrayList<Packman> packman) {
		this.packman = packman;
	}
	/**
	 * get function for fruit value
	 * @return fruit
	 */
	public ArrayList<Fruit> getfruit() {
		return fruit;
	}
	/**
	 * set function for fruit  update the path packman to the value we get
	 * @param packman
	 */
	public void setFruit(ArrayList<Fruit> fruit) {
		this.fruit = fruit;
	}

	//	public String getType() {
	//		return type;
	//	}
	/**
	 * set function for type update the type to the value we get
	 * @param packman
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * Constructor
	 */
	public MainWindow() 
	{
		initGUI();		
		this.addMouseListener(this); 

	}
	/**
	 * Build the menu for the frame
	 */
	private void initGUI() 
	{
		Menu menu = new Menu("Menu"); 
		Menu add = new Menu("Add");
		Menu clear = new Menu ("Clear");
		Menu run = new Menu ("Run");
		MenuItem addPackman = new MenuItem("Add Packman");
		MenuItem addFruit = new MenuItem("Add Fruit");
		MenuItem openCsv = new MenuItem("Open Csv");
		MenuItem saveAsKml = new MenuItem("Save As Kml");
		MenuItem saveAsCSV = new MenuItem("Save As CSV");
		MenuItem clearGame = new MenuItem("Clear Game");
		MenuItem play = new MenuItem("Play");



		MenuBar menuBar = new MenuBar();

		this.setMenuBar(menuBar);
		menuBar.add(menu);
		menuBar.add(add);
		menuBar.add(run);
		menuBar.add(clear);
		clear.add(clearGame);
		add.add(addPackman);
		add.add(addFruit);
		menu.add(openCsv);
		menu.add(saveAsKml);
		menu.add(saveAsCSV);
		run.add(play);



		try {
			myImage = ImageIO.read(new File("Ariel1.png"));
			cherryImg = ImageIO.read(new File("cherry.png"));
			packmanImg = ImageIO.read(new File("packman.png"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}



		addFruit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setType("fruit");
			}
		});

		addPackman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				setType("packman");
			}
		});

		clearGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				packman.removeAll(packman);
				fruit.removeAll(fruit);
				repaint();
				System.out.println("Board Clear");
			}
		});

		openCsv.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent actionEvent) {
				JFrame frame = new JFrame();
				JFileChooser chooser= new JFileChooser();
				chooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV file", "csv");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(frame);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose to open this file: " +
							chooser.getSelectedFile());
				}
				String NameFile=""+chooser.getSelectedFile();
				Game game=new Game(NameFile);
				convert(game.getPacman(),game.getfruit());
				packman.addAll(game.getPacman());
				fruit.addAll(game.getfruit());

				repaint();
			}
		});
		saveAsCSV.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent actionEvent) {
				String outputCSV="outputCSV";
				Game g =new Game(packman, fruit);

				try {
					SaveASCsv( outputCSV,g,getW(),getH() );
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				move();

			}
		});
	




		saveAsKml.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent actionEvent) {
				
				Game g=new Game(packman,fruit);
				Game g1=new Game(packman,fruit);
				//ShortestPathAlgo sh=new ShortestPathAlgo(g,getW(),getH());
				//Game CoordsGame=GUI.Map.PixelToCoords(sh, width, height);
				convertToCoords(g1.getPacman(),g1.getfruit());
				//sh.setG(CoordsGame);
				Path2KML kml=new Path2KML();
				kml.writeToKML(width, height,g1, "outputKML");
				
				
			}
		});

	}

	/**
	 * This function is responsible for the movement of the packmans in the frame.
	 */
	public void move()
	{
		int n=0;
		Game g=new Game(packman,fruit);
		ShortestPathAlgo sh=new ShortestPathAlgo(g,getW(),getH());
		ArrayList<Path> waze=new ArrayList<Path>(sh.getPaths());
		for (int i = 0; i < waze.size(); i++) {
		ThreadsClass tr = new ThreadsClass(waze.get(i).getPath(),this,n);
		tr.start();
		n++;
		}

	}
	/**
	 * Saving as CSV file
	 * @param outputCSV
	 * @param game
	 * @param width
	 * @param height
	 * @throws IOException
	 */
	public static void SaveASCsv(String outputCSV,Game game,int width,int height) throws IOException {

		FileWriter pw = new FileWriter(outputCSV+".csv", true);

		StringBuilder sb = new StringBuilder();

		sb.append("Type");
		sb.append(',');
		sb.append("Id");
		sb.append(',');
		sb.append("Lat");
		sb.append(',');
		sb.append("Lon");
		sb.append(',');
		sb.append("Alt");
		sb.append(',');
		sb.append("Speed/Weight");
		sb.append(',');
		sb.append("Radius");
		sb.append(',');
		sb.append(game.getPacman().size());
		sb.append(',');
		sb.append(game.getfruit().size());
		sb.append('\n');


		Point3D coords =new Point3D(0,0,0);

		for(int i=0;i<game.getPacman().size();i++) {

			coords=GUI.Map.PixelToCoords(width, height, game.getPacman().get(i).getP().x(), game.getPacman().get(i).getP().y());
			sb.append("P");
			sb.append(',');
			sb.append(game.getPacman().get(i).getId());
			sb.append(',');
			sb.append(coords.x());
			sb.append(',');
			sb.append(coords.y());
			sb.append(',');
			sb.append(game.getPacman().get(i).getP().z());
			sb.append(',');
			sb.append(game.getPacman().get(i).getSpeed());
			sb.append(',');
			sb.append(game.getPacman().get(i).getRadius());
			sb.append('\n');

		}

		for(int i=0;i<game.getfruit().size();i++) {

			coords=GUI.Map.PixelToCoords(width, height, game.getfruit().get(i).getP().x(), game.getfruit().get(i).getP().y());
			sb.append("F");
			sb.append(',');
			sb.append(game.getfruit().get(i).getId());
			sb.append(',');
			sb.append(coords.x());
			sb.append(',');
			sb.append(coords.y());
			sb.append(',');
			sb.append(game.getfruit().get(i).getP().z());
			sb.append(',');
			sb.append(game.getfruit().get(i).getWeight());
			sb.append('\n');
		}

		pw.write(sb.toString());
		pw.flush();
		pw.close();

		System.out.println("done!");

	}
	public class ThreadsClass extends Thread {

		private ArrayList <Point3D> waze;
		private MainWindow windows = new MainWindow();
		int n=0;

		public ThreadsClass(ArrayList<Point3D> waze,MainWindow windows, int n) {
			this.waze = waze;
			this.windows = windows;
			this.n=n;
		}

		@Override
		public void run() {
			for (int i = 0; i < waze.size(); i++) {
				Point3D p = new Point3D (waze.get(i));
				this.windows.getPacman().get(n).setP(p);
				this.windows.repaint();
				try {
					sleep(50); //pick anytime you want
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}


	/**
	 * return the width of the frame
	 * @return this.getWidth()
	 */
	public int getW()
	{
		return this.getWidth();
	}
	/**
	 * return the height of the frame
	 * @return this.getHeight()
	 */
	public int getH()
	{
		return this.getHeight();
	}
	/**
	 * This function is convert the list of the pacman and fruit to pixel (from coords)
	 * @param p
	 * @param f
	 */
	public void convert(ArrayList<Packman> p,ArrayList<Fruit>f)
	{

		for (int i = 0; i < p.size(); i++) {
			p.get(i).setP(GUI.Map.coordsToPixel(this.getWidth(),this.getHeight(),p.get(i).getP().x(),p.get(i).getP().y()));
		}

		for (int i = 0; i < f.size(); i++) {
			f.get(i).setP(GUI.Map.coordsToPixel(this.getWidth(),this.getHeight(),f.get(i).getP().x(),f.get(i).getP().y()));
		}
	}
	public void convertToCoords(ArrayList<Packman> p,ArrayList<Fruit>f)
	{

		for (int i = 0; i < p.size(); i++) {
			p.get(i).setP(GUI.Map.PixelToCoords(this.getWidth(),this.getHeight(),p.get(i).getP().x(),p.get(i).getP().y()));
		}

		for (int i = 0; i < f.size(); i++) {
			f.get(i).setP(GUI.Map.PixelToCoords(this.getWidth(),this.getHeight(),f.get(i).getP().x(),f.get(i).getP().y()));
		}
	}
	/**
	 * This function in painting the image of the pacman and fruit on the screen
	 * @param g
	 */

	public void paint(Graphics g)
	{

		int w = this.getWidth();
		int h = this.getHeight();
		g.drawImage(myImage,0, 0, w, h, this);


		for(int i=0;i<packman.size();i++)
		{
			int r = 35;
			x = (int) (packman.get(i).getP().ix() - (r / 2));
			y = (int) (packman.get(i).getP().iy() - (r / 2));
			g.drawImage(packmanImg,x, y, r, r, this);


		}
		for(int i=0;i<fruit.size();i++)
		{
			int r = 40;
			x = (int) (fruit.get(i).getP().ix() - (r / 2));
			y = (int) (fruit.get(i).getP().iy() - (r / 2));
			g.drawImage(cherryImg,x, y, r, r, this);


		}

	}

	@Override
	public void mouseClicked(MouseEvent arg) {
		System.out.println("mouse Clicked");
		System.out.println("("+ arg.getX() + "," + arg.getY() +")");

		double xn = arg.getX();
		double yn = arg.getY();
		Map m=new Map();
		//System.out.println(m.PixelToCoords(this.getWidth(), this.getHeight(), xn, yn));;
		x = arg.getX();
		y = arg.getY();
		Point3D point = new Point3D(x, y);
		Packman pack=new Packman();
		Fruit f=new Fruit();
		double s=1,r=1;

		if(type.equals("packman"))
		{

			pack= new Packman(packman.size(), point, s, r);
			this.packman.add(pack);
		}
		if(type.equals("fruit"))
		{
			f=new Fruit(point,fruit.size(),s);
			this.fruit.add(f);
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		//System.out.println("mouse entered");

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}






}

