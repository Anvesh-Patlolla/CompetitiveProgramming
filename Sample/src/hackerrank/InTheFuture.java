package hackerrank;

public class InTheFuture {

	static int minNum(int A, int K, int P) {

		int temp = 0;
		if ((P + 1) % (K - A) == 0) {
			temp = 0;
		} else {
			temp = 1;
		}
		return (int) Math.ceil((P + 1) / (K - A)) + temp;
	}

	public static void main(String[] args) {

		System.out.println(minNum(3, 5, 1));
		System.out.println(minNum(4, 5, 1));
		System.out.println(minNum(3, 6, 6));
	}
}
