package hackerrank;


public class GRIDLAND2 {


  static String[] retVal = null;
  static int current = 0;
  // static HashSet<String> set = null;
  static int counter = 0;

  static String[] gridLand(String[] inp) {
    retVal = new String[inp.length];
    counter = 0;
    for (String s : inp) {
      String[] params = s.split(" ");
      int H = Integer.parseInt(params[0]);
      int V = Integer.parseInt(params[1]);
      int required = Integer.parseInt(params[2]);
      current = 0;
      // set = new HashSet<>();
      calculate(0, 0, H, V, required, new StringBuffer());
      counter++;
    }

    return retVal;
  }

  private static boolean calculate(int currentX, int currentY, int h, int v, int required,
      StringBuffer path) {
    if (currentX > h || currentY > v) {
      return false;
    }
    if (currentX == h && currentY == v) {
      if (current == required) {
        retVal[counter] = path.toString();
        return true;
      }
      current++;
      return false;
    }
    boolean l = false;
    boolean r = false;
    if (currentX + 1 <= h) {
      l = calculate(currentX + 1, currentY, h, v, required, path.append('H'));
      path.deleteCharAt(path.length() - 1);
    }
    if (l != true && currentY + 1 <= v) {
      r = calculate(currentX, currentY + 1, h, v, required, path.append('V'));
      path.deleteCharAt(path.length() - 1);
    }

    return l || r;
  }

  public static void main(String[] args) {
    String[] inp = {"2 2 2", "2 2 3"};
    display(gridLand(inp));
  }

  private static void display(String[] gridLand) {
    for (int i = 0; i < gridLand.length; i++) {
      System.out.println(gridLand[i]);
    }

  }
}
