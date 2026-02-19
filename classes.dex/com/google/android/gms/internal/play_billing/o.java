package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

public abstract class o {
    public static Object a(Iterable iterable0, Object object0) {
        Iterator iterator0 = iterable0.iterator();
        return iterator0.hasNext() ? iterator0.next() : null;
    }
}

