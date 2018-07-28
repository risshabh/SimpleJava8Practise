package threading;

public interface IDefault_Second {

	void method2();

	default void log(String str){
		System.out.println("I2 logging::"+str);
	}
}


