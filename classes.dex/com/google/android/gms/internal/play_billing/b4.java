package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

abstract class b4 {
    final Unsafe a;

    b4(Unsafe unsafe0) {
        this.a = unsafe0;
    }

    public abstract double a(Object arg1, long arg2);

    public abstract float b(Object arg1, long arg2);

    public abstract void c(Object arg1, long arg2, boolean arg3);

    public abstract void d(Object arg1, long arg2, byte arg3);

    public abstract void e(Object arg1, long arg2, double arg3);

    public abstract void f(Object arg1, long arg2, float arg3);

    public abstract boolean g(Object arg1, long arg2);
}

