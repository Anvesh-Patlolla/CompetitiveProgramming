package airwatch;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HackLandElection {
	static String electionWinner(String[] votes) {
		if (votes.length == 0) {
			return "";
		}
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < votes.length; i++) {
			if (map.containsKey(votes[i])) {
				Integer integer = map.get(votes[i]);
				map.put(votes[i], integer + 1);
			} else {
				map.put(votes[i], 1);
			}
		}
		ArrayList<Vote> list = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			Vote vote = new Vote(entry.getKey(), entry.getValue());
			list.add(vote);
		}
		list.sort(new Comparator<Vote>() {

			@Override
			public int compare(Vote v1, Vote v2) {
				if (v1.vote > v2.vote) {
					return -1;
				} else if (v1.vote < v2.vote) {
					return 1;
				} else {
					return -1 * v1.name.compareTo(v2.name);
				}
			}
		});

		return list.get(0).name;

	}

	private static class Vote {
		public Vote(String name, int vote) {
			super();
			this.name = name;
			this.vote = vote;
		}

		String name;
		int vote;
	}

	public static void main(String[] args) {
		String[] votes = { "Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary" };
		System.out.println(electionWinner(votes));
	}
}
