package Threads;

import java.util.ArrayList;

import Algorithm.ShortestPathAlgo;
import Coords.Fruit;
import Coords.Packman;

public class TestThreads {
//	public static void main(String[] a) {
//		MyThread t0 = new MyThread("a");
//		MyThread t1 = new MyThread("b");
//	//	t0.run();
//	//	t1.run();
//		t0.start();
//		t1.start();
//		System.out.println("done main");
//	}
	
	ArrayList<MyThread> th=new ArrayList<MyThread>();

	public TestThreads(ShortestPathAlgo s)
	{
		// th=new ArrayList<MyThread>(s.getTh());
	
		 for (int i = 0; i <th.size(); i++) {
			
			 th.get(i).start();
		
		 }
	}
	
	public ArrayList<MyThread> getTh() {
		return th;
	}

	public void setTh(ArrayList<MyThread> th) {
		this.th = th;
	}
	
	
	
}
