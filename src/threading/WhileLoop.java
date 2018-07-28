package threading;

public class WhileLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean status=true;
		int counter=1;
		while(true){
			counter++;
			System.out.println("counter value is "+counter);
			if(counter==100){
				break;
			}
			System.out.println("counter value outside while loop is "+counter);
		}

	}

}
