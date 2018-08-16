package leetcode;

public class Read_N_Characters_Given_Read4_157 {
	/**
	 * @param buf
	 *            Destination buffer
	 * @param n
	 *            Maximum number of characters to read
	 * @return The number of characters read
	 */
	int cursor = 0;

	public int read(char[] buf, int n) {
		cursor = 0;
		char bufTemp[] = new char[4];
		int charLength = 0;
		int temp = 0;
		do {
			temp = read4(bufTemp);
			charLength += temp;
			if (n <= charLength) {

				copyChar(bufTemp, buf, true);
				return n;
			}

			copyChar(bufTemp, buf, false);
		} while (temp != 0 && temp == 4);
		return charLength;
	}

	private void copyChar(char[] bufTemp, char[] buf, boolean b) {
		for (int i = 4 * cursor, j = 0; i < buf.length && j < 4; i++, j++) {
			buf[i] = bufTemp[j];
		}
		cursor++;
	}

	int read4(char[] buf) {
		return 0;
	}
}
