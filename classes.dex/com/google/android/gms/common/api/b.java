package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import c1.a;

public final class b implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = h1.b.v(parcel0);
        String s = null;
        a a0 = null;
        int v1 = 0;
        PendingIntent pendingIntent0 = null;
        while(parcel0.dataPosition() < v) {
            int v2 = h1.b.o(parcel0);
            switch(((char)v2)) {
                case 1: {
                    v1 = h1.b.q(parcel0, v2);
                    break;
                }
                case 2: {
                    s = h1.b.e(parcel0, v2);
                    break;
                }
                case 3: {
                    pendingIntent0 = (PendingIntent)h1.b.d(parcel0, v2, PendingIntent.CREATOR);
                    break;
                }
                case 4: {
                    a0 = (a)h1.b.d(parcel0, v2, a.CREATOR);
                    break;
                }
                default: {
                    h1.b.u(parcel0, v2);
                }
            }
        }
        h1.b.j(parcel0, v);
        return new Status(v1, s, pendingIntent0, a0);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new Status[v];
    }
}

