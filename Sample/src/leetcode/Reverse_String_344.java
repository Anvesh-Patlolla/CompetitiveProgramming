package leetcode;

public class Reverse_String_344 {
	public String reverseString(String s) {
		if (s == null) {
			return null;
		} else if (s.length() == 0 || s.length() == 1) {
			return s;
		}

		StringBuilder builder = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			builder.append(s.charAt(i));
		}
		String temp = new String(builder);
		StringBuilder sb = new StringBuilder();
		for (int i = 0, j = 0; i < builder.length(); i++) {
			if (sb.charAt(i) == ' ') {
				// sb.append(builder.)
			}
		}
		return new String(builder);
	}

	public static void main(String[] args) {
		Reverse_String_344 obj = new Reverse_String_344();
		System.out.println(obj.reverseString("Hello World and Hi"));
	}


}
