package test.event;

import com.jihuayu.eventbus.api.Event;
import com.jihuayu.eventbus.api.EventFactory;

public interface TestEvent {
    Event<TestEvent> EVENT = EventFactory.createArrayBacked(TestEvent.class, listeners -> num ->{
        for (TestEvent i : listeners){
            i.test(num);
        }
    });
    void test(int num);
}
