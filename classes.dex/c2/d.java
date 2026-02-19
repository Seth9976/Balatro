package c2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import q1.r;

public final class d extends r {
    public static final Parcelable.Creator CREATOR;
    private final Bundle e;
    private final IBinder f;

    static {
        d.CREATOR = new e();
    }

    d(Bundle bundle0, IBinder iBinder0) {
        this.e = bundle0;
        this.f = iBinder0;
    }

    public d(c c0) {
        this.e = c0.a();
        this.f = c0.a;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = h1.c.a(parcel0);
        h1.c.f(parcel0, 1, this.e, false);
        h1.c.h(parcel0, 2, this.f, false);
        h1.c.b(parcel0, v1);
    }
}

