package hackerrank.twitter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TweetRecommendation {

	/*
	 * Complete the function below.
	 */
	static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges, int targetUser,
			int minLikeThreshold) {
		HashSet<Integer> followers = new HashSet<>();
		for (int i = 0; i < followGraph_edges.length; i++) {
			if (followGraph_edges[i][0] == targetUser) {
				followers.add(followGraph_edges[i][1]);
			}
		}
		// A likes Tweet t1
		HashMap<Integer, Integer> tweetUserMap = new HashMap<>();
		for (int i = 0; i < likeGraph_edges.length; i++) {
			int tweet = likeGraph_edges[i][1];
			int person = likeGraph_edges[i][0];
			if (followers.contains(person)) {
				if (tweetUserMap.containsKey(tweet)) {
					int count = tweetUserMap.get(tweet);
					tweetUserMap.put(tweet, count + 1);
				} else {
					tweetUserMap.put(tweet, 1);
				}
			}
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : tweetUserMap.entrySet()) {
			int tweet = entry.getKey();
			int count = entry.getValue();
			if (count > minLikeThreshold) {
				list.add(tweet);
			}
		}

		list.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {

				return o1.compareTo(o2);
			}
		});
		int[] array = new int[list.size()];
		for (int i = 0; i < array.length; i++) {
			array[i] = list.get(i);
		}
		return array;

	}

}
