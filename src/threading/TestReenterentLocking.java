package threading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class TestReenterentLocking {

	static final int MAX_T = 2;

	public static void main(String[] args) {
		ReentrantLock rel = new ReentrantLock();
		ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
		Runnable w1 = new Worker("Job1", rel);
		Runnable w2 = new Worker("Job2", rel);
		Runnable w3 = new Worker("Job3", rel);
		Runnable w4 = new Worker("Job4", rel);
		pool.execute(w1);
		pool.execute(w2);
		pool.execute(w3);
		pool.execute(w4);
		pool.shutdown();
	}
}

class Worker implements Runnable {
	String name;
	ReentrantLock re;

	public Worker(String name, ReentrantLock re) {
		this.name = name;
		this.re = re;
	}

	@Override
	public void run() {
		boolean done = false;
		while (!done) {
			// Getting outer Lock
			boolean ans = re.tryLock();
			// Return true if lock is free
			if (ans) {
				try {
					Date d = new Date();
					SimpleDateFormat df = new SimpleDateFormat("hh:mm:ss");
					System.out.println(
							"task name - " + name + " outer lock aquired at " + df.format(d) + " doing outer work");
					System.out.println("lock hold count in outer lock is " + re.getHoldCount());
					Thread.sleep(1500);

					// Getting inner lock
					re.lock();
					try {

						d = new Date();
						df = new SimpleDateFormat("hh:mm:ss");
						System.out.println(
								"task name - " + name + " inner lock aquired at " + df.format(d) + " doing outer work");
						System.out.println("lock hold count in inner lock is " + re.getHoldCount());
						Thread.sleep(1500);
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					} finally {
						System.out.println("task name - " + name + " releasing inner lock");
						re.unlock();
						System.out.println("Lock Hold Count - " + re.getHoldCount());
						System.out.println("task name - " + name + " work done");
						done = true;
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					// Outer lock release
					System.out.println("task name - " + name + " releasing outer lock");
					re.unlock();
					System.out.println("Lock Hold Count - " + re.getHoldCount());
				}
			} else {
				System.out.println("task name - " + name + " waiting for lock");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie1) {
					ie1.printStackTrace();
				}
			}
		}
	}

}
