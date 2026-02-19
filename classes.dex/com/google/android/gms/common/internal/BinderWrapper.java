package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.Parcelable;
import g1.d1;

public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator CREATOR;
    private final IBinder e;

    static {
        BinderWrapper.CREATOR = new a();
    }

    public BinderWrapper(IBinder iBinder0) {
        this.e = iBinder0;
    }

    BinderWrapper(Parcel parcel0, d1 d10) {
        this.e = parcel0.readStrongBinder();
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        parcel0.writeStrongBinder(this.e);
    }
}

