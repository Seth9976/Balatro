package com.google.android.gms.games.internal.v2.appshortcuts;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.PersistableBundle;
import h1.b;

public final class i implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        String s = null;
        PersistableBundle persistableBundle0 = null;
        Boolean boolean0 = null;
        Boolean boolean1 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = b.o(parcel0);
            switch(((char)v1)) {
                case 1: {
                    s = b.e(parcel0, v1);
                    break;
                }
                case 2: {
                    persistableBundle0 = (PersistableBundle)b.d(parcel0, v1, PersistableBundle.CREATOR);
                    break;
                }
                case 3: {
                    boolean0 = b.m(parcel0, v1);
                    break;
                }
                case 4: {
                    boolean1 = b.m(parcel0, v1);
                    break;
                }
                default: {
                    b.u(parcel0, v1);
                }
            }
        }
        b.j(parcel0, v);
        return new h(s, persistableBundle0, boolean0, boolean1);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new h[v];
    }
}

