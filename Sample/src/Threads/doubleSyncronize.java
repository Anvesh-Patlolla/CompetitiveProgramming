package Threads;

public class doubleSyncronize {

  synchronized void fun1()
  {
    
    System.out.println("f1");
  }
  
  synchronized void fun2()
  {
    System.out.println("f2");
    fun1();
  }
  
  
  public static void main(String[] args) {
    doubleSyncronize d  = new doubleSyncronize();
    d.fun2();
  }
  
}
