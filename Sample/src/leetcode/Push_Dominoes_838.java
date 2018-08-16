package leetcode;

import java.util.Arrays;

public class Push_Dominoes_838 {
	public String pushDominoes(String dominoes) {
		int[] positions = new int[dominoes.length()];
		getPositions(positions, dominoes);
		char temp[] = new char[dominoes.length()];
		// System.out.println(Arrays.toString(positions));
		dominoes.getChars(0, dominoes.length(), temp, 0);
		char current = 'L';
		int currentIndex = -1;
		for (int i = 0; i < dominoes.length(); i++) {
			currentIndex = positions[i];
			if (currentIndex == -1) {
				break;
			}
			if (dominoes.charAt(currentIndex) == 'L') {
				
			} else {

			}

		}
		return null;
	}

	private void getPositions(int[] positions, String dominoes) {

		for (int i = 0; i < dominoes.length(); i++) {
			positions[i] = -1;
		}
		for (int i = 0; i < dominoes.length(); i++) {
			if (dominoes.charAt(i) == 'L' || dominoes.charAt(i) == 'R') {
				positions[i] = i;
			}
		}
		int currentValue = -1;
		for (int i = dominoes.length() - 1; i > -1; i--) {
			if (positions[i] != -1) {
				currentValue = positions[i];
			}
			if (positions[i] == -1) {
				positions[i] = currentValue;
			}
		}

	}

	public static void main(String[] args) {
		Push_Dominoes_838 obj = new Push_Dominoes_838();
		obj.pushDominoes(".L.R...LR..L..");
	}
}
