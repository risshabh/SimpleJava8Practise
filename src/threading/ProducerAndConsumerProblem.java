package threading;

import java.util.Vector;

class Producer implements Runnable {

	private final Vector<Integer> sharedQueue;
	private final int queueSize;

	public Producer(Vector<Integer> queue,int size) {
		this.sharedQueue=queue;
		this.queueSize=size;
	}
	@Override
	public void run() {
		for(int i=0;i<7;i++){
			System.out.println("Producting "+i);
			try{
				produce(i);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}

	private void produce(int value) throws InterruptedException{
		while (sharedQueue.size()==queueSize){
			synchronized (sharedQueue) {
				System.out.println("Queue is full producer is not able to produce");
				sharedQueue.wait();
			}

		}
		synchronized (sharedQueue) {
			sharedQueue.add(value);
			sharedQueue.notifyAll();

		}
	}
}

class Consumer implements Runnable{
	private final Vector<Integer> sharedQueue;
	Consumer(Vector<Integer> queue,int size){
		this.sharedQueue=queue;
	}

	@Override
	public void run() {
		while(true){
			try{
				System.out.println("consumed "+Consume());
				Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}

	private int Consume() throws InterruptedException{
		while(sharedQueue.isEmpty())
		{
			System.out.println("Queue is empty consumer not able to consume and size is "+sharedQueue.size());
			synchronized(sharedQueue){
				sharedQueue.wait();
			}
		}

		synchronized (sharedQueue) {
			sharedQueue.notifyAll();
			return sharedQueue.remove(0);
		}
	}

}

/**
 * @author rishabh
 *
 */
public class ProducerAndConsumerProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<Integer> queue=new Vector<>();
		int Size=4;
		Thread prod=new Thread(new Producer(queue, Size));
		Thread cons=new Thread(new Consumer(queue, Size));
		prod.start();
		cons.start();
	}

}
