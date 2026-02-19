package com.google.android.gms.internal.play_billing;

import java.util.Comparator;

final class h0 implements Comparator {
    @Override
    public final int compare(Object object0, Object object1) {
        g0 g00 = new g0(((q0)object0));
        g0 g01 = new g0(((q0)object1));
        while(g00.hasNext() && g01.hasNext()) {
            int v = ((int)(g00.a() & 0xFF)).compareTo(((int)(g01.a() & 0xFF)));
            if(v != 0) {
                return v;
            }
            if(false) {
                break;
            }
        }
        return ((q0)object0).o().compareTo(((q0)object1).o());
    }
}

