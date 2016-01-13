package scheduledThreadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import scheduledThreadPool.util.Log;
import scheduledThreadPool.util.ScheduleThreadPoolUtilities;

public class ScheduleManager {
  static final Object CRITICAL_LOCK = new Object();
  protected static final String LOG_TAG = ScheduleManager.class.getSimpleName();
  IMainThreadExecutor scheduledThreadPoolExecutorSample = null;
  IRetryThreadExecutor retryScheduledThreadPoolExecutor = null;



  public void init() {
    scheduledThreadPoolExecutorSample = new ScheduledThreadPoolExecutorSample();
    retryScheduledThreadPoolExecutor = null;
    final List<String> retryList = new ArrayList<>();

    scheduledThreadPoolExecutorSample.init(retryList, new IMainSchedulerCallback() {

      @Override
      public void onRescheduleThread() {
        synchronized (CRITICAL_LOCK) {

          Log.d(LOG_TAG, "IMainSchedulerCallback - in  ScheduleManager onRescheduleThread");
          int sec = ScheduleThreadPoolUtilities.generateRandom(60, 80);
          Log.d(LOG_TAG, "IMainSchedulerCallback - Rescheduling in ScheduleManager for " + sec + " secs");
          scheduledThreadPoolExecutorSample.rescheduleThreadPool(sec, TimeUnit.SECONDS);
        }
      }

      @Override
      public void onTaskDone() {
        if (retryScheduledThreadPoolExecutor == null || retryScheduledThreadPoolExecutor.isShutdown()) {
          retryScheduledThreadPoolExecutor = new RetryScheduledThreadPoolExecutor();
          retryScheduledThreadPoolExecutor.init(retryList, new RetryCallback(retryList));
        }
        scheduledThreadPoolExecutorSample.taskDone();
      }

      @Override
      public void killRetryScheduler() {
        // TODO: Kill ReTry Threadpool if it is running.
        if (retryScheduledThreadPoolExecutor != null
            && retryScheduledThreadPoolExecutor.isExecutorRunning()) {
          retryScheduledThreadPoolExecutor.deinit();
        }

      }
    });


  }

  class RetryCallback implements IRetrySchedulerCallback {

    private List<String> retryList;

    public RetryCallback(List<String> retryList) {
      this.retryList = retryList;
    }


    @Override
    public void onRescheduleThread() {
      synchronized (CRITICAL_LOCK) {
        Log.d(LOG_TAG, "IRetrySchedulerCallback - in  onRescheduleThread");
        int sec = ScheduleThreadPoolUtilities.generateRandom(5, 10);
        Log.d(LOG_TAG, "IRetrySchedulerCallback - Rescheduling in ScheduleManager for " + sec + " secs");
        if (retryScheduledThreadPoolExecutor.isShutdown()) {
          retryScheduledThreadPoolExecutor = new RetryScheduledThreadPoolExecutor();
          retryScheduledThreadPoolExecutor.init(retryList, this);
        } else {
          retryScheduledThreadPoolExecutor.rescheduleThreadPool(sec, TimeUnit.SECONDS);
        }
      }

    }

    @Override
    public void onTaskDone() {
      retryScheduledThreadPoolExecutor.taskDone();
    }


    @Override
    public boolean isMainThreadRunning() {
      return scheduledThreadPoolExecutorSample.isExecutorRunning();
    }

  }

  public void deinit() {
    scheduledThreadPoolExecutorSample.deinit();
  }

  public static void main(String[] args) {
    ScheduleManager obj = new ScheduleManager();
    obj.init();
  }

}
