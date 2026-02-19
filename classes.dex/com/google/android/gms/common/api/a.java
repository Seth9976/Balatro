package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class a implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        String s = null;
        int v1 = 0;
        while(parcel0.dataPosition() < v) {
            int v2 = b.o(parcel0);
            switch(((char)v2)) {
                case 1: {
                    v1 = b.q(parcel0, v2);
                    break;
                }
                case 2: {
                    s = b.e(parcel0, v2);
                    break;
                }
                default: {
                    b.u(parcel0, v2);
                }
            }
        }
        b.j(parcel0, v);
        return new Scope(v1, s);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new Scope[v];
    }
}

