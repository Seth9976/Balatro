package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import h1.b;

public final class a implements Parcelable.Creator {
    @Override  // android.os.Parcelable$Creator
    public final Object createFromParcel(Parcel parcel0) {
        int v = b.v(parcel0);
        int v1 = 0;
        ParcelFileDescriptor parcelFileDescriptor0 = null;
        int v2 = 0;
        while(parcel0.dataPosition() < v) {
            int v3 = b.o(parcel0);
            switch(((char)v3)) {
                case 1: {
                    v1 = b.q(parcel0, v3);
                    break;
                }
                case 2: {
                    parcelFileDescriptor0 = (ParcelFileDescriptor)b.d(parcel0, v3, ParcelFileDescriptor.CREATOR);
                    break;
                }
                case 3: {
                    v2 = b.q(parcel0, v3);
                    break;
                }
                default: {
                    b.u(parcel0, v3);
                }
            }
        }
        b.j(parcel0, v);
        return new BitmapTeleporter(v1, parcelFileDescriptor0, v2);
    }

    @Override  // android.os.Parcelable$Creator
    public final Object[] newArray(int v) {
        return new BitmapTeleporter[v];
    }
}

