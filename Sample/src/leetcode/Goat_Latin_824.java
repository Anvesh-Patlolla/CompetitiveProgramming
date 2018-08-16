package leetcode;

public class Goat_Latin_824 {
	public String toGoatLatin(String S) {

		String[] words = S.split(" ");
		StringBuffer sb = new StringBuffer();
		int count = 1;

		for (String word : words) {
			if (word.length() == 0) {
				continue;
			}
			String newword = "";
			char first = word.charAt(0);
			switch (first) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				newword = word + "ma" + getAA(count);
				break;
			default:
				newword = word.substring(1) + first + "ma" + getAA(count);

			}
			sb.append(newword + " ");
			count++;
		}
		sb.deleteCharAt(sb.length() - 1);

		return new String(sb);
	}

	private String getAA(int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append('a');
		}
		return new String(sb);
	}

	public static void main(String[] args) {
		Goat_Latin_824 obj = new Goat_Latin_824();
		System.out.println(obj.toGoatLatin("I speak Goat Latin"));

		System.out.println(obj.toGoatLatin("The quick brown fox jumped over the lazy dog"));

	}
}
