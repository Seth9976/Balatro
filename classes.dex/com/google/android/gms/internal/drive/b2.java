package com.google.android.gms.internal.drive;

import java.util.Iterator;

abstract class b2 {
    private static final Iterator a;
    private static final Iterable b;

    static {
        b2.a = new c2();
        b2.b = new d2();
    }

    static Iterable a() {
        return b2.b;
    }
}

