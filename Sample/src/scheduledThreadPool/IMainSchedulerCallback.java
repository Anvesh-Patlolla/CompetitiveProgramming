package scheduledThreadPool;

public interface IMainSchedulerCallback extends ISchedulerCallback{
  void onTaskDone();

  void killRetryScheduler();
}
