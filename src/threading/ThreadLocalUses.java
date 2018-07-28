package threading;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalUses implements Runnable {

	/*private static final ThreadLocal<SimpleDateFormat> formatter=new ThreadLocal<SimpleDateFormat>(){

		@Override
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd HHmm");
		}

	};*/
	private static final ThreadLocal<SimpleDateFormat> formatter=ThreadLocal.withInitial(()->{return new SimpleDateFormat("yyyyMMdd HHmm");});


	@Override
	public void run() {
		System.out.println("Thread name is "+Thread.currentThread().getName()+
				" default formatter = "+formatter.get().toPattern());
		try{
			Thread.sleep(new Random().nextInt(1000));
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		formatter.set(new SimpleDateFormat());
		System.out.println("Thread name is "+Thread.currentThread().getName()+
				" updated formatter = "+formatter.get().toPattern());
	}

	public static void main(String...arr) throws InterruptedException{
		ThreadLocalUses obj=new ThreadLocalUses();
		for(int i=0;i<10;i++){
			Thread th=new Thread(obj,""+i);
			Thread.sleep(new Random().nextInt(1000));
			th.start();
		}
	}

}
