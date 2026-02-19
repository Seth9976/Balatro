package com.google.android.gms.common.internal;

import h1.a;

public abstract class DowngradeableSafeParcel extends a implements ReflectedParcelable {
    private boolean e;
    private static final Object f;

    static {
        DowngradeableSafeParcel.f = new Object();
    }

    public DowngradeableSafeParcel() {
        this.e = false;
    }

    protected static boolean j0(String s) {
        synchronized(DowngradeableSafeParcel.f) {
        }
        return true;
    }

    protected static Integer k0() {
        synchronized(DowngradeableSafeParcel.f) {
        }
        return null;
    }

    protected boolean l0() {
        return this.e;
    }
}

