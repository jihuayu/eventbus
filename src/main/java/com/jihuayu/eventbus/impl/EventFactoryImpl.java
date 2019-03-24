package com.jihuayu.eventbus.impl;

import com.jihuayu.eventbus.api.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
public final class EventFactoryImpl {
    private static final List<ArrayBackedEvent<?>> ARRAY_BACKED_EVENTS = new ArrayList<>();

    private EventFactoryImpl() {

    }

    public static void invalidate() {
        ARRAY_BACKED_EVENTS.forEach(ArrayBackedEvent::update);
    }

    public static <T> Event<T> createArrayBacked(Class<T> type, Function<T[], T> invokerFactory) {
        return createArrayBacked(type, null /* buildEmptyInvoker(type, invokerFactory) */, invokerFactory);
    }

    public static <T> Event<T> createArrayBacked(Class<T> type, T emptyInvoker, Function<T[], T> invokerFactory) {
        ArrayBackedEvent<T> event = new ArrayBackedEvent<>(type, emptyInvoker, invokerFactory);
        ARRAY_BACKED_EVENTS.add(event);
        return event;
    }
}