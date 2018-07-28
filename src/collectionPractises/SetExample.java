package collectionPractises;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Generic<T>{
	public T obj;
	public Generic(T ob){
		this.obj=obj;
	}
}

public class SetExample {
	public static final ThreadLocal<T>

	public static void main(String[] args) {
		Set set=new HashSet();
		/*	Generic<String> s1=new Generic("String");
		Object s2=new Generic("232");
		Object s3=new Generic<String>("4243");
				set.add(new Person());*/
		set.add(new Person("rishabh"));
		set.add(new Person("rishabh"));
		set.add("safsafd");
		set.add("safsafd");
		Iterator safsafditr=set.iterator();
		/*while(itr.hasNext()){
			System.out.println("set valus is "+itr.next());
		}*/

		System.out.println(set);
		short s=6;
		System.out.println(add(s,8));
	}

	static int add(int a,int b){
		return a+b;
	}

}

class Person{
	String name;


	public Person() {
		super();
	}
	public Person(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return this.name;
	}



}
