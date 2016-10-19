package hackerrank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedSortedLinkedListDriver {
	private static final int WORKER_THREADS = 20;
	ExecutorService threadPool = Executors.newFixedThreadPool(WORKER_THREADS);
	MultiThreadedSortedLinkedList linkedList = new MultiThreadedSortedLinkedList();

	public static void main(String[] args) {
		MultiThreadedSortedLinkedListDriver driver = new MultiThreadedSortedLinkedListDriver();
		driver.linkedList.init();

		for (int i = 0; i < 10000; i++) {
			driver.threadPool.execute(new Runnable() {

				@Override
				public void run() {
					try {
						Thread.sleep((long) (java.lang.Math.random() * 10));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					driver.linkedList.insert((int) (java.lang.Math.random() * 10000));
				}
			});
		}
		driver.threadPool.execute(new Runnable() {
			@Override
			public void run() {
				driver.linkedList.validate();
			}
		});

	}
}
