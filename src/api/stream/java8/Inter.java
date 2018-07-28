package api.stream.java8;

public class Inter {

	public static<T> int count(T[] array, T item) {
		int count = 0;

		if (item == null) {
			for (T element : array) {
				if (element == null)
					count++;
			}
		} else {
			for (T element : array) {
				if (item.equals(element)) {
					count++;
				}
			}
		}

		return count;

	}

	public static void main(String... arr) {
		Integer[] integers = { 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 0 };
		int count = Inter.count(integers, 1);
		System.out.println(integers);
	}

}
