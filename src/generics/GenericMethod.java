package generics;

import java.util.Stack;

public class GenericMethod {

	<T> void add(T a,T b){ 
		System.out.println("Sum is "+a+b);
	}

	public static void main(String[] args) {
		GenericMethod obj=new GenericMethod();
		obj.add(1.1, 2.5);
	}

}
