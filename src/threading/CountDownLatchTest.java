package threading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		CountDownLatchTest test=new CountDownLatchTest();
		CountDownLatch latch=new CountDownLatch(4);
		Worker worker1=test.new Worker(1000, latch);
		Worker worker2=test.new Worker(2000, latch);
		Worker worker3=test.new Worker(3000, latch);
		Worker worker4=test.new Worker(4000, latch);

		Thread th1=new Thread(worker1,"Thread-1");
		Thread th2=new Thread(worker2,"Thread-2");
		Thread th3=new Thread(worker3,"Thread-3");
		Thread th4=new Thread(worker4,"Thread-4");

		th1.start();
		th2.start();
		th3.start();
		th4.start();
		try{
			latch.await();
			// Main thread has started
			System.out.println(Thread.currentThread().getName() +
					" has finished");
		}catch(InterruptedException e){
			e.printStackTrace();
		}

	}

	class Worker implements Runnable{
		private int delay;
		private CountDownLatch latch;

		public Worker(int delay, CountDownLatch latch) {
			this.delay = delay;
			this.latch = latch;
		}

		@Override
		public void run() {
			try{
				Thread.sleep(delay);
				latch.countDown();
				System.out.println(Thread.currentThread().getName()+ " finished");
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}



	}
}
