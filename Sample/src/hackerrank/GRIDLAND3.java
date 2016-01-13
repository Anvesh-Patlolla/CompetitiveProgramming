package hackerrank;

public class GRIDLAND3 {
  static String[] ret = null;
  static int present = 0;
  static int cou = 0;

  static String[] gridLand(String[] inp) {
    ret = new String[inp.length];
    cou = 0;
    for (String s : inp) {
      String[] params = s.split(" ");
      int H = Integer.parseInt(params[0]);
      int V = Integer.parseInt(params[1]);
      int required = Integer.parseInt(params[2]);
      present = 0;
      gridlandRecursive(0, 0, H, V, required, new char[H + V], 0);
      cou++;
    }

    return ret;
  }

  private static boolean gridlandRecursive(int x, int y, int h, int v, int required, char[] path,
      int cur) {
    if (x > h || y > v) {
      return false;
    }
    if (x == h && y == v) {
      if (present == required) {
        ret[cou] = new String(path);
        return true;
      }
      present++;
      return false;
    }
    boolean l = false;
    boolean r = false;
    if (x + 1 <= h) {
      path[cur] = 'H';
      l = gridlandRecursive(x + 1, y, h, v, required, path, cur + 1);
    }
    if (l != true && y + 1 <= v) {

      path[cur] = 'V';
      r = gridlandRecursive(x, y + 1, h, v, required, path, cur + 1);
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
