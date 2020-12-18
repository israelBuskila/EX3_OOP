package Threads;

import Geom.Path;

public class MyThread extends Thread {
//	private String _name;
//	private int _id;
//	private static int _count =0;
//	public MyThread(String name) {
//		super(name);
//		_name = name;
//		_id=_count;
//		_count++;
//	}
//	public String toString () {return ""+this._id+": "+this._name;}
//	/** this is the parallel thing */
//	
//	 public void run() {
//         for(int i=0;i<100;i++) {
//        	 System.out.println(i+") "+this.toString());
//         }
//     	System.out.println("done "+this.getName());
//     }
	
	Path p =new Path();
	
	public MyThread(Path newPath) {
		
		p=new Path(newPath);
		
	}

	public Path getP() {
		return new Path(p);
	}

	public void setP(Path n) {
		this.p =  new Path(n);
	}

	

	
}
