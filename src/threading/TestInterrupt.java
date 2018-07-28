package threading;

public class TestInterrupt implements Runnable {

	@Override
	public void run() {
		try{
			System.out.println("Child thread exceute");
			for(int i=0;i<=7;i++){
				System.out.println("values"+i);
				this.wait(1000);
			}	
		}catch(Exception e){
			e.printStackTrace();
		}


	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			TestInterrupt thread=new TestInterrupt();
			Thread th1=new Thread(thread);
			Thread th2=new Thread(thread);
			th1.start();
			th1.setPriority(15);
			th2.start();
			System.out.println("Main thread is excuted completed");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
