package leetcode;

import java.util.HashMap;

public class Anagram_Mappings {

	public static void main(String[] args) {

	}

	public int[] anagramMappings(int[] A, int[] B) {
		if (A == null || A.length == 0) {
			return new int[0];
		}
		int retVal[] = new int[A.length];
		HashMap<Integer, Integer> BIndexMapping = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			BIndexMapping.put(B[i], i);
		}
		for (int i = 0; i < A.length; i++) {
			retVal[i] = BIndexMapping.get(A[i]);
		}
		return retVal;
	}
}
