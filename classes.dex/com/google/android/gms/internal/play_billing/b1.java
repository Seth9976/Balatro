package com.google.android.gms.internal.play_billing;

final class b1 {
    private final Object a;
    private final int b;

    b1(Object object0, int v) {
        this.a = object0;
        this.b = v;
    }

    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof b1 ? this.a == ((b1)object0).a && this.b == ((b1)object0).b : false;
    }

    @Override
    public final int hashCode() {
        return System.identityHashCode(this.a) * 0xFFFF + this.b;
    }
}

