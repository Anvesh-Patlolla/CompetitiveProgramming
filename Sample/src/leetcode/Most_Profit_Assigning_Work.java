package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Most_Profit_Assigning_Work {
	HashMap<Integer, Integer> persist = new HashMap<>();

	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		ArrayList<Pair> list = new ArrayList<>();
		for (int i = 0; i < difficulty.length; i++) {
			list.add(new Pair(difficulty[i], profit[i]));
		}
		list.sort(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.difficulty > o2.difficulty) {
					return 1;

				} else if (o1.difficulty < o2.difficulty) {
					return -1;
				}
				return 0;
			}
		});

		int maxProfit = 0;
		for (int i = 0; i < list.size(); i++) {
			Pair pair = list.get(i);
			if (maxProfit > pair.profit) {
				pair.profit = maxProfit;
			} else {
				maxProfit = pair.profit;
			}
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for (Pair p : list) {
			map.put(p.difficulty, p.profit);
		}
		int totalProfit = 0;
		for (int worke : worker) {
			totalProfit += getProfit(worke, map);

		}
		return totalProfit;

	}

	private int getProfit(int worker, HashMap<Integer, Integer> map) {
		if (persist.containsKey(worker)) {
			return persist.get(worker);
		}
		for (int i = worker; i > 0; i--) {
			if (map.containsKey(i)) {
				for (int j = i; j <= worker; j++) {
					persist.put(j, map.get(i));
				}
				return map.get(i);
			}
		}
		return 0;
	}

	private static class Pair {
		int difficulty;
		int profit;

		Pair(int dif, int pro) {
			difficulty = dif;
			profit = pro;
		}
	}

	public static void main(String[] args) {
		Most_Profit_Assigning_Work obj = new Most_Profit_Assigning_Work();
		int[] difficulty = { 2, 4, 6, 8, 10 };
		int[] profit = { 10, 20, 30, 40, 50 };
		int worker[] = { 4, 5, 6, 7, 200 };
		System.out.println(obj.maxProfitAssignment(difficulty, profit, worker));
	}
}
