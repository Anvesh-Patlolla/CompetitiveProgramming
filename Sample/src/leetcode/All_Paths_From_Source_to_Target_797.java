package leetcode;

import java.util.ArrayList;
import java.util.List;

public class All_Paths_From_Source_to_Target_797 {
	List<List<Integer>> retList = null;
	int size = 0;

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		retList = new ArrayList<>();
		size = graph.length;
		allPaths(graph, new ArrayList<>(), 0);
		return retList;
	}

	private void allPaths(int[][] graph, ArrayList<Integer> arrayList, int current) {
		arrayList.add(current);
		if (current == size - 1) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < arrayList.size(); i++) {
				list.add(arrayList.get(i));
			}
			retList.add(list);
		}
		for (int i = 0; i < graph[current].length; i++) {

			allPaths(graph, arrayList, graph[current][i]);
			arrayList.remove(arrayList.size() - 1);
		}
	}

	public static void main(String[] args) {
		All_Paths_From_Source_to_Target_797 obj = new All_Paths_From_Source_to_Target_797();
		int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
		System.out.println(obj.allPathsSourceTarget(graph));
	}
}
