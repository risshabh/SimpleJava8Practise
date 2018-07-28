package nagarro;

public class SubSetProblem {

	static void findNumbers(int[] list, int index, int current, int goal, String result)
	{ 
		if (list.length < index || current>goal) {
			return;
		}
		for (int i = index; i < list.length; i++) {
			if (current + list[i] == goal)   {
				System.out.println(result + " " + list[i]);
			}
			else if (current + list[i] < goal) {
				findNumbers(list, i + 1, current + list[i], goal, result + " " + list[i]);
			}
		}
	}
	public static void main(String... arr)
	{

	}
}
