package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import d1.b;
import g2.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.WeakHashMap;

public final class g {
    private final Map a;
    private final Map b;

    public g() {
        this.a = Collections.synchronizedMap(new WeakHashMap());
        this.b = Collections.synchronizedMap(new WeakHashMap());
    }

    final void c(BasePendingResult basePendingResult0, boolean z) {
        this.a.put(basePendingResult0, Boolean.valueOf(z));
        basePendingResult0.c(new e(this, basePendingResult0));
    }

    final void d(i i0, boolean z) {
        this.b.put(i0, Boolean.valueOf(z));
        i0.a().c(new f(this, i0));
    }

    final void e(int v, String s) {
        StringBuilder stringBuilder0 = new StringBuilder("The connection to Google Play services was lost");
        if(v == 1) {
            stringBuilder0.append(" due to service disconnection.");
        }
        else if(v == 3) {
            stringBuilder0.append(" due to dead object exception.");
        }
        if(s != null) {
            stringBuilder0.append(" Last reason for disconnect: ");
            stringBuilder0.append(s);
        }
        this.h(true, new Status(20, stringBuilder0.toString()));
    }

    public final void f() {
        this.h(false, c.p);
    }

    // 去混淆评级： 低(20)
    final boolean g() {
        return !this.a.isEmpty() || !this.b.isEmpty();
    }

    private final void h(boolean z, Status status0) {
        synchronized(this.a) {
            HashMap hashMap0 = new HashMap(this.a);
        }
        synchronized(this.b) {
            HashMap hashMap1 = new HashMap(this.b);
        }
        for(Object object0: hashMap0.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            if(z || ((Boolean)map$Entry0.getValue()).booleanValue()) {
                ((BasePendingResult)map$Entry0.getKey()).f(status0);
            }
        }
        for(Object object1: hashMap1.entrySet()) {
            Map.Entry map$Entry1 = (Map.Entry)object1;
            if(z || ((Boolean)map$Entry1.getValue()).booleanValue()) {
                ((i)map$Entry1.getKey()).d(new b(status0));
            }
        }
    }
}

