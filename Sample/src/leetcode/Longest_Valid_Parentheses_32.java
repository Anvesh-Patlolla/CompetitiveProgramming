package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Longest_Valid_Parentheses_32 {
	public int longestValidParentheses(String s) {
		s = ")" + s;
		int max = 0;
		int open[] = new int[s.length()];
		int close[] = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				if (i != 0) {
					open[i] = open[i - 1] + 1;
					close[i] = close[i - 1];
				} else {
					open[i] = 1;
				}
			} else {
				if (i != 0) {
					close[i] = close[i - 1] + 1;
					open[i] = open[i - 1];
				} else {
					close[i] = 1;
				}
			}
		}
		int diff[] = new int[s.length()];
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			diff[i] = open[i] - close[i];
			List<Integer> list = map.getOrDefault(diff[i], new ArrayList<Integer>());
			list.add(i);
			map.put(diff[i], list);
		}
		for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> list = entry.getValue();
			int temp = 0;
			if (list.size() > 1) {
				temp = list.get(list.size() - 1) - list.get(0);
			}
			if (temp > max) {
				max = temp;
			}

		}
		return max;
	}

	public static void main(String[] args) {
		Longest_Valid_Parentheses_32 obj = new Longest_Valid_Parentheses_32();
		System.out.println(obj.longestValidParentheses(""));
		System.out.println(obj.longestValidParentheses("(()"));
		
		System.out.println(obj.longestValidParentheses(")()())"));
		System.out.println(obj.longestValidParentheses("()((()()("));
		System.out.println(obj.longestValidParentheses("()"));
		System.out.println(obj.longestValidParentheses(")("));
	}
}
