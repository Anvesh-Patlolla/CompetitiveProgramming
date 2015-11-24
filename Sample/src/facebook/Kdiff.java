package facebook;

public class Kdiff {

  void kdiff(int[] array, int k) {
    int l = 0, r = 0;
    while (r < array.length) {
      if (array[r] - array[l] == k) {
        System.out.println(array[r] + " " + array[l]);
        l++;
        r++;
      } else if (array[r] - array[l] < k) {
        r++;
      } else {
        l++;
      }
    }
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 5, 6, 8, 9, 11, 12, 13};
    int k = 3;
    Kdiff obj = new Kdiff();
    obj.kdiff(array, k);
    System.out.println("END");
  }
}
