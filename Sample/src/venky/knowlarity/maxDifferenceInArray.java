package venky.knowlarity;

public class maxDifferenceInArray {

public static void main(String[] args) {
  System.out.println(maxDifference(new int[]{7,9,5,6,3,2}));
}

  static int maxDifference(int[] a) {
 
    int max = -1;
    int min = a[0];
     for(int i = 1 ; i <a.length;i++)
     {
       if(a[i] > min) 
       {
         if(a[i]-min> max) 
             max = a[i]-min  ;
       }
       else
       {
         min = a[i] ;
       }
     }
     
     return max;
  }

}




