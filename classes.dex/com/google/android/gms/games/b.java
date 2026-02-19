package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import p1.c;
import p1.e0;
import p1.k0;
import p1.l;
import p1.n;
import p1.o;
import p1.p;
import p1.u;
import r1.d;
import r1.e;

public final class b extends e0 implements l {
    private final e h;
    private final o i;
    private final d j;
    private final k0 k;
    private final u l;

    public b(DataHolder dataHolder0, int v, String s) {
        super(dataHolder0, v);
        e e0 = new e(null);
        this.h = e0;
        this.j = new d(dataHolder0, v, e0);
        this.k = new k0(dataHolder0, v, e0);
        this.l = new u(dataHolder0, v, e0);
        if(!this.K(e0.k) && this.z(e0.k) != -1L) {
            int v1 = this.x(e0.l);
            int v2 = this.x(e0.o);
            n n0 = new n(v1, this.z(e0.m), this.z(e0.n));
            n n1 = v1 == v2 ? n0 : new n(v2, this.z(e0.n), this.z(e0.p));
            this.i = new o(this.z(e0.k), this.z(e0.q), n0, n1);
            return;
        }
        this.i = null;
    }

    // 去混淆评级： 低(20)
    @Override  // p1.l
    public final long A() {
        return !this.H(this.h.j) || this.K(this.h.j) ? -1L : this.z(this.h.j);
    }

    @Override  // p1.l
    public final long M() {
        return this.z(this.h.h);
    }

    @Override  // p1.l
    public final o N() {
        return this.i;
    }

    @Override  // p1.l
    public final p P() {
        return this.k.J() == -1 && this.k.b() == null && this.k.a() == null ? null : this.k;
    }

    @Override  // p1.l
    public final Uri Q() {
        return this.U(this.h.E);
    }

    @Override  // p1.l
    public final boolean W() {
        return this.o(this.h.s);
    }

    @Override  // p1.l
    public final String X() {
        return this.C(this.h.a);
    }

    @Override  // p1.l
    public final int a() {
        return this.x(this.h.i);
    }

    @Override  // p1.l
    public final long b() {
        String s = this.h.G;
        return !this.H(s) || this.K(s) ? -1L : this.z(s);
    }

    @Override  // p1.l
    public final r1.b c() {
        return this.K(this.h.t) ? null : this.j;
    }

    @Override  // p1.l
    public final String d() {
        return this.C(this.h.B);
    }

    @Override  // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override  // p1.l
    public final String e() {
        return this.g0(this.h.b, null);
    }

    @Override
    public final boolean equals(Object object0) {
        return PlayerEntity.s0(this, object0);
    }

    @Override  // p1.l
    public final String f() {
        return this.C(this.h.A);
    }

    // 去混淆评级： 低(20)
    @Override  // p1.l
    public final boolean g() {
        return this.H(this.h.M) && this.o(this.h.M);
    }

    @Override  // p1.l
    public String getBannerImageLandscapeUrl() {
        return this.C(this.h.D);
    }

    @Override  // p1.l
    public String getBannerImagePortraitUrl() {
        return this.C(this.h.F);
    }

    @Override  // p1.l
    public String getHiResImageUrl() {
        return this.C(this.h.g);
    }

    @Override  // p1.l
    public String getIconImageUrl() {
        return this.C(this.h.e);
    }

    @Override  // p1.l
    public final String getTitle() {
        return this.C(this.h.r);
    }

    @Override  // p1.l
    public final boolean h() {
        return this.o(this.h.z);
    }

    @Override
    public final int hashCode() {
        return PlayerEntity.n0(this);
    }

    @Override  // p1.l
    public final Uri j() {
        return this.U(this.h.f);
    }

    @Override  // p1.l
    public final String k() {
        return this.C(this.h.c);
    }

    @Override  // p1.l
    public final Uri l() {
        return this.U(this.h.d);
    }

    @Override  // p1.l
    public final c p() {
        return this.l.j0() ? this.l : null;
    }

    @Override  // p1.l
    public final Uri r() {
        return this.U(this.h.C);
    }

    @Override
    public final String toString() {
        return PlayerEntity.p0(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        new PlayerEntity(this).writeToParcel(parcel0, v);
    }
}

