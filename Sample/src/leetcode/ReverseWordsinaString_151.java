package leetcode;

public class ReverseWordsinaString_151 {
	public String reverseWords(String input) {
		StringBuffer sb = new StringBuffer();
		String[] split = input.split(" ");
		if (split.length == 0) {
			return "";
		}
		for (int i = split.length - 1; i > -1; i--) {
			sb.append(split[i]).append(" ");
		}
		// sb.setLength(sb.length() - 1);
		String s = sb.substring(0, sb.length() - 1);
		return s;
	}

	public static void main(String[] args) {
		ReverseWordsinaString_151 obj = new ReverseWordsinaString_151();
		System.out.println(obj.reverseWords("1 "));
	}
}
