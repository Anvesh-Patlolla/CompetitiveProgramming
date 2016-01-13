package scheduledThreadPool;

import java.util.concurrent.TimeUnit;


public interface IThreadExecutor {

  boolean isExecutorRunning();

  void deinit();
  void rescheduleThreadPool(int delay, TimeUnit unit);
  void taskDone();
  boolean isShutdown();
}
