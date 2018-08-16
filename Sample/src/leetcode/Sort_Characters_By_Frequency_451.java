package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sort_Characters_By_Frequency_451 {

	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (!map.containsKey(c)) {
				map.put(c, 0);
			}
			map.put(c, map.get(c) + 1);
		}
		List<Pair> list = new ArrayList<>();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			list.add(new Pair(entry.getKey(), entry.getValue()));
		}
		list.sort((o1, o2) -> o1.x < o2.x ? 1 : -1);
		list.sort(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {

				return o1.x < o2.x ? 1 : -1;
			}
		});
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < list.size(); i++) {
			Pair pair = list.get(i);
			for (int j = 0; j < pair.x; j++) {
				sb.append(pair.c);
			}
		}
		return new String(sb);

	}

	static class Pair {
		Character c;
		int x;

		Pair(Character c, int x) {
			this.c = c;
			this.x = x;
		}
	}
}
