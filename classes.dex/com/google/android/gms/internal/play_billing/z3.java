package com.google.android.gms.internal.play_billing;

import sun.misc.Unsafe;

final class z3 extends b4 {
    z3(Unsafe unsafe0) {
        super(unsafe0);
    }

    @Override  // com.google.android.gms.internal.play_billing.b4
    public final double a(Object object0, long v) {
        return Double.longBitsToDouble(this.a.getLong(object0, v));
    }

    @Override  // com.google.android.gms.internal.play_billing.b4
    public final float b(Object object0, long v) {
        return Float.intBitsToFloat(this.a.getInt(object0, v));
    }

    @Override  // com.google.android.gms.internal.play_billing.b4
    public final void c(Object object0, long v, boolean z) {
        if(c4.h) {
            c4.n(object0, v, z);
            return;
        }
        c4.o(object0, v, z);
    }

    @Override  // com.google.android.gms.internal.play_billing.b4
    public final void d(Object object0, long v, byte b) {
        if(c4.h) {
            c4.d(object0, v, b);
            return;
        }
        c4.e(object0, v, b);
    }

    @Override  // com.google.android.gms.internal.play_billing.b4
    public final void e(Object object0, long v, double f) {
        this.a.putLong(object0, v, Double.doubleToLongBits(f));
    }

    @Override  // com.google.android.gms.internal.play_billing.b4
    public final void f(Object object0, long v, float f) {
        this.a.putInt(object0, v, Float.floatToIntBits(f));
    }

    // 去混淆评级： 低(20)
    @Override  // com.google.android.gms.internal.play_billing.b4
    public final boolean g(Object object0, long v) {
        return c4.h ? c4.y(object0, v) : c4.z(object0, v);
    }
}

