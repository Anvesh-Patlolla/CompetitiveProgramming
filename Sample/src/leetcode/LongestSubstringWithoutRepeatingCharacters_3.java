package leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - j + 1);
		}

		return max;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();
		System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
		System.out.println(obj.lengthOfLongestSubstring("c"));
		System.out.println(obj
				.lengthOfLongestSubstring("lxvtlbfidlnffajtyridnxbcheovotmaqhveidmnobswcdrawcfjzhlincdevpgnydrggft"));
	}
}
