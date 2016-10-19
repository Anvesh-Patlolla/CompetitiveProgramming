package coursera;

import java.util.PriorityQueue;

public class Segment {

	static int segment(int x, int[] arr) {

		int maxVal = 0;
		int min = Integer.MAX_VALUE;
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

		for (int i = 0; i < x; i++) {
			queue.add(arr[i]);
		}
		maxVal = queue.peek();

		for (int i = x; i < arr.length; i++) {
			queue.remove(arr[i - x]);
			queue.add(arr[i]);
			min = queue.peek();

			if (maxVal < min) {
				maxVal = min;
			}
		}
		return maxVal;

	}

	public static void main(String[] args) {
		int x = 3;
		int[] arr = { 2, 5, 4, 6, 8 };
		System.out.println(segment(x, arr));

		int[] arr1 = { 1, 2, 3, 1, 2 };
		System.out.println(segment(1, arr1));
	}
}
