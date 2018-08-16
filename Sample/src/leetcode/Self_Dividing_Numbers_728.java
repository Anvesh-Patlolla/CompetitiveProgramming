package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 * A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 */
public class Self_Dividing_Numbers_728 {
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> retList = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			if (isSelfDividing(i)) {
				retList.add(i);
			}
		}
		return retList;
	}

	private boolean isSelfDividing(int number) {
		List<Integer> digits = getDigits(number);
		for (int i = 0; i < digits.size(); i++) {
			if (digits.get(i) == 0) {
				return false;
			}
			if (number % digits.get(i) != 0) {
				return false;
			}
		}
		return true;
	}

	private List<Integer> getDigits(int number) {
		List<Integer> digits = new ArrayList<>();
		while (number > 0) {
			digits.add(number % 10);
			number /= 10;
		}
		return digits;
	}

	public static void main(String[] args) {

	}
}
