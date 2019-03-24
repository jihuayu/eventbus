package com.jihuayu.eventbus.api;

public abstract class Event<T> {
    protected T invoker;

    public final T invoker() {
        return this.invoker;
    }

    public abstract void register(T var1);
}