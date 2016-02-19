package codility;

public class IncreasingSubArray {

  public int solution(int[] A) {
   int retIndex = 0;
   int continus = 1;
   int tempCont = 1, tempIndex = 0;
   for (int i = 1; i < A.length; i++) {
     if (A[i] > A[i - 1]) {
       tempCont++;
     } else {
       tempIndex = i;
       tempCont = 1;
     }
     if (tempCont > continus) {
       continus = tempCont;
       retIndex = tempIndex;
     }
   }
   return retIndex;
 }
  
}
