package threading;

import java.util.TreeSet;

public class Treeset
{
	public static void main(String[] args)
	{
		TreeSet<String> treeSet = new TreeSet<>();

		treeSet.add("ab");
		treeSet.add("Geeks");
		treeSet.add("feeks");
		treeSet.add("Geeks");
		treeSet.add("GeeksforGeeks");

		for (String temp : treeSet) {
			System.out.printf(temp + " ");
		}

		System.out.println("\n");
	}
}
