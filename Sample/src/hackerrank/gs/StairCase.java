package hackerrank.gs;

public class StairCase {

	static long array[] = null;

	static long countSteps(int n) {
		array = new long[n + 1];
		long retVal = calculate(n);
		return retVal;
	}

	private static long calculate(int n) {
		if (array[n] != 0) {
			return array[n];
		}
		if (n == 1 || n ==0) {
			return 1;
		}
		long sum = 0;
		if (n - 1 >= 0) {
			sum += calculate(n - 1);
		}
		if (n - 2 >= 0) {
			sum += calculate(n - 2);
		}
		if (n - 3 >= 0) {
			sum += calculate(n - 3);
		}
		array[n] = sum;
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(countSteps(3));
	}
}
