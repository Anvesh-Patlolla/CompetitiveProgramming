package leetcode;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class Twitter {

	Map<Integer, Set<Integer>> followingMap = null;
	Map<Integer, List<Tweet>> tweetsMap = null;

	/** Initialize your data structure here. */
	public Twitter() {
		followingMap = new HashMap<>();
		tweetsMap = new HashMap<>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		List<Tweet> tweetList = tweetsMap.getOrDefault(userId, new ArrayList<Tweet>());
		tweetList.add(new Tweet(tweetId));
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item
	 * in the news feed must be posted by users who the user followed or by the
	 * user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		Set<Integer> followeeList = followingMap.getOrDefault(userId, new HashSet<>());
		followeeList.add(userId);
		PriorityQueue<Tweet> tweets = new PriorityQueue<>(followeeList.size() * 10, new Comparator<Tweet>() {

			@Override
			public int compare(Tweet o1, Tweet o2) {
				if (o1.instant.isAfter(o2.instant)) {
					return 1;
				} else if (o1.instant.isBefore(o2.instant)) {
					return -1;
				} else {
					return 0;
				}
			}
		});

		for (int user : followeeList) {
			tweets.addAll(tweetsMap.get(user));
		}
		ArrayList<Integer> tweetIds = new ArrayList<>();
		for (int i = 0; i < 10 && tweets.size() > 0; i++) {
			tweetIds.add(tweets.remove().tweetId);
		}
		return tweetIds;

	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		Set<Integer> followers = followingMap.getOrDefault(followerId, new HashSet<>());
		followers.add(followeeId);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be
	 * a no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		Set<Integer> followers = followingMap.getOrDefault(followerId, new HashSet<>());
		followers.remove(followeeId);
	}

	public static class Tweet {
		int tweetId;
		Instant instant;

		Tweet(int tweetId) {
			this.tweetId = tweetId;
			this.instant = Instant.now();
		}
	}

	public static void main(String[] args) {
		Twitter obj = new Twitter();
		obj.postTweet(1, 5);
		obj.getNewsFeed(1);

	}
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
