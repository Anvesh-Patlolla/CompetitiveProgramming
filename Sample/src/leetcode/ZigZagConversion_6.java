package leetcode;

public class ZigZagConversion_6 {
	public String convert(String s, int numRows) {
		StringBuilder retVal = new StringBuilder();
		StringBuilder builder[] = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			builder[i] = new StringBuilder();
		}
		for (int i = 0; i < s.length();) {
			for (int j = 0; j < numRows && i < s.length(); j++, i++) {
				builder[j].append(s.charAt(i));
			}

			for (int k = numRows - 2; k > 0 && i < s.length(); k--, i++) {
				builder[k].append(s.charAt(i));
			}
		}
		for (int i = 0; i < numRows; i++) {
			retVal.append(builder[i]);
		}
		return new String(retVal);
	}

	public static void main(String[] args) {
		ZigZagConversion_6 obj = new ZigZagConversion_6();
		System.out.println(obj.convert("PAYPALISHIRING", 3));
	}
}
