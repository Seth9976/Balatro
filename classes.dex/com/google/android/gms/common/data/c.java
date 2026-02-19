package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;

public final class c implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        String[] arr_s = null;
        CursorWindow[] arr_cursorWindow = null;
        Bundle bundle0 = null;
        int v1 = 0;
        int v2 = 0;
        while(parcel0.dataPosition() < v) {
            int v3 = b.o(parcel0);
            switch(((char)v3)) {
                case 1: {
                    arr_s = b.f(parcel0, v3);
                    break;
                }
                case 2: {
                    arr_cursorWindow = (CursorWindow[])b.h(parcel0, v3, CursorWindow.CREATOR);
                    break;
                }
                case 3: {
                    v2 = b.q(parcel0, v3);
                    break;
                }
                case 4: {
                    bundle0 = b.b(parcel0, v3);
                    break;
                }
                case 1000: {
                    v1 = b.q(parcel0, v3);
                    break;
                }
                default: {
                    b.u(parcel0, v3);
                }
            }
        }
        b.j(parcel0, v);
        DataHolder dataHolder0 = new DataHolder(v1, arr_s, arr_cursorWindow, v2, bundle0);
        dataHolder0.t0();
        return dataHolder0;
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new DataHolder[v];
    }
}

