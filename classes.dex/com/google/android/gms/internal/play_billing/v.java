package com.google.android.gms.internal.play_billing;

import java.util.Set;

public abstract class v {
    static int a(Set set0) {
        int v = 0;
        for(Object object0: set0) {
            v += (object0 == null ? 0 : object0.hashCode());
        }
        return v;
    }
}

