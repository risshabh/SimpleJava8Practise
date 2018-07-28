package threading;

import java.util.Vector;

/**
 * 
 * @author rishabh
 *
 */
public class VectorSize {

	/**
	 * 
	 * @param args String array
	 */
	public static void main(String[] args) {
		Vector<Integer> v=new Vector<Integer>();
		for(int i=0;i<6;i++) {
			v.add(i);
		}
		System.out.println("collection size is "+v.size());
	}

}
