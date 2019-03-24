package test.handler;

import test.event.TestEvent;

public class TestHandler {
    public static void main(String[] args){
        TestEvent.EVENT.register(System.out::println);
        TestEvent.EVENT.register(System.out::print);
        TestEvent.EVENT.invoker().test(1);
        TestEvent.EVENT.invoker().test(10);
        TestEvent.EVENT.invoker().test(11);
        TestEvent.EVENT.invoker().test(12);
    }
}
