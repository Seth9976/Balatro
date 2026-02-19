package com.google.android.gms.internal.drive;

import java.util.Comparator;

final class k implements Comparator {
    @Override
    public final int compare(Object object0, Object object1) {
        p p0 = (p)((i)object0).iterator();
        p p1 = (p)((i)object1).iterator();
        while(p0.hasNext() && p1.hasNext()) {
            int v = Integer.compare(i.r(p0.c()), i.r(p1.c()));
            if(v != 0) {
                return v;
            }
            if(false) {
                break;
            }
        }
        return Integer.compare(((i)object0).size(), ((i)object1).size());
    }
}

