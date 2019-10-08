package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Shortest_Word_Distance_III_245 {

	public int shortestWordDistance(String[] words, String word1, String word2) {
		HashMap<String, List<Integer>> map = null;
		map = new HashMap<>();
		int counter = 0;
		for (String word : words) {
			List<Integer> list = map.getOrDefault(word, new ArrayList<Integer>());
			list.add(counter);
			map.put(word, map.getOrDefault(word, list));
			counter++;
		}
		List<Integer> list = map.get(word1);
		List<Integer> list2 = map.get(word2);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if (word1.equals(word2) && i == j) {
					continue;
				}
				int temp = Math.abs(list.get(i) - list2.get(j));
				if (min > temp) {
					min = temp;
				}
			}
		}
		return min;
	}
}
