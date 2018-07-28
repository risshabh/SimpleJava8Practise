package threading;

public class DeadLock {

	public static void main(String[] args) throws InterruptedException {
		Thread th1=new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (String.class) {
					try{
						System.out.println("thread one locked String Obj");
						Thread.sleep(6000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				System.out.println("thread one Acquire lock on another resource Integer Object");
				synchronized (String.class) {
					try{
						System.out.println("thread one locking String Obj");
						Thread.sleep(6000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});

		Thread th2=new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (Integer.class) {
					try{
						System.out.println("thread two locked Integer Obj");
						Thread.sleep(6000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
				System.out.println("thread two Acquire lock on another resource String Object");
				synchronized (String.class) {
					try{
						System.out.println("thread two locking String Obj");
						Thread.sleep(6000);
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		});

		th1.start();
		th2.start();
	}
}
