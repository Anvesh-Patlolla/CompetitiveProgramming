package scheduledThreadPool;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

import Practise.Log;

public class RetryScheduledThreadPoolExecutor implements IRetryThreadExecutor {
  protected static final String LOG_TAG = RetryScheduledThreadPoolExecutor.class.getSimpleName();

  // Is RetryThread Running.
  private AtomicBoolean isRetryThreadRunning = new AtomicBoolean(false);

  private ScheduledExecutorService retryThreadPool = null;
  private int POOL_SIZE;
  private List<String> retryList = null;
  private IRetrySchedulerCallback retrySchedulerCallback = null;

  public void init(List<String> retryList, IRetrySchedulerCallback retrySchedulerCallback) {
    Log.d(LOG_TAG, "in init of RetryScheduledThreadPoolExecutor ");
    this.retryThreadPool = Executors.newScheduledThreadPool(POOL_SIZE);
    this.retryList = retryList;
    this.retrySchedulerCallback = retrySchedulerCallback;
    long initialDelay = calculateInitialDelay();

    Runnable command = new RetryRunnable();

    retryThreadPool.schedule(command, initialDelay, TimeUnit.SECONDS);

  }

  private long calculateInitialDelay() {
    Date date1 = new Date();
    Date date2 = new Date();
    Calendar instance = Calendar.getInstance();
    instance.setTime(date2);
    instance.add(Calendar.HOUR, 4);
    date2 = instance.getTime();
    @SuppressWarnings("unused")
    long timeToBeElapsed = (date2.getTime() - date1.getTime()) / 1000;
    return 5;
  }

  @Override
  public void taskDone() {
    isRetryThreadRunning.getAndSet(false);
  }

  @Override
  public boolean isExecutorRunning() {
    return isRetryThreadRunning.get();
  }

  @Override
  public void deinit() {
    retryThreadPool.shutdown();
  }

  @Override
  public void rescheduleThreadPool(int delay, TimeUnit unit) {
    Runnable command = new RetryRunnable();

    retryThreadPool.schedule(command, delay, unit);
  }

  @Override
  public boolean isShutdown() {
    return retryThreadPool.isShutdown();
  }

  class RetryRunnable implements Runnable {

    @Override
    public void run() {
      while (retrySchedulerCallback.isMainThreadRunning()) {
        synchronized (ScheduledThreadPoolExecutorSample.SCHEDULER_LOCK) {
          try {
            ScheduledThreadPoolExecutorSample.SCHEDULER_LOCK.wait();
          } catch (InterruptedException e) {
            Log.d(LOG_TAG, e.getMessage());
          }
        }
      }
      isRetryThreadRunning.getAndSet(true);
      Log.d(LOG_TAG, "rescheduleThreadPool.run() in DO some task.." + retryList.toString());

      retrySchedulerCallback.onRescheduleThread();

    }
  }
}
