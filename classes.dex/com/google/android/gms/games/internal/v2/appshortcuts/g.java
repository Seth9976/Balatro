package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.pm.ShortcutInfo;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.b;
import java.util.List;

public final class g implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        List list0 = null;
        List list1 = null;
        List list2 = null;
        List list3 = null;
        while(parcel0.dataPosition() < v) {
            int v1 = b.o(parcel0);
            switch(((char)v1)) {
                case 1: {
                    list0 = b.g(parcel0, v1);
                    break;
                }
                case 2: {
                    list1 = b.i(parcel0, v1, ShortcutInfo.CREATOR);
                    break;
                }
                case 3: {
                    list2 = b.g(parcel0, v1);
                    break;
                }
                case 4: {
                    list3 = b.g(parcel0, v1);
                    break;
                }
                default: {
                    b.u(parcel0, v1);
                }
            }
        }
        b.j(parcel0, v);
        return new f(list0, list1, list2, list3);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new f[v];
    }
}

