package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Redundant_Connection_684 {
	public int[] findRedundantConnection(int[][] edges) {
		int retVal[] = null;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < edges.length; i++) {
			int edge[] = edges[i];
			if (set.contains(edge[0]) && set.contains(edge[1])) {
				return edge;
			}
			set.add(edge[0]);
			set.add(edge[1]);
		}
		return retVal;
	}
}
