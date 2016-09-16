package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class Palantir {

	private String first;
	private String second;
	private String result;

	public void arthemetic(String first, String second, String result) {
		this.first = first;
		this.second = second;
		this.result = result;
	}

	public boolean isCorrectCombination(Map<Character, Integer> map) {
		first = removeLeadingZeros(first, map);
		second = removeLeadingZeros(second, map);
		result = removeLeadingZeros(result, map);

		int firstLength = first.length();
		int secondLength = second.length();
		int resultLength = result.length();
		int firstDigit = 0;
		int secondDigit = 0;
		int thirdDigit = 0;
		int carry = 0;
		for (int i = 0; i < firstLength || i < secondLength || i < resultLength; i++) {
			if (firstLength - 1 > i) {
				firstDigit = map.get(first.charAt(firstLength - i - 1));
			} else {
				firstDigit = 0;
			}
			if (secondLength - 1 > i) {
				secondDigit = map.get(second.charAt(secondLength - i - 1));
			} else {
				secondDigit = 0;
			}
			if (resultLength - 1 > i) {
				thirdDigit = map.get(result.charAt(resultLength - i - 1));
			} else {
				thirdDigit = 0;
			}
			if ((firstDigit + secondDigit + carry) % 10 != thirdDigit) {
				return false;
			}
			if (firstDigit + secondDigit + carry >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}

		}
		return true;
	}

	private String removeLeadingZeros(String first2, Map<Character, Integer> map) {
		int i = 0;
		for (i = 0; i < first2.length() && map.get(first2.charAt(i)) == 0; i++) {
			continue;
		}
		return first2.substring(i);

	}

	public static void main(String[] args) {
		Palantir palantir = new Palantir();
		palantir.arthemetic("FFAAA", "FFAAA", "FFBBBF");
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('A', 5);
		map.put('B', 1);
		map.put('F', 0);
		System.out.println(palantir.isCorrectCombination(map));
	}
}
