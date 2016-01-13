package madhu;

import java.util.Scanner;

public class SimilaritySearch {

  /*
   * public String inputFromKeyboard() { InputStreamReader in = null; in = new
   * InputStreamReader(System.in);
   * 
   * BufferedReader br = new BufferedReader(in); String s = null; try { s = br.readLine(); } catch
   * (IOException e) { e.printStackTrace(); try { br.close(); } catch (IOException e1) {
   * e1.printStackTrace(); } } return s; }
   */
  public static void main(String[] args) {
    int T;

    Scanner scanIn = new Scanner(System.in);
    T = Integer.parseInt(scanIn.nextLine());
    String input = null;
    for (int i = 0; i < T; i++) {
      input = scanIn.nextLine();
      calculate(input);
    }
  }

  private static void calculate(String input) {
    int total = 0;
    for (int i = 1; i < input.length(); i++) {
      //String second = input.substring(i);
      total += similaritySearch(input, i);
    }
    total+=input.length();
    System.out.println(total);
  }

  private static int similaritySearch(String input, int second) {
    for (int i = 0, j= second; j < input.length(); i++,j++) {
      if (input.charAt(i) != input.charAt(j)) {
        return i;
      }
    }
    return input.length()- second;

  }

}
