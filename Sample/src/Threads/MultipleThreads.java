package Threads;


public class MultipleThreads {
  Thread t[] = null;
  final static int THREAD_POOL_SIZE = 5;

  public static void main(String[] args) {
    MultipleThreads obj = new MultipleThreads();
    obj.t = new Thread[THREAD_POOL_SIZE];
    while (true) {
      for (int i = 0; i < 5; i++) {
        obj.t[i] = new Thread(obj.new sampleRunnable(i));
        obj.t[i].start();
      }
    }

  }

  public class sampleRunnable implements Runnable {
    public sampleRunnable() {
      // TODO Auto-generated constructor stub
    }

    public sampleRunnable(int i) {
      waitFor = i;
    }

    int waitFor = 0;

    @Override
    public void run() {
      System.out.println("Current THreaad " + Thread.currentThread().getId());
      try {
        Thread.sleep(100);
      } catch (InterruptedException e1) {
        
        e1.printStackTrace();
      }
      if(waitFor == THREAD_POOL_SIZE -1)
      {
        System.out.println("THreaad " + Thread.currentThread().getId() + " returning");
        return;
      }
      if (waitFor == 0) {
        waitFor = THREAD_POOL_SIZE - 1;
      } else {
        waitFor--;
      }
      
      try {
        System.out.println("THreaad " + Thread.currentThread().getId() + " waiting for " + waitFor);
        t[waitFor].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  /*
   * Runnable sampleRunnable = new Runnable() { long threadId = 0;
   * 
   * @Override public void run() { threadId = Thread.currentThread().getId();
   * System.out.println("Thread id -- "+ threadId); try { Thread.currentThread().join(); } catch
   * (InterruptedException e) { // TODO Auto-generated catch block e.printStackTrace(); } } };
   */

}
