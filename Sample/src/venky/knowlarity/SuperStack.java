package venky.knowlarity;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SuperStack {

  final static String PUSH = "push";
  final static String POP = "pop";
  final static String INC = "inc";
  final static String EMPTY = "EMPTY";

  public static void main(String[] args) throws Exception {

    //Scanner sc =  new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int nop = Integer.parseInt(br.readLine());
    int arr[] = new int[nop] ;
    int currPos = -1;
    for(int i = 0 ; i < nop ; i++)
    {
      
      String[] op = br.readLine().split(" ");    
      switch (op[0]) {
        case PUSH: 
          arr[++currPos]= Integer.parseInt(op[1]);
          break;
       
        case POP:
          currPos--;
          break;
        case INC:
          int noe = Integer.parseInt(op[1]);
          int x  = Integer.parseInt(op[2]);
          for(int j = 0 ; j < noe;j++)
          {
            arr[j] += x;
          }
          break;
          
        default:
          System.out.println("WTH");
          break;
      }
      if(currPos == -1)
      {
        sb.append(EMPTY).append("\n");
      }
      else
      {
        sb.append(arr[currPos]).append("\n");
      }
      
    }
    
    System.out.print(sb);
  }
  
  
}
