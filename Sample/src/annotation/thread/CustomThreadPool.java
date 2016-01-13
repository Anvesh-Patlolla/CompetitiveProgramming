package annotation.thread;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import annotation.ThreadType;

public class CustomThreadPool {
  private static final int WORKER_THREADS = 7;
  ExecutorService sWorkerThread = Executors.newFixedThreadPool(WORKER_THREADS);

  private static CustomThreadPool sCustomThreadPool = null;

  static synchronized CustomThreadPool getInstance() {
    if (sCustomThreadPool == null) {
      sCustomThreadPool = new CustomThreadPool();
    }
    return sCustomThreadPool;
  }

  public void execute(final Runnable task) {
    Class<? extends Runnable> cls = task.getClass();

    Method[] methods = cls.getDeclaredMethods();
    for (int i = 1; i <= methods.length; i++) {
      final Method method = getMethodWithSerialNumber(methods, i);
      if (method != null) {

        ThreadType ann = method.getAnnotation(ThreadType.class);

        System.out.println("annotation :" + ann);
        Runnable runnable = new Runnable() {
          @Override
          public void run() {
            try {
              method.invoke(task, null);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
              e.printStackTrace();
            }

          }
        };
        switch (ann.threadType()) {
          case WORKER:
            sWorkerThread.execute(new CustomRunnable(runnable));
            break;

          case MASTER:
            new CustomRunnable(runnable).run();
            break;
        }

      }
    }
    
  }

  private Method getMethodWithSerialNumber(Method[] methods, int serialNumber) {
    for (Method method : methods) {
      if (method.isAnnotationPresent(ThreadType.class)) {
        ThreadType ann = method.getAnnotation(ThreadType.class);
        if (ann.serialNumber() == serialNumber) {
          return method;
        }
      }
    }
    return null;
  }

  class CustomRunnable implements Runnable {

    Runnable task;

    public CustomRunnable() {}

    CustomRunnable(Runnable task) {
      this.task = task;
    }

    @Override
    public void run() {
      System.out.println("Current ThreadId: " + Thread.currentThread().getId());
      task.run();
    }

  }
}
