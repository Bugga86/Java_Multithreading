package multithreading;

import java.util.concurrent.locks.ReentrantLock;

public class lock_demo {
	public static int counter = 0;
//	public static synchronized void incrementor(){
	public static void incrementor(){
		
		lock.lock();
		try{
		for(int i =0;i<10000;i++)			
		counter++;
		} finally{
		lock.unlock();}
	}
	public static ReentrantLock lock = new ReentrantLock();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				incrementor();
				
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				incrementor();
				
			}
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(counter);
		
	}

}
