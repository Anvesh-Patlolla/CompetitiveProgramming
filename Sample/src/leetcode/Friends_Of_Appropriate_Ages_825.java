package leetcode;

import java.util.Arrays;

public class Friends_Of_Appropriate_Ages_825 {
	public int numFriendRequests(int[] age) {
		int counter = 0;
		Arrays.sort(age);

		for (int i = age.length - 1; i > -1; i--) {
			for (int j = i - 1; j > -1; j--) {

				// age[j] <= 0.5 * age[i] + 7
				// age[j] > age[i]
				// age[j] > 100 && age[i] < 100
				if (i == j || age[j] > age[i] || age[j] <= 0.5 * age[i] + 7 || age[j] > 100 && age[i] < 100) {
					continue;
				}
				if (age[i] == age[j]) {
					counter++;
				}
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		Friends_Of_Appropriate_Ages_825 obj = new Friends_Of_Appropriate_Ages_825();
		int[] array = { 20,30,100,110,120 };
		System.out.println(obj.numFriendRequests(array));
	}
}
