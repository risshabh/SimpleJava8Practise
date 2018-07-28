package threading;

public class DefaultMethodImplementation implements IDefault_Third {

	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}

	public static void main(String args[]){
		DefaultMethodImplementation obj = new DefaultMethodImplementation();
		obj.print("");
		obj.isNull("abc");
	}


}
