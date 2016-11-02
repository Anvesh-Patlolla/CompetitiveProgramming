package hackerrank.twitter;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class GeneticMutations {
	/*
	 * Complete the function below.
	 */

	static int findMutationDistance(String start, String end, String[] bank) {
		HashSet<String> b1 = new HashSet<>();
		for (int i = 0; i < bank.length; i++) {
			b1.add(bank[i]);
		}
		return ladderLength(start, end, b1);

	}

	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		char dna[] = { 'A', 'C', 'T', 'G' };
		if (beginWord.equals(endWord)) {
			return 0;
		}
		if (wordList.size() > 2000) {
			// return 11;
		}
		LinkedList<Node> bfsQueue = new LinkedList<Node>();
		wordList.add(endWord);
		wordList.remove(beginWord);
		bfsQueue.add(new Node(beginWord, 1));
		while (bfsQueue.isEmpty() == false) {
			Node topNode = bfsQueue.pop();/*
											 * if (topNode.word.equals(endWord))
											 * { return topNode.distance; }
											 */
			// wordList.remove(topNode.word);
			char[] charArr = topNode.word.toCharArray();
			for (int i = 0; i < charArr.length; i++) {
				char t = charArr[i];
				for (int l = 0; l < 4; l++) {
					char j = dna[l];
					if (j != t) {
						charArr[i] = j;
						String s1 = new String(charArr);
						if (s1.equals(endWord)) {
							return topNode.distance;
						}
						if (wordList.remove(s1)) {
							bfsQueue.add(new Node(s1, topNode.distance + 1));
						}

					}
					charArr[i] = t;
				}
			}

		}

		return 0;

	}

	static class Node {
		public Node(String word, int distance) {
			super();
			this.word = word;
			this.distance = distance;
		}

		String word;
		int distance;
	}

}
