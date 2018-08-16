package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Word_Break_139 {
	HashSet<String> dict = null;
	boolean[] isPossible = null;

	public boolean wordBreak(String s, List<String> wordDict) {
		dict = new HashSet<>();
		isPossible = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			isPossible[i] = true;
		}
		for (String word : wordDict) {
			dict.add(word);
		}

		// seenWords = new HashSet<>();
		return calculate(s, 0, s.length());
	}

	private boolean calculate(String s, int start, int length) {
		if (!isPossible[start]) {
			return false;
		}
		for (int end = start + 1; end <= length; end++) {
			String sub = s.substring(start, end);
			if (dict.contains(sub)) {
				dict.add(sub);
				if (end == length) {
					return true;
				}
				if (calculate(s, end, length)) {
					return true;
				}
			}
		}
		isPossible[start] = false;
		return false;
	}

	public static void main(String[] args) {
		Word_Break_139 obj = new Word_Break_139();
		String s = "catsandog";
		String[] dict = { "cats", "dog", "sand", "and", "cat" };

		List<String> wordDict = new ArrayList<>();
		for (int i = 0; i < dict.length; i++) {
			wordDict.add(dict[i]);
		}
		System.out.println(obj.wordBreak(s, wordDict));
	}
}
