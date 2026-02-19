package com.android.billingclient.api;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class l implements ThreadFactory {
    private final ThreadFactory a;
    private final AtomicInteger b;

    l(b b0) {
        this.a = Executors.defaultThreadFactory();
        this.b = new AtomicInteger(1);
    }

    @Override
    public final Thread newThread(Runnable runnable0) {
        Thread thread0 = this.a.newThread(runnable0);
        thread0.setName("PlayBillingLibrary-" + this.b.getAndIncrement());
        return thread0;
    }
}

