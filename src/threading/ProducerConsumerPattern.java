package threading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerPattern {

	static class Producer implements Runnable{

		private final BlockingQueue<Integer> sharedQueue; 
		public Producer(BlockingQueue<Integer> sharedQueue){
			this.sharedQueue=sharedQueue;
		}

		@Override
		public void run() {
			for(int i=0;i<10;i++){
				System.out.println("Producer is producting element"+i);
				try{
					sharedQueue.put(i);
				}
				catch(InterruptedException e){
					e.printStackTrace();
				}
			}

		}


	}

	static class Consumer implements Runnable{

		private final BlockingQueue<Integer> sharedQueue;

		public Consumer(BlockingQueue<Integer> sharedQueue){
			this.sharedQueue=sharedQueue;
		}
		@Override
		public void run() {
			while(true){
				try{
					System.out.println("consumer consume from sharedQueue"+sharedQueue.take());
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}


	}


	public static void main(String[] args) {
		BlockingQueue<Integer> sharedQueue=new LinkedBlockingQueue<Integer>();
		Thread prodThread = new Thread(new Producer(sharedQueue));
		Thread consThread = new Thread(new Consumer(sharedQueue));

		prodThread.start();
		consThread.start();
	}

}
