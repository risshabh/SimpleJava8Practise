package threading;

import java.util.LinkedList;
import java.util.List;

public class PCProblemUsingLinkList {

	public static void main(String[] args) throws InterruptedException {
		final PC pc =new PC();
		Thread th1=new Thread(new Runnable() {

			@Override
			public void run() {
				try{
					pc.produce();
				}catch(InterruptedException ex){
					ex.printStackTrace();
				}
			}
		});

		Thread th2=new Thread(new Runnable() {

			@Override
			public void run() {
				try{
					pc.consumer();
				}catch(InterruptedException ex){
					ex.printStackTrace();
				}

			}
		});

		th1.start();
		th2.start();

		th1.join();
		th2.join();
	}

	public static class PC{
		List<Integer> list=new LinkedList<>();
		int capacity=4;

		public void produce() throws InterruptedException{
			int value=0;
			while(true){
				synchronized (this) {
					while(list.size()==capacity) {
						wait();
					}
					System.out.println("producer produce "+ value);
					list.add(value++);
					notify();
					Thread.sleep(1000);
				}
			}
		}

		public void consumer() throws InterruptedException{
			while(true){
				synchronized (this) {
					while(list.size()==0){
						wait();
					}
					System.out.println("Consumer consuming" +list.remove(0));
					notify();
					Thread.sleep(1000);
				}
			}
		}
	}
}



