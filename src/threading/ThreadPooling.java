package threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPooling implements Runnable {

	private String name;
	ThreadPooling(String name){
		this.name=name;
	}

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"");
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ExecutorService service=Executors.newFixedThreadPool(5);
		for(int i=0;i<10;i++){
			ThreadPooling th1=new ThreadPooling(""+i);
			service.execute(th1);
		}
		service.shutdown();
	}

}
