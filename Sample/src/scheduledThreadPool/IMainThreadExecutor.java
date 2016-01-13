package scheduledThreadPool;

import java.util.List;

public interface IMainThreadExecutor extends IThreadExecutor {

  void init(List<String> tryList, IMainSchedulerCallback iSchedulerCallback);
}
