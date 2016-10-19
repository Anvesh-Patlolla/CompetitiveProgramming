package airwatch;

public class LastSubstring {
	static String compute(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		String maxChar = "";
		int index = 0;
		for (int i = 0; i < s.length(); i++) {
			String temp = s.substring(i);
			if (temp.compareTo(maxChar) >= 0) {
				maxChar = temp;
				index = i;
			}

		}
		String retVal = s.substring(index);
		return retVal;
	}

	public static void main(String[] args) {
		System.out.println(compute("ab"));
		System.out.println(compute("ba"));
		System.out.println(compute("aaa"));
		System.out.println(compute("banana"));
	}
}
