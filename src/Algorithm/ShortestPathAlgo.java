package Algorithm;




import java.util.ArrayList;


import Coords.Fruit;
import Coords.MyCoords;
import Coords.Packman;
import File_format.Game;
import GUI.Map;
import Geom.Path;
import Geom.Point3D;
import Threads.MyThread;
/**
 *this class is for create the paths for the packmans with the short way it possible to the fruit on the screen.	
 * @author Israel & Moran.
 *
 */
public class ShortestPathAlgo {

	/**
	 * constructor
	 */
	Game g;
	private double time;
	ArrayList<MyThread> th=new ArrayList<MyThread>();

	public ArrayList<Path> paths = new ArrayList<Path>();

	/**
	 * Copy constructor
	 * * @param game
	 *   @param mapWidth
	 *   @param mapHeight
	 */
	public ShortestPathAlgo()
	{
		this.g=new Game();
		this.time=0;
		this.th=new ArrayList<MyThread>();
	}

	public ShortestPathAlgo(Game game,int mapWidth, int mapHeight)
	{
		this.g=new Game(game);
		getPaths(mapWidth, mapHeight);

	}

	/**
	 *  This function receives  mapWidth, mapHeight and create the paths for each packmans int the screen to the fruits
	 *   @param mapWidth
	 *   @param mapHeight
	 */
	public void getPaths(int mapWidth, int mapHeight) {

		int iPack = -1;
		for (int i = 0; i < g.getfruit().size(); i++) {
			iPack = findClosesPack(g.getfruit().get(i));
			for (int j = 0; j < g.getPacman().size(); j++) {
				paths.add(new Path());
			}
			createPath( mapWidth, mapHeight,g.getPacman().get(iPack),g.getfruit().get(i),iPack);
		}

	}
	public ArrayList<MyThread> getTh() {
		return new ArrayList<MyThread>(th);
	}

	public void setTh(ArrayList<MyThread> th) {
		this.th = th;
	}

	/**
	 *  This function receives  mapWidth, mapHeight ,packman and his place and fruit 
	 *  and create the path for each packman received to the fruits that closes to him.
	 *   @param mapWidth
	 *   @param mapHeight
	 *   @param pack
	 *   @param fruit
	 *   @param packI
	 */
	public Path createPath(int mapWidth, int mapHeight,Packman pack, Fruit fruit,int packI) {
		//Point3D p1 = new Point3D(fruit.getP());
		Map map = new Map();
		MyCoords m = new MyCoords();

		//Path packP = new Path();
		//packP.getPath().add(pack.getP());
		Point3D pP = new Point3D(map.PixelToCoords(mapWidth, mapHeight, pack.getP().x(), pack.getP().y()));
		Point3D pF = new Point3D(map.PixelToCoords(mapWidth, mapHeight, fruit.getP().x(), fruit.getP().y()));
		double distance = m.distance3d(pP, pF);
		//ArrayList<Point3D> d=new ArrayList<Point3D>();

		double count = 0;

		//
		Point3D toPixel=new Point3D(0,0,0);
		while(count <= (distance-pack.getRadius())) {
			
			if(pP.x()<pF.x()&&pP.y()<pF.y()) {
			Point3D v = new Point3D(pack.Speed, pack.Speed);
			toPixel = new Point3D(m.add(pP, v));
			}
			else
			{
				if(pP.x()>pF.x()&&pP.y()>pF.y()) {
					Point3D v = new Point3D(-pack.Speed, -pack.Speed);
					toPixel = new Point3D(m.add(pP, v));
				}
					else
					{
						if(pP.x()<pF.x()&&pP.y()>pF.y()) {
							Point3D v = new Point3D(pack.Speed, -pack.Speed);
							toPixel = new Point3D(m.add(pP, v));
						}
						else
						{
							Point3D v = new Point3D(-pack.Speed, pack.Speed);
							toPixel = new Point3D(m.add(pP, v));
						}
					}
			}
			toPixel = map.coordsToPixel(mapWidth, mapHeight, toPixel.x(), toPixel.y());
			pack.setP(toPixel);

			paths.get(packI).getPath().add(toPixel);

			//d.add(toPixel);
			
			pP = new Point3D(map.PixelToCoords(mapWidth, mapHeight, toPixel.x(),toPixel.y()));
			System.out.println(pP);
			count  = count + pack.Speed;
		}


		//packP.setPath( d);

		pack.setGrade(fruit.getWeight()+pack.getGrade());
		//g.getfruit().remove(fruit);
		return paths.get(packI);

	}

	/**
	 * get function for game value
	 * @return g
	 */
	public Game getG() {
		return g;
	}

	/**
	 * set function for game value update the value g to the value we get
	 * @param g
	 */
	public void setG(Game g) {
		this.g = g;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	/**
	 * get function for paths value
	 * @return paths
	 */
	public ArrayList<Path> getPaths() {
		return paths;
	}

	/**
	 * set function for paths value update the value paths to the value we get
	 * @param paths
	 */
	public void setPaths(ArrayList<Path> paths) {
		this.paths = paths;
	}

	/**
	 * the function get a fruit and check who is the closes packman by distance to him retrun his index.
	 * @param fruit
	 * @return minI
	 */
	public int findClosesPack(Fruit fruit)
	{
		//Iterator<Packman> itPack=this.g.getPacman().iterator();
		Packman closesP=new Packman();
		closesP=this.g.getPacman().get(0);
		double minTime=0;
		Packman tempPack=new Packman();
		int minI=0;
		if(this.g.getPacman().isEmpty()==true)
			return -1;
		else
		{

			minTime=fruit.getP().distance3D(closesP.getP())/closesP.getSpeed();
			double tempMin=0;
			for (int i = 1; i < this.g.getPacman().size(); i++)
			{
				tempPack=this.g.getPacman().get(i);
				tempMin=fruit.getP().distance3D(tempPack.getP())/tempPack.getSpeed();

				if(tempMin<minTime)
				{
					minTime=tempMin;
					closesP=tempPack;
					minI=i;
				}
			}
			return minI;
		}
	}

}
