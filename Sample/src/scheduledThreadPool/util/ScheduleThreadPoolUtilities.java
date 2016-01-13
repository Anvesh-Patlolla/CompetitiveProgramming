package scheduledThreadPool.util;

public class ScheduleThreadPoolUtilities {

  public static int generateRandom(int min, int max) {

    int temp = (int) (java.lang.Math.random() * (max - min));

    return temp + min;
  }
}
