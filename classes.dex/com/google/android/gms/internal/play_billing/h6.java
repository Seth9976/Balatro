package com.google.android.gms.internal.play_billing;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;

public abstract class h6 {
    private static final ClassLoader a;

    static {
        h6.a = h6.class.getClassLoader();
    }

    public static Parcelable a(Parcel parcel0, Parcelable.Creator parcelable$Creator0) {
        return parcel0.readInt() == 0 ? null : ((Parcelable)parcelable$Creator0.createFromParcel(parcel0));
    }

    public static void b(Parcel parcel0, Parcelable parcelable0) {
        parcel0.writeInt(1);
        parcelable0.writeToParcel(parcel0, 0);
    }
}

