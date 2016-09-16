package hackerrank;

import java.util.Scanner;

public class StockMaximize {
	public static void main(String args[]) throws Exception {
		int T = 0, N = 0;
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			int array[] = new int[N];
			for (int j = 0; j < N; j++) {
				array[j] = sc.nextInt();
			}
			calculate(array);
		}
	}

	private static void calculate(int[] array) {
		int size = array.length;
		int[] maxArray = new int[size];
		int max = 0;
		for (int i = size - 1; i > -1; i--) {
			if (max < array[i]) {
				max = array[i];
			}
			maxArray[i] = max;
		}
		long sum = 0;
		for (int i = 0; i < size; i++) {
			if (maxArray[i] - array[i] > 0) {
				sum += maxArray[i] - array[i];
			}
		}
		System.out.println(sum);
	}
}

/*
 3
 3
 5 3 2 
 3
 1 2 100
 4
 1 3 1 2
 */
 
