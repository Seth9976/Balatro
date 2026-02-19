package com.google.android.gms.internal.play_billing;

import h.d;
import java.util.Collections;
import java.util.Map;

public final class c1 {
    private final Map a;
    private static volatile c1 b;
    static final c1 c;

    static {
        c1.c = new c1(true);
    }

    c1(boolean z) {
        this.a = Collections.emptyMap();
    }

    public static c1 a() {
        c1 c10 = c1.b;
        if(c10 != null) {
            return c10;
        }
        synchronized(c1.class) {
            c1 c11 = c1.b;
            if(c11 != null) {
                return c11;
            }
            c1 c12 = j1.a(c1.class);
            c1.b = c12;
            return c12;
        }
    }

    public final m1 b(r2 r20, int v) {
        b1 b10 = new b1(r20, v);
        d.a(this.a.get(b10));
        return null;
    }
}

