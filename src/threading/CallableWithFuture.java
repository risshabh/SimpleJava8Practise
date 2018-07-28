package threading;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableWithFuture {

	public static void main(String[] args) throws InterruptedException,ExecutionException {
		Callable<Integer> callable=new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Random generator=new Random();
				int number=generator.nextInt(10);
				return number;
			}
		};

		FutureTask<Integer>[] randomNumberTask=new FutureTask[5];
		for(int i=0;i<5;i++){
			randomNumberTask[i]=new FutureTask<>(callable);
			Thread th=new Thread(randomNumberTask[i]);
			th.start();
		}

		for (int i = 0; i < 5; i++)
		{
			System.out.println(randomNumberTask[i].get());
		}
	}

}
