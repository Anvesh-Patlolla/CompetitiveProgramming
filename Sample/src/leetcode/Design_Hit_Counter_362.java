package leetcode;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Design_Hit_Counter_362 {
	Queue<Integer> queue = null;
	// AtomicInteger min, max;

	/** Initialize your data structure here. */
	public Design_Hit_Counter_362() {
		queue = new ConcurrentLinkedDeque<>();
		// min = new AtomicInteger(0);
		// max = new AtomicInteger(0);
	}

	/**
	 * Record a hit.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		queue.offer(timestamp);
		// max.set(timestamp);
		int minimum = timestamp - 300;
		for (int i = 0; !queue.isEmpty() && queue.peek() <= minimum; i++) {
			queue.poll();
		}

	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 * 
	 * @param timestamp
	 *            - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		int minimum = timestamp - 300;
		for (int i = 0; !queue.isEmpty() && queue.peek() <= minimum; i++) {
			queue.poll();
		}
		System.out.println(timestamp + "   " + queue.size());
		return queue.size();
	}

	public static void main(String[] args) {
		Design_Hit_Counter_362 obj = new Design_Hit_Counter_362();
		obj.hit(2);
		obj.hit(3);
		obj.hit(4);
		obj.getHits(301);
		obj.getHits(302);
		obj.getHits(303);
		obj.getHits(304);

		obj.hit(501);
		obj.getHits(600);
	}
}
