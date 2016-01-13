package scheduledThreadPool;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import scheduledThreadPool.util.Log;

public class ScheduledThreadPoolExecutorSample implements IMainThreadExecutor {

  private static final int POOL_SIZE = 2;
  private static final String LOG_TAG = ScheduledThreadPoolExecutorSample.class.getSimpleName();
  private ScheduledExecutorService mainThreadPool = null;

  private List<String> tryList = null;

  private IMainSchedulerCallback schedulerCallback = null;

  public static final Object SCHEDULER_LOCK = new Object();
  // Is MainThread Running.
  private AtomicBoolean isMainThreadRunning = new AtomicBoolean(false);


  public ScheduledThreadPoolExecutorSample() {}

  @Override
  public void init(List<String> tryList, IMainSchedulerCallback iSchedulerCallback) {
    Log.d(LOG_TAG, "ScheduledThreadPoolExecutorSample - init()");
    this.mainThreadPool = Executors.newScheduledThreadPool(POOL_SIZE);
    this.tryList = tryList;
    long initialDelay = calculateInitialDelay();// Runs initially at 12 AM
    long period = 40; // Every 4 Hours
    Runnable runnable = new SampleRunnable();

    mainThreadPool.scheduleAtFixedRate(runnable, initialDelay, period, TimeUnit.SECONDS);
    this.schedulerCallback = iSchedulerCallback;
  }


  private static long calculateInitialDelay() {
    Date date1 = new Date();
    Date date2 = new Date();
    Calendar instance = Calendar.getInstance();
    instance.setTime(date2);
    instance.add(Calendar.DATE, 1);
    instance.add(Calendar.HOUR, 2);
    date2 = instance.getTime();
    @SuppressWarnings("unused")
    long timeToBeElapsed = (date2.getTime() - date1.getTime()) / 1000;
    return 5;
  }

  @Override
  public void deinit() {
    mainThreadPool.shutdown();
  }

  @Override
  public void rescheduleThreadPool(int delay, TimeUnit unit) {
    Runnable command = new SampleRunnable();
    mainThreadPool.schedule(command, delay, unit);
  }


  public class SampleRunnable implements Runnable {

    @Override
    public void run() {

      isMainThreadRunning.set(true);
      schedulerCallback.killRetryScheduler();
      // TOOO : do some computations here
      Log.d(LOG_TAG, "SampleRunnable run.." + tryList.toString());
      schedulerCallback.onTaskDone();
      schedulerCallback.onRescheduleThread();
    }

  }

  @Override
  public boolean isExecutorRunning() {
    return isMainThreadRunning.get();
  }

  @Override
  public void taskDone() {
    isMainThreadRunning.set(false);
    synchronized (SCHEDULER_LOCK) {
      SCHEDULER_LOCK.notify();
    }
  }

  @Override
  public boolean isShutdown() {
    return mainThreadPool.isShutdown();
  }

}
