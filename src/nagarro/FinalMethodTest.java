package nagarro;

import java.util.Optional;

public class FinalMethodTest {

	static String name = "baeldung";
	static Optional<String> opt = Optional.of(name);

	public static void main(String[] args) {
		/*FinalMethodTest test=new FinalMethodTest();
		System.out.println("value from final method"+test.getValue());
		System.out.println("value from non final method"+test.valueFrom());*/

		System.out.println("value of option is :"+opt);
	}

}
