package s1;

import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import h1.a;
import h1.c;

public final class s extends a {
    public static final Parcelable.Creator CREATOR;
    private final long e;
    private final String f;
    private final int g;
    private final ComponentName h;
    private final String i;

    static {
        s.CREATOR = new t();
    }

    s(long v, String s, int v1, ComponentName componentName0, String s1) {
        this.e = v;
        this.f = s;
        this.g = v1;
        this.h = componentName0;
        this.i = s1;
    }

    public final int a() {
        return this.g;
    }

    public final String b() {
        return this.i;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.k(parcel0, 1, this.e);
        c.n(parcel0, 2, this.f, false);
        c.i(parcel0, 3, this.g);
        c.m(parcel0, 4, this.h, v, false);
        c.n(parcel0, 5, this.i, false);
        c.b(parcel0, v1);
    }
}

