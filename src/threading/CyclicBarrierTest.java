package threading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
	private CyclicBarrier barrier;
	private List<List<Integer>> partialResults = Collections.synchronizedList(new ArrayList<>());
	private Random random = new Random();
	private int NUM_PARTIAL_RESULTS;
	private int NUM_WORKERS;

	class NumberCruncherThread implements Runnable {
		@Override
		public void run() {
			String threadName = Thread.currentThread().getName();
			List<Integer> partialResult = new ArrayList<>();
			for (int i = 0; i < NUM_PARTIAL_RESULTS; i++) {
				Integer num = random.nextInt(10);
				System.out.println(threadName + " :crunhing some number!Final result- " + num);
				partialResult.add(num);
			}
			partialResults.add(partialResult);
			try {
				System.out.println(threadName + " is waiting for others to reach barrior");
				barrier.await();
			} catch (BrokenBarrierException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	class AggregatedResult implements Runnable {

		@Override
		public void run() {
			String thisThreadName = Thread.currentThread().getName();
			System.out.println(thisThreadName + " :computing sum of " + NUM_WORKERS + " worker,having"
					+ NUM_PARTIAL_RESULTS + " results each");
			int sum = 0;
			for (List<Integer> threadResult : partialResults) {
				System.out.print("Adding ");
				for (Integer partialResult : threadResult) {
					System.out.print(partialResult + " ");
					sum += partialResult;
				}
				System.out.println();
			}
			System.out.println(thisThreadName + ": Final Result" + sum);
		}
	}

	public void runSimulator(int workerThread, int noOfPartialResult) {
		NUM_WORKERS = workerThread;
		NUM_PARTIAL_RESULTS = noOfPartialResult;
		barrier = new CyclicBarrier(NUM_WORKERS, new AggregatedResult());
		System.out.println("Spawning " + NUM_WORKERS + " worker threads to compute " + NUM_PARTIAL_RESULTS
				+ " partial results each");

		for (int i = 0; i < NUM_WORKERS; i++) {
			Thread worker = new Thread(new NumberCruncherThread());
			worker.setName("Thread " + i);
			worker.start();
		}
	}

	public static void main(String[] args) {
		CyclicBarrierTest demo = new CyclicBarrierTest();
		demo.runSimulator(5, 3);
	}
}
