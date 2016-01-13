package Threads;

public class WaitNotify {
  Thread t[] = null;
  final static int THREAD_POOL_SIZE = 5;

  public static void main(String[] args) {
    WaitNotify obj = new WaitNotify();
    obj.t = new Thread[THREAD_POOL_SIZE];
    for (int i = 0; i < THREAD_POOL_SIZE; i++) {
      obj.t[i] = new Thread(obj.new SampleRunnable(i));
      obj.t[i].start();
    }
  }

  private final Object lock = new Object();

  class SampleRunnable implements Runnable {
    int id;

    public SampleRunnable(int i) {
      id = i;
    }

    final static boolean DEBUG = false;

    @Override
    public void run() {
      while (true) {
        System.out.println("In thread " + id);
        if (id == THREAD_POOL_SIZE - 1) {
          try {
            Thread.sleep(1700);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          synchronized (t[id]) {
            if (DEBUG) {
              System.out.println("notify from thread " + id);
            }
            t[id].notify();
          }
          // return;
        } else {
          int waitFor = id + 1;
          try {
            synchronized (t[waitFor]) {
              if (DEBUG) {
                System.out.println("Thread " + id + " waiting on " + waitFor);
              }
              t[waitFor].wait();
            }
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          synchronized (t[id]) {
            if (DEBUG) {
              System.out.println("notify from thread " + id);
            }
            try {
              Thread.sleep(700);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            t[id].notify();
          }
          System.out.println("over Thread" + id);
        }
      }
    }

  }

}
