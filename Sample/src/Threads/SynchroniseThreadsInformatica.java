package Threads;

public class SynchroniseThreadsInformatica {

  public static final Object LOCK = new Object();
  int counter = 0;

  public static void main(String[] args) {
    SynchroniseThreadsInformatica obj = new SynchroniseThreadsInformatica();
    Thread t1 = new Thread(obj.new Runnable1(1));
    Thread t2 = new Thread(obj.new Runnable1(2));
    t1.start();
    t2.start();
  }

  class Runnable1 implements Runnable {
    int id = 0;

    public Runnable1(int id) {
      this.id = id;
    }

    @Override
    public void run() {
      method1Wrapper();
      method2Wrapper();
    }

    private void method1Wrapper() {

      method1();
      counter++;
    }

    private void method2Wrapper() {
      while (counter < 2) {
        synchronized (LOCK) {
          try {
            LOCK.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }

      method2();
      counter++;

      synchronized (LOCK) {
        LOCK.notifyAll();
      }

    }

    private void method1() {
      System.out.println("Thread " + id + " from method 1");
      try {
        Thread.sleep((long) (java.lang.Math.random() * 1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    private void method2() {
      try {
        Thread.sleep((long) (java.lang.Math.random() * 1000));
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Thread " + id + "from method 2");
    }
  }


  class Runnable2 implements Runnable {
    int id = 0;

    public Runnable2(int id) {
      this.id = id;
    }

    @Override
    public void run() {
      method1Wrapper();
      method2Wrapper();
    }

    private void method1Wrapper() {
      while (counter <= 1) {

        try {
          LOCK.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      method1();
      counter++;
      LOCK.notifyAll();
    }

    private void method2Wrapper() {
      while (counter <= 3) {

        try {
          LOCK.wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      method2();
      counter++;
      LOCK.notifyAll();
    }

    private void method1() {
      System.out.println("Thread " + id + " from method 1");
    }

    private void method2() {
      System.out.println("Thread " + id + "from method 2");
    }
  }

}
