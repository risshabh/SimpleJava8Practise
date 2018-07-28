package threading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo  {

	static class Party implements Runnable{
		private final String name;
		private final int delay;
		private final CyclicBarrier barrier;

		Party(String name,int delay,CyclicBarrier barrier){
			this.name=name;
			this.delay=delay;
			this.barrier=barrier;
		}

		@Override
		public void run() {
			try{
				Thread.sleep(delay);
				System.out.println(Thread.currentThread().getName()+" is calling await");
				barrier.await();
				System.out.println(Thread.currentThread().getName()+" is start running");
			}catch(InterruptedException|BrokenBarrierException e){ 
				e.printStackTrace();
			}
		}



	}


	public static void main(String[] args) throws InterruptedException,BrokenBarrierException {
		CyclicBarrier barrier=new CyclicBarrier(4);
		Thread th1=new Thread(new Party("party-1",1000, barrier));
		Thread th2=new Thread(new Party("party-2",1000, barrier));
		Thread th3=new Thread(new Party("party-3",1000, barrier));
		Thread th4=new Thread(new Party("party-4",1000, barrier));

		th1.start();
		th2.start();
		th3.start();
		th4.start();

		System.out.println(Thread.currentThread().getName() + " has finished");		
	}

}
