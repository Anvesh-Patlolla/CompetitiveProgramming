package interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Largestnum {
  // DO NOT MODIFY THE LIST
  public String largestNumber(final List<Integer> a) {
    List<Integer> input = new ArrayList<>(a);
    Collections.sort(input, new Comparator<Integer>() {

      @Override
      public int compare(Integer input1, Integer input2) {
        if (input1.equals(input2)) {
          return 0;
        } else
          return compute2(input1, input2);
      }

      private int compute2(int input1, int input2) {
        int counter1 = 0;
        int temp1 = input1;
        while (temp1 != 0) {
          temp1 /= 10;
          counter1++;
        }

        int counter2 = 0;
        int temp2 = input2;
        while (temp2 != 0) {
          temp2 /= 10;
          counter2++;
        }
        if(input1* Math.pow(10, counter2)+ input2 > input2* Math.pow(10, counter1)+ input1){
          return 1;
        }else{
          return -1;
        }
      }

      private int compute(int input1, int input2) {

        int inp1 = input1;
        int inp2 = input2;
        while (input1 != input2) {
          int comp1 = 0;
          int comp2 = 0;
          if (input1 == 0 || input2 == 0) {
            if (input1 == 0) {
              return 1;

            } else {
              return -1;
            }
          }
          int temp1 = input1;
          int counter1 = -1;
          while (temp1 != 0) {
            temp1 /= 10;
            counter1++;
          }
          int div = (int) Math.pow(10, counter1);
          comp1 = input1 / div;
          input1 = input1 % div;

          int temp2 = input2;
          int counter2 = -1;
          while (temp2 != 0) {
            temp2 /= 10;
            counter2++;
          }
          int div2 = (int) Math.pow(10, counter2);
          comp2 = input2 / div2;
          input2 = input2 % div2;
          if (comp1 > comp2) {
            return 1;
          } else if (comp1 < comp2) {
            return -1;
          }
        }

        if (inp1 > inp2) {
          return -1;
        } else {
          return 1;
        }

      }
    });
    StringBuilder builder = new StringBuilder();
    if (input.get(input.size() - 1) == 0) {
      return "0";
    }
    for (int i = input.size() - 1; i > -1; i--) {

      builder.append(input.get(i));
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    Largestnum obj = new Largestnum();
    List<Integer> a = new ArrayList<Integer>();
    int arr[] = {3, 30, 34, 5, 9};
    for (int i = 0; i < arr.length; i++) {
      a.add(arr[i]);
    }
    System.out.println(obj.largestNumber(a));
  }
}
