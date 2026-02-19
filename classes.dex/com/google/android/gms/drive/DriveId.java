package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.drive.l0;
import g1.q;
import h1.a;
import n1.c;

public class DriveId extends a implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String e;
    private final long f;
    private final long g;
    private final int h;
    private volatile String i;
    private volatile String j;

    static {
        DriveId.CREATOR = new c();
    }

    public DriveId(String s, long v, long v1, int v2) {
        this.i = null;
        this.j = null;
        this.e = s;
        boolean z = true;
        q.a(!"".equals(s));
        if(s == null && v == -1L) {
            z = false;
        }
        q.a(z);
        this.f = v;
        this.g = v1;
        this.h = v2;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == null || object0.getClass() != DriveId.class || ((DriveId)object0).g != this.g) {
            return false;
        }
        long v = ((DriveId)object0).f;
        if(v == -1L && this.f == -1L) {
            return ((DriveId)object0).e.equals(this.e);
        }
        String s = this.e;
        if(s != null) {
            String s1 = ((DriveId)object0).e;
            return s1 == null ? v == this.f : v == this.f && s1.equals(s);
        }
        return v == this.f;
    }

    @Override
    public int hashCode() {
        if(this.f == -1L) {
            return this.e.hashCode();
        }
        String s = String.valueOf(this.g);
        String s1 = String.valueOf(this.f);
        return s1.length() == 0 ? new String(s).hashCode() : (s + s1).hashCode();
    }

    public final String j0() {
        if(this.i == null) {
            String s = Base64.encodeToString(((com.google.android.gms.internal.drive.a)(((l0)com.google.android.gms.internal.drive.a.w().r(1).o((this.e == null ? "" : this.e)).p(this.f).q(this.g).s(this.h).n()))).g(), 10);
            this.i = s.length() == 0 ? new String("DriveId:") : "DriveId:" + s;
        }
        return this.i;
    }

    @Override
    public String toString() {
        return this.j0();
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = h1.c.a(parcel0);
        h1.c.n(parcel0, 2, this.e, false);
        h1.c.k(parcel0, 3, this.f);
        h1.c.k(parcel0, 4, this.g);
        h1.c.i(parcel0, 5, this.h);
        h1.c.b(parcel0, v1);
    }
}

