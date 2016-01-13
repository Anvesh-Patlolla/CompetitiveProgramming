package scheduledThreadPool;

import java.util.List;

public interface IRetryThreadExecutor extends IThreadExecutor{
  void init(List<String> retryList, IRetrySchedulerCallback retrySchedulerCallback);
  void taskDone();
}
