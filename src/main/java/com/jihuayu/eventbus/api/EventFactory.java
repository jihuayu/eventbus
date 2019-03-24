package com.jihuayu.eventbus.api;

import com.jihuayu.eventbus.impl.EventFactoryImpl;

import java.util.function.Function;

public final class EventFactory {

    private EventFactory() {
    }

    public static void invalidate() {
        EventFactoryImpl.invalidate();
    }

    public static <T> Event<T> createArrayBacked(Class<T> type, Function<T[], T> invokerFactory) {
        return EventFactoryImpl.createArrayBacked(type, invokerFactory);
    }

    public static <T> Event<T> createArrayBacked(Class<T> type, T emptyInvoker, Function<T[], T> invokerFactory) {
        return EventFactoryImpl.createArrayBacked(type, emptyInvoker, invokerFactory);
    }
}
