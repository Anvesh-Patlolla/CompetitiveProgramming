package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsofaPhoneNumber_17 {
	HashMap<Character, String> map = new HashMap<>();
	List<String> retList = null;

	public List<String> letterCombinations(String digits) {

		retList = new ArrayList<>();
		if (digits == null || digits.equals("")) {
			return null;
		}
		init();
		recursiveCall(digits, "", 0);
		return retList;
	}

	private void recursiveCall(String digits, String string, int index) {
		if (index == digits.length()) {
			retList.add(string);
			return;
		}
		String currentButton = map.get(digits.charAt(index));
		for (int i = 0; i < currentButton.length(); i++) {
			recursiveCall(digits, string + currentButton.charAt(i), index + 1);
		}
	}

	private void init() {
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");

	}

	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber_17 obj = new LetterCombinationsofaPhoneNumber_17();
		System.out.println(obj.letterCombinations("23"));
	}
}
