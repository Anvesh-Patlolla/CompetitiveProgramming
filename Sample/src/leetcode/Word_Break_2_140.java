package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word_Break_2_140 {
	List<String> retList = null;
	boolean isPossible[] = null;

	public List<String> wordBreak(String s, List<String> wordDict) {
		isPossible = new boolean[s.length() + 1];
		for (int i = 0; i < isPossible.length; i++) {
			isPossible[i] = true;
		}
		retList = new ArrayList<>();
		calculate(s, wordDict, 0, "");
		return retList;
	}

	private boolean calculate(String s, List<String> wordDict, int i, String current) {
		if (!isPossible[i]) {
			return false;
		}
		if (i == s.length()) {
			retList.add(current.substring(1));
			isPossible[i] = true;
			return true;
		}
		boolean temp = false;
		for (String word : wordDict) {
			if (s.startsWith(word, i)) {
				temp |= calculate(s, wordDict, i + word.length(), current + " " + word);
			}
		}
		isPossible[i] = temp;
		return temp;
	}

	public static void main(String[] args) {
		Word_Break_2_140 obj = new Word_Break_2_140();
		String s = "catsanddog";
		String[] wordDict = { "cat", "cats", "and", "sand", "dog" };
		System.out.println(obj.wordBreak(s, Arrays.asList(wordDict)));
		String s2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String[] wordDict2 = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
				"aaaaaaaaaa" };

		System.out.println(obj.wordBreak(s2, Arrays.asList(wordDict2)));

		String s3 = "pineapplepenapple";
		String[] wordDict3 = { "apple", "pen", "applepen", "pine", "pineapple" };

		System.out.println(obj.wordBreak(s3, Arrays.asList(wordDict3)));

	}
}
