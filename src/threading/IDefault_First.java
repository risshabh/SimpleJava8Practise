package threading;

public interface IDefault_First {

	void method1();

	default void log(String str){
		System.out.println("I1 logging::"+str);
	}
}
