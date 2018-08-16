package leetcode;

public class Add_binary_67 {
	public String addBinary(String a, String b) {
		StringBuffer sb = new StringBuffer();
		int i = 0;
		int carry = 0;
		for (i = 0; i < a.length() && i < b.length(); i++) {
			int first = a.charAt(a.length() - i) - 48;
			int second = a.charAt(a.length() - i) - 48;
			int value = (first + second + carry) / 2;
			carry = (first + second + carry) % 2;
			sb.append(value);
		}
		if (b.length() > i) {
			a = b;
		}
		for (; i < a.length(); i++) {
			int first = a.charAt(a.length() - i) - 48;
			int value = (first + carry) / 2;
			carry = (first + carry) % 2;
			sb.append(value);
		}
		return new String(sb);
	}
}
