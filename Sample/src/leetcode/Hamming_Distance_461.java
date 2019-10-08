package leetcode;

public class Hamming_Distance_461 {
	public int hammingDistance(int x, int y) {
		int hammingDistance = 0;
		for (int i = 0; i < 32; i++) {
			int temp = 1 << i;
			if ((x & temp) != (y & temp)) {
				hammingDistance++;
			}
		}
		return hammingDistance;
	}

	public static void main(String[] args) {
		Hamming_Distance_461 obj = new Hamming_Distance_461();
		System.out.println(obj.hammingDistance(1, 4));
	}
}
