package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Letter_Combinations_of_a_Phone_Number_17 {
	Map<Character, String> map = null;

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0) {
			return new ArrayList<>();
		}
		map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");

		List<String> retList = new ArrayList<>();
		calculate(retList, digits, 0, "");
		return retList;

	}

	private void calculate(List<String> retList, String digits, int current, String currentString) {
		if (currentString.length() == digits.length()) {
			retList.add(currentString);
			return;
		}
		String v = map.get(digits.charAt(current));
		for (int i = 0; i < v.length(); i++) {
			calculate(retList, digits, current + 1, currentString + v.charAt(i));
		}

	}
}
