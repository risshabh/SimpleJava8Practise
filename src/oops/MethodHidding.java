package oops;

import java.util.LinkedList;
import java.util.Map.Entry;

class A{
	public static void add(){
		System.out.println("ADD in A");
	}
}
public class MethodHidding extends A {
	public static void add(){
		System.err.println("ADD in MethodHidding");
	}
	public static void main(String[] args) {
		A a=new A();
		A b=new MethodHidding();
		b.add();
		Entry<K, V> 
	}

}
