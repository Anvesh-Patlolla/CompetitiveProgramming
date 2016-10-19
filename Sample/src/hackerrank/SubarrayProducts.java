package hackerrank;

public class SubarrayProducts {

	static long retVal = 0;

	static long count(int[] numbers, int k) {
		retVal = 0;
		for (int i = 1; i <= numbers.length; i++) {
			subArrayProduct(numbers, i, k);
		}
		return retVal;
	}

	private static void subArrayProduct(int[] numbers, int size, int maxVal) {
		for (int i = 0; i <= numbers.length - size; i++) {
			long product = 1;
			for (int j = i, k = 0; k < size; k++, j++) {
				product = product * numbers[j];

				if (product > maxVal || product == 0) {
					break;
				}
			}
			if (product < maxVal) {
				retVal++;
			}
		}
	}

	public static void main(String[] args) {
		int k = 4;
		int[] numbers = { 1, 2, 3 };
		System.out.println(count(numbers, k));
		System.out.println(count(numbers, 7));

	}
}
