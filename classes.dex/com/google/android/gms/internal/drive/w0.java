package com.google.android.gms.internal.drive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class w0 extends u0 {
    private static final Class c;

    static {
        w0.c = Collections.unmodifiableList(Collections.emptyList()).getClass();
    }

    private w0() {
        super(null);
    }

    w0(v0 v00) {
    }

    @Override  // com.google.android.gms.internal.drive.u0
    final void a(Object object0, long v) {
        List list1;
        List list0 = (List)r2.G(object0, v);
        if(list0 instanceof t0) {
            list1 = ((t0)list0).i();
        }
        else {
            Class class0 = list0.getClass();
            if(w0.c.isAssignableFrom(class0)) {
                return;
            }
            list1 = Collections.unmodifiableList(list0);
        }
        r2.g(object0, v, list1);
    }

    @Override  // com.google.android.gms.internal.drive.u0
    final void b(Object object0, Object object1, long v) {
        ArrayList arrayList0;
        List list0 = w0.e(object1, v);
        int v1 = list0.size();
        List list1 = w0.e(object0, v);
        if(list1.isEmpty()) {
            list1 = list1 instanceof t0 ? new s0(v1) : new ArrayList(v1);
            r2.g(object0, v, list1);
        }
        else {
            Class class0 = list1.getClass();
            if(w0.c.isAssignableFrom(class0)) {
                arrayList0 = new ArrayList(list1.size() + v1);
                arrayList0.addAll(list1);
                r2.g(object0, v, arrayList0);
                list1 = arrayList0;
            }
            else if(list1 instanceof o2) {
                arrayList0 = new s0(list1.size() + v1);
                ((f)arrayList0).addAll(((o2)list1));
                r2.g(object0, v, arrayList0);
                list1 = arrayList0;
            }
        }
        int v2 = list1.size();
        if(v2 > 0 && list0.size() > 0) {
            list1.addAll(list0);
        }
        if(v2 > 0) {
            list0 = list1;
        }
        r2.g(object0, v, list0);
    }

    private static List e(Object object0, long v) {
        return (List)r2.G(object0, v);
    }
}

