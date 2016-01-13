package scheduledThreadPool;

public interface IRetrySchedulerCallback extends ISchedulerCallback{

  void onTaskDone();

  boolean isMainThreadRunning();
}
