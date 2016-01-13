package annotation.thread;

import annotation.ThreadType;
import annotation.ThreadTypeEnum;

public class ThreadDriver {

  public static void main(String[] args) {
    CustomThreadPool instance = CustomThreadPool.getInstance();
    final String s1 ="s1";
    final String s2 ="s2";
    final String s3 ="s3";
    
    instance.execute(new Runnable() {

      @ThreadType(serialNumber = 1, threadType = ThreadTypeEnum.WORKER)
      public void run1() {
        System.out.println(s1);
      }

      @ThreadType(serialNumber = 2, threadType = ThreadTypeEnum.MASTER)
      public void run2() {
        System.out.println(s2);
      }
      
      @ThreadType(serialNumber = 3, threadType = ThreadTypeEnum.WORKER)
      public void run3() {
        System.out.println(s3);
      }


      @Override
      public void run() {


      }
    });
  }
}
