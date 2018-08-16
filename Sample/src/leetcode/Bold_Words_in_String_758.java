package leetcode;

public class Bold_Words_in_String_758 {
	public String boldWords(String[] words, String S) {
		if (S == null || S.length() == 0) {
			return S;
		}
		boolean isBold[] = new boolean[S.length()];

		for (String word : words) {
			int startingIndex = -1;
			int index = -1;
			do {
				startingIndex++;
				startingIndex = S.indexOf(word, startingIndex);
				if (startingIndex != -1) {
					markBoolean(isBold, startingIndex, word.length());
				}
			} while (startingIndex != -1);
		}

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < S.length(); i++) {
			if (isBold[i] == false && ((i - 1 >= 0 && isBold[i - 1] == false) || (i - 1 < 0))) {
				sb.append(S.charAt(i));
			} else if (isBold[i] == true && ((i - 1 >= 0 && isBold[i - 1] == false) || i - 1 < 0)) {
				sb.append("<b>").append(S.charAt(i));
			} else if (isBold[i] == false && ((i - 1 >= 0 && isBold[i - 1] == true))) {
				sb.append("</b>").append(S.charAt(i));
			} else {
				sb.append(S.charAt(i));
			}
		}
		if (isBold[S.length() - 1]) {
			sb.append("</b>");
		}

		return new String(sb);
	}

	private void markBoolean(boolean[] isBold, int startingIndex, int length) {
		for (int i = startingIndex; i < length + startingIndex; i++) {
			isBold[i] = true;
		}

	}

	public static void main(String[] args) {
		Bold_Words_in_String_758 obj = new Bold_Words_in_String_758();
		String words[] = { "ab", "bc" };
		System.out.println(obj.boldWords(words, "aabcd"));

		String words2[] = { "b", "dee", "a", "ee", "c" };
		System.out.println(obj.boldWords(words, "cebcecceab"));
	}
}
