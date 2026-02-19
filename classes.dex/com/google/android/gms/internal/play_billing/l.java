package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

public final class l {
    Object[] a;
    int b;
    k c;

    public l() {
        this.a = new Object[8];
        this.b = 0;
    }

    public final l a(Object object0, Object object1) {
        int v = this.b + 1;
        Object[] arr_object = this.a;
        int v1 = v + v;
        if(v1 > arr_object.length) {
            int v2 = arr_object.length + (arr_object.length >> 1) + 1;
            if(v2 < v1) {
                int v3 = Integer.highestOneBit(v1 - 1);
                v2 = v3 + v3;
            }
            if(v2 < 0) {
                v2 = 0x7FFFFFFF;
            }
            this.a = Arrays.copyOf(arr_object, v2);
        }
        e.a(object0, object1);
        Object[] arr_object1 = this.a;
        int v4 = this.b;
        int v5 = v4 + v4;
        arr_object1[v5] = object0;
        arr_object1[v5 + 1] = object1;
        this.b = v4 + 1;
        return this;
    }

    public final m b() {
        k k0 = this.c;
        if(k0 != null) {
            throw k0.a();
        }
        m m0 = u.g(this.b, this.a, this);
        k k1 = this.c;
        if(k1 != null) {
            throw k1.a();
        }
        return m0;
    }
}

