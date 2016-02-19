package hackerrank;

import java.util.HashMap;

public class TheHuffmanDecoder {

  static String Decoding(String[] encodings, String encodedstring) {
    HashMap<String, String> map = new HashMap<String, String>();
    for (String s : encodings) {
      String pair[] = s.split("\t");
      map.put(pair[1], pair[0]);
      if (pair[0].equals("[newline]")) {
        map.put(pair[1], "\n");
      }
    }
    StringBuilder builder = new StringBuilder();
    int start = 0;
    for (int i = 0; i < encodedstring.length(); i++) {
      String substring = encodedstring.substring(start, i + 1);
      if (map.containsKey(substring)) {
        start = i + 1;
        builder.append(map.get(substring));
      }
    }

    return builder.toString();
  }
}
