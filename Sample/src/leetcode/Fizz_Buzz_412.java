package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Fizz_Buzz_412 {
	public List<String> fizzBuzz(int n) {
		ArrayList<String> retList = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if ((i % 3 == 0) && (i % 5 == 0)) {
				retList.add("FizzBuzz");
			} else if ((i % 3 == 0)) {
				retList.add("Fizz");
			} else if ((i % 5 == 0)) {
				retList.add("Buzz");
			} else {
				retList.add(Integer.toString(i));
			}
		}
		return retList;
	}

	public static void main(String[] args) {
		Fizz_Buzz_412 obj = new Fizz_Buzz_412();
		System.out.println(obj.fizzBuzz(15).toString());
	}
}
