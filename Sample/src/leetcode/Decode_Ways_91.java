package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Decode_Ways_91 {
	Map<String, Integer> dp = null;

	public int numDecodings(String s) {
		dp = new HashMap<>();
		if (s == null || s.length() == 0) {
			return 0;
		}
		return decode(s);
	}

	private int decode(String s) {
		if (s == null || s.length() == 0) {
			return 1;
		}
		int retVal = 0;
		if (s.length() == 1) {
			int num = s.charAt(0) - 64;
			if (num <= 26 && num > 0) {
				retVal = 1;
			} else {
				retVal = 0;
			}
		} else {
			int c1 = s.charAt(0) - 64;
			int c2 = s.charAt(1) - 64;
			int num = c1 * 10 + c2;
			if (num <= 26 && num > 0) {
				retVal = 2;
				int sub = decode(s.substring(2));
				retVal = retVal * sub;
			} else if (num > 26) {
				retVal = 1;
				int sub = decode(s.substring(1));
				retVal = retVal * sub;
			}
		}
		return retVal;
	}

	public static void main(String[] args) {
		Decode_Ways_91 decode = new Decode_Ways_91();
		System.out.println(decode.decode("1"));
	}
}
