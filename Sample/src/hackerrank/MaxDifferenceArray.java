package hackerrank;

public class MaxDifferenceArray {

	static int maxDifference(int[] array) {
		int minArray[] = new int[array.length];
		int min = Integer.MAX_VALUE;
		minArray[0] = min;
		for (int i = 0; i < array.length - 1; i++) {
			if (min > array[i]) {
				min = array[i];
			}
			minArray[i + 1] = min;
		}
		int max = -1;
		for (int i = 1; i < array.length; i++) {
			if (max < (array[i] - minArray[i])) {
				max = array[i] - minArray[i];
			}
		}
		if (max == 0)
			return -1;
		return max;
	}

	public static void main(String[] args) {
		int[] array = { 2, 3, 10, 2, 4, 8, 1 };
		System.out.println(maxDifference(array));
		int array2[] = { 7, 9, 5, 6, 3, 2 };
		System.out.println(maxDifference(array2));

		int array3[] = { 6, 5, 4, 3, 2, 1 };
		System.out.println(maxDifference(array3));

		int array4[] = { 0, 0, 0, 0, 0, 0 };
		System.out.println(maxDifference(array4));

	}
}
