package hackerrank;

import java.util.Scanner;

public class TheLoveLetterMystry {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String input = null;
		for (int i = 0; i < T; i++) {
			input = sc.next();
			System.out.println(calculate(input));
		}
	}

	private static int calculate(String input) {

		int length = input.length();
		if (length == 0 || length == 1) {
			return 0;
		}
		//length --;
		int count =0;
		int temp =0;
		for (int i = 0; i < length / 2; i++) {
			temp = input.charAt(i) - input.charAt(length-1-i);
			temp = temp >0 ? temp : (temp* -1);
			count  = count + temp;
		}

		return count;
	}

}
