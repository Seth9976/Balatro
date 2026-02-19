package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class d2 extends h2 {
    private static final Class c;

    static {
        d2.c = Collections.unmodifiableList(Collections.emptyList()).getClass();
    }

    d2(c2 c20) {
        super(null);
    }

    @Override  // com.google.android.gms.internal.play_billing.h2
    final void a(Object object0, long v) {
        List list1;
        List list0 = (List)c4.k(object0, v);
        if(list0 instanceof b2) {
            list1 = ((b2)list0).f();
            c4.x(object0, v, list1);
            return;
        }
        Class class0 = list0.getClass();
        if(!d2.c.isAssignableFrom(class0)) {
            if(!(list0 instanceof y2) || !(list0 instanceof u1)) {
                list1 = Collections.unmodifiableList(list0);
                c4.x(object0, v, list1);
            }
            else if(((u1)list0).c()) {
                ((u1)list0).b();
            }
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.h2
    final void b(Object object0, Object object1, long v) {
        ArrayList arrayList0;
        List list0 = (List)c4.k(object1, v);
        int v1 = list0.size();
        List list1 = (List)c4.k(object0, v);
        if(list1.isEmpty()) {
            if(list1 instanceof b2) {
                list1 = new a2(v1);
            }
            else if(!(list1 instanceof y2) || !(list1 instanceof u1)) {
                list1 = new ArrayList(v1);
            }
            else {
                list1 = ((u1)list1).d(v1);
            }
            c4.x(object0, v, list1);
        }
        else {
            Class class0 = list1.getClass();
            if(d2.c.isAssignableFrom(class0)) {
                arrayList0 = new ArrayList(list1.size() + v1);
                arrayList0.addAll(list1);
                c4.x(object0, v, arrayList0);
                list1 = arrayList0;
            }
            else if(list1 instanceof x3) {
                arrayList0 = new a2(list1.size() + v1);
                ((b0)arrayList0).addAll(((a2)arrayList0).size(), ((x3)list1));
                c4.x(object0, v, arrayList0);
                list1 = arrayList0;
            }
            else if(list1 instanceof y2 && list1 instanceof u1 && !((u1)list1).c()) {
                list1 = ((u1)list1).d(list1.size() + v1);
                c4.x(object0, v, list1);
            }
        }
        int v2 = list1.size();
        if(v2 > 0 && list0.size() > 0) {
            list1.addAll(list0);
        }
        if(v2 > 0) {
            list0 = list1;
        }
        c4.x(object0, v, list0);
    }
}

