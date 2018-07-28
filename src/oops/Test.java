package oops;

class Test 
{
	public static void main(String[] args)
	{
		String str = "geeks";
		str=str.toUpperCase();
		System.out.println(str);
		str += "forgeeks";
		String string = str.substring(2,13);
		string = string + str.charAt(4);;
		System.out.println(string);
		System.out.println("'Tisha'");
	}
}
