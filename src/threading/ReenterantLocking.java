package threading;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterantLocking {

	private static class Worker implements Runnable
	{
		private final ReentrantLock renLoc=new ReentrantLock();
		@Override
		public void run() {
			renLoc.lock();
			try{
				System.out.println(Thread.currentThread().getName() + " - 1");
				System.out.println(Thread.currentThread().getName() + " - 2");
				System.out.println(Thread.currentThread().getName() + " - 3");
			}
			catch(Exception e)
			{}
			finally{
				renLoc.unlock();
			}

		}

	}


	public static void main(String[] args) {
		Worker worker=new Worker();
		Thread th1=new Thread(worker,"Thread-1");
		Thread th2=new Thread(worker,"Thread-2");
		th1.start();
		th2.start();
	}

}
