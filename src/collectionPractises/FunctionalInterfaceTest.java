package collectionPractises;

@FunctionalInterface
public interface FunctionalInterfaceTest<T,F> {
	//int add(int a, int b);
	T convert(F params);
	//int add(int a, int b, int c);

	default int adds(int a, int b) {
		return (a + b);
	}

}
