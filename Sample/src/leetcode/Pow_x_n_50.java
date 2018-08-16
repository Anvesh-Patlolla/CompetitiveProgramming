package leetcode;

import java.util.HashMap;

public class Pow_x_n_50 {
	HashMap<Integer, Double> dp = null;

	public double myPow(double x, int n) {

		dp = new HashMap<>();
		return calculate(x, n);
	}

	private double calculate(double x, int n) {

		if (n == 0) {
			dp.put(n, 1.0);
			return 1.0;
		} else if (n == 1) {
			dp.put(n, x);
		} else if (n == -1) {
			dp.put(n, 1.0 / x);
		} else if (dp.containsKey(n)) {
			return dp.get(n);
		} else {
			int left = n / 2;
			int right = n - left;
			dp.put(n, calculate(x, left) * calculate(x, right));
		}
		// System.out.println("x: " + x + " n: " + n + " dp:" + dp[l + n]);
		return dp.get(n);
	}

	public static void main(String[] args) {
		Pow_x_n_50 obj = new Pow_x_n_50();
		System.out.println(obj.myPow(2.00000, 10));
		System.out.println(obj.myPow(2.10000, 3));
		System.out.println(obj.myPow(2.00000, -2));
		System.out.println(obj.myPow(0.00001, 2147483647));
	}

}
