package collectionPractises;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.stream.IntStream;

public class CollectionVerison5 {


	/**
	 * {@link Future}
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> str=Arrays.asList("sfkls","lklkjs","wellsfjs","uolabnskf","afsbkkf","xpskfna");
		System.out.println("B4 shorting "+str);
		/*Collections.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});*/

		//Using lambda
		Collections.sort(str, (a,b) -> a.compareTo(b));
		//FunctionalInterfaceTest<Integer, String> converter=(abc) -> Integer.valueOf(abc);
		FunctionalInterfaceTest<Integer, String> converter=Integer::valueOf;
		Integer in=converter.convert("123");
		System.out.println("After sorting "+str);
		ExecutorService service=new ScheduledThreadPoolExecutor(5);
		IntStream intS=IntStream.of(1,2,3,4);
		IntSummaryStatistics inSS=intS.summaryStatistics();
		PersonFactory<PersonBean> personFactory=PersonBean::new;
		LocalDateTime.of
		//PersonBean pBean=personFactory.create("Rishabh", "Agarwal");
	}

}
