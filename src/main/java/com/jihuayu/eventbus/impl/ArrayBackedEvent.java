package com.jihuayu.eventbus.impl;


import com.jihuayu.eventbus.api.Event;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Function;

class ArrayBackedEvent<T> extends Event<T> {
    private final Class<T> type;
    private final Function<T[], T> invokerFactory;
    private final T dummyInvoker;
    private T[] handlers;

    ArrayBackedEvent(Class<T> type, T dummyInvoker, Function<T[], T> invokerFactory) {
        this.type = type;
        this.dummyInvoker = dummyInvoker;
        this.invokerFactory = invokerFactory;
        update();
    }

    void update() {
        if (handlers == null) {
            if (dummyInvoker != null) {
                invoker = dummyInvoker;
            } else {
                //noinspection unchecked
                invoker = invokerFactory.apply((T[]) Array.newInstance(type, 0));
            }
        } else if (handlers.length == 1) {
            invoker = handlers[0];
        } else {
            invoker = invokerFactory.apply(handlers);
        }
    }

    @Override
    public void register(T listener) {
        if (listener == null) {
            throw new NullPointerException("Tried to register a null listener!");
        }

        if (handlers == null) {
            //noinspection unchecked
            handlers = (T[]) Array.newInstance(type, 1);
            handlers[0] = listener;
        } else {
            handlers = Arrays.copyOf(handlers, handlers.length + 1);
            handlers[handlers.length - 1] = listener;
        }

        update();
    }
}