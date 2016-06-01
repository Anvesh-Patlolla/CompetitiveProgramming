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
		return new String(builder);
	}

}
