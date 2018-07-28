package api.stream.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NowJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> line=Arrays.asList("Rishabh","Akash","Anurag");
		//Using filter of stream api
		List<String> result=line.stream().filter(lines -> !"Rishabh".equals(line))
				.collect(Collectors.toList());
		result.forEach(System.out::println);
		List<String> capital=line.stream().map(String::toUpperCase).collect(Collectors.toList());
	//	capital.forEach(System.out::println);
		
		//Group By List Fumctionality
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("Highest number in List : " + stats.getMax());
		System.out.println("Lowest number in List : " + stats.getMin());
		System.out.println("Sum of all numbers : " + stats.getSum());
		System.out.println("Average of all numbers : " + stats.getAverage());
		
	}

}
