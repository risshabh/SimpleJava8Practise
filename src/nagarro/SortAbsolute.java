package nagarro;

/**
 * 
 * @author rishabh
 *
 */

public class SortAbsolute {

	public static void main(String... ar){
		int[] arr = {-8,-5,-3,-1,3,6,-9 };
		usingCountingSort(arr);
		usingInsertionSort(arr);
	}
	private static void usingInsertionSort(int[] arr){
		
	}
	private static void usingCountingSort(int[] arr){
		int max=0;//absolute max
		int[] b=new int[arr.length];
		for(int a:arr)
		{
			if(max*max<a*a)
				max=a;
		}
		if(max<=0)
		{
			max=-max;
		}
		System.out.println("max"+max);
		int c[]=new int[max+1];
		for(int a:arr){
			if(a>=0)
				c[a]=c[a]+1;
			else
				c[-a]=c[-a]+1;
		}
		//Step 1 over
		for(int i:c)
		{
			System.out.print(i+",");
			System.out.println(" --");
		}
		for(int i=1;i<max;i++)
		{
			c[i]=c[i-1]=c[i];
		}
		//step2 over
		for(int i:c)
		{
			System.out.print(i+",");
			System.out.println(" --");
		}
		for (int i = arr.length - 1; i >= 0; i--) 
		{
			   if (arr[i] >= 0) {
			    b[c[arr[i]] - 1] = arr[i];
			    c[arr[i]]--;
			   } else {

			    b[c[-arr[i]] - 1] = arr[i];
			    c[-arr[i]]--;
			   }

		}

			  for (int i : b)
			   System.out.print(i + ",");
			  System.out.println("-- complexity O(n)");
	}
}

