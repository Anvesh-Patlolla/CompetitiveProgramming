package eventbus;

import java.util.ArrayList;
import java.util.List;

public class EventBus {

  private static EventBus eventBus;

  public static synchronized EventBus getInstance() {

    if (eventBus == null) {
      eventBus = new EventBus();
    }
    return eventBus;
  }

  private List<Object> registeredObjects = new ArrayList<>();

  public void register(Object obj) {
    if (registeredObjects.contains(obj)) {
      return;
    } else {
      registeredObjects.add(obj);
    }
  }
  public void post(Object obj){
    
  }
}
