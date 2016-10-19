package vmware;

import java.util.ArrayList;
import java.util.Collections;

public class ReductionCost {
	static int reductionCost(int num[]) {
		if (num == null || num.length == 0) {
			return 0;
		}
		if (num.length == 1) {
			return num[0];
		}
		if (num.length == 2) {
			return num[0] + num[1];
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < num.length; i++) {
			list.add(num[i]);
		}
		Collections.sort(list);
		int retVal = 0;
		int sum = 0;
		for (; list.size() > 1;) {
			int temp = list.remove(0);
			int temp2 = list.remove(0);
			sum = temp + temp2;
			retVal += sum;
			list.add(temp + temp2);
			Collections.sort(list);
		}
		return retVal;
	}

	public static void main(String[] args) {
		int[] num = { 1, 2, 4, 3 };
		System.out.println(reductionCost(num));
		int[] num2 = { 1, 3, 2 };
		System.out.println(reductionCost(num2));
	}
}
