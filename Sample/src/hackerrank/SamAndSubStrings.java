package hackerrank;

import java.util.Scanner;

public class SamAndSubStrings {
	// Change class name to Solution while submitting

	static long arr[][] = null;
	static int len = 0;
	static String inputString = null;
	static long res[] = null;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		inputString = sc.next();
		long input = Long.parseLong(inputString);
		len = inputString.length();
		arr = new long[len][len];
		res = new long[len];
		calculate(input);
		 print();
		System.out.println(sum());
	}

	private static long sum() {
		long result = 0;
		for (int i = 0; i < len; i++) {
			result = (result + res[i]) ;
		}
		return result%mod;
	}

	private static void print() {
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static long  mod = (long) (1e9 + 7);

	private static void calculate(long input) {
		long temp = 0;
		arr[0][0] = inputString.charAt(0) - 48;
		for (int i = 1; i < len; i++) {
			arr[0][i] = arr[0][i - 1] * 10 + inputString.charAt(i) - 48;
			temp += arr[0][i];
		}
		res[0] = temp+arr[0][0];
		for (int i = 1; i < len; i++) {
			arr[i][i] = inputString.charAt(i) - 48;
		}

		for (int i = 1; i < len; i++) {
			temp = arr[i][i];
			for (int j = i + 1; j < len; j++) {
				arr[i][j] = arr[i - 1][j]
						% (long) java.lang.Math.pow(10, j - i + 1);
				temp += arr[i][j];
				//temp %= mod;
			}
			res[i] = temp;
		}

	}
}
