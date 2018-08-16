package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Valid_Parentheses_20 {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Stack<Character> stack = new Stack<>();
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');

		for (int i = 0; i < s.length(); i++) {
			char bracket = s.charAt(i);
			if (map.containsKey(bracket)) {
				if (stack.isEmpty()) {
					return false;
				}
				if (stack.pop() != map.get(bracket)) {
					return false;
				}
			} else {
				stack.push(bracket);
			}
		}
		return stack.isEmpty();
	}
}
