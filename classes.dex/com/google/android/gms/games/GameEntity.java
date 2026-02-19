package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import g1.o;
import p1.d;

public final class GameEntity extends GamesDowngradeableSafeParcel implements d {
    private final boolean A;
    private final boolean B;
    private final boolean C;
    public static final Parcelable.Creator CREATOR;
    private final String D;
    private final boolean E;
    private final boolean F;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private final Uri m;
    private final Uri n;
    private final Uri o;
    private final boolean p;
    private final boolean q;
    private final String r;
    private final int s;
    private final int t;
    private final int u;
    private final boolean v;
    private final boolean w;
    private final String x;
    private final String y;
    private final String z;

    static {
        GameEntity.CREATOR = new c();
    }

    GameEntity(String s, String s1, String s2, String s3, String s4, String s5, Uri uri0, Uri uri1, Uri uri2, boolean z, boolean z1, String s6, int v, int v1, int v2, boolean z2, boolean z3, String s7, String s8, String s9, boolean z4, boolean z5, boolean z6, String s10, boolean z7, boolean z8) {
        this.g = s;
        this.h = s1;
        this.i = s2;
        this.j = s3;
        this.k = s4;
        this.l = s5;
        this.m = uri0;
        this.x = s7;
        this.n = uri1;
        this.y = s8;
        this.o = uri2;
        this.z = s9;
        this.p = z;
        this.q = z1;
        this.r = s6;
        this.s = v;
        this.t = v1;
        this.u = v2;
        this.v = z2;
        this.w = z3;
        this.A = z4;
        this.B = z5;
        this.C = z6;
        this.D = s10;
        this.E = z7;
        this.F = z8;
    }

    public GameEntity(d d0) {
        this.g = d0.B();
        this.i = d0.L();
        this.j = d0.w();
        this.k = d0.i();
        this.l = d0.m();
        this.h = d0.k();
        this.m = d0.l();
        this.x = d0.getIconImageUrl();
        this.n = d0.j();
        this.y = d0.getHiResImageUrl();
        this.o = d0.d0();
        this.z = d0.getFeaturedImageUrl();
        this.p = d0.f();
        this.q = d0.c();
        this.r = d0.a();
        this.s = 1;
        this.t = d0.v();
        this.u = d0.q();
        this.v = d0.h();
        this.w = d0.g();
        this.A = d0.e();
        this.B = d0.b();
        this.C = d0.e0();
        this.D = d0.S();
        this.E = d0.I();
        this.F = d0.d();
    }

    @Override  // p1.d
    public String B() {
        return this.g;
    }

    @Override  // p1.d
    public boolean I() {
        return this.E;
    }

    @Override  // p1.d
    public String L() {
        return this.i;
    }

    @Override  // p1.d
    public String S() {
        return this.D;
    }

    @Override  // p1.d
    public final String a() {
        return this.r;
    }

    @Override  // p1.d
    public final boolean b() {
        return this.B;
    }

    @Override  // p1.d
    public final boolean c() {
        return this.q;
    }

    @Override  // p1.d
    public final boolean d() {
        return this.F;
    }

    @Override  // p1.d
    public Uri d0() {
        return this.o;
    }

    @Override  // p1.d
    public final boolean e() {
        return this.A;
    }

    @Override  // p1.d
    public boolean e0() {
        return this.C;
    }

    @Override
    public boolean equals(Object object0) {
        return GameEntity.s0(this, object0);
    }

    @Override  // p1.d
    public final boolean f() {
        return this.p;
    }

    @Override  // p1.d
    public final boolean g() {
        return this.w;
    }

    @Override  // p1.d
    public String getFeaturedImageUrl() {
        return this.z;
    }

    @Override  // p1.d
    public String getHiResImageUrl() {
        return this.y;
    }

    @Override  // p1.d
    public String getIconImageUrl() {
        return this.x;
    }

    @Override  // p1.d
    public final boolean h() {
        return this.v;
    }

    @Override
    public int hashCode() {
        return GameEntity.n0(this);
    }

    @Override  // p1.d
    public String i() {
        return this.k;
    }

    @Override  // p1.d
    public Uri j() {
        return this.n;
    }

    @Override  // p1.d
    public String k() {
        return this.h;
    }

    @Override  // p1.d
    public Uri l() {
        return this.m;
    }

    @Override  // p1.d
    public String m() {
        return this.l;
    }

    static int n0(d d0) {
        return o.b(new Object[]{d0.B(), d0.k(), d0.L(), d0.w(), d0.i(), d0.m(), d0.l(), d0.j(), d0.d0(), Boolean.valueOf(d0.f()), Boolean.valueOf(d0.c()), d0.a(), d0.v(), d0.q(), Boolean.valueOf(d0.h()), Boolean.valueOf(d0.g()), Boolean.valueOf(d0.e()), Boolean.valueOf(d0.b()), Boolean.valueOf(d0.e0()), d0.S(), Boolean.valueOf(d0.I()), Boolean.valueOf(d0.d())});
    }

    static String p0(d d0) {
        return o.c(d0).a("ApplicationId", d0.B()).a("DisplayName", d0.k()).a("PrimaryCategory", d0.L()).a("SecondaryCategory", d0.w()).a("Description", d0.i()).a("DeveloperName", d0.m()).a("IconImageUri", d0.l()).a("IconImageUrl", d0.getIconImageUrl()).a("HiResImageUri", d0.j()).a("HiResImageUrl", d0.getHiResImageUrl()).a("FeaturedImageUri", d0.d0()).a("FeaturedImageUrl", d0.getFeaturedImageUrl()).a("PlayEnabledGame", Boolean.valueOf(d0.f())).a("InstanceInstalled", Boolean.valueOf(d0.c())).a("InstancePackageName", d0.a()).a("AchievementTotalCount", d0.v()).a("LeaderboardCount", d0.q()).a("AreSnapshotsEnabled", Boolean.valueOf(d0.e0())).a("ThemeColor", d0.S()).a("HasGamepadSupport", Boolean.valueOf(d0.I())).toString();
    }

    @Override  // p1.d
    public int q() {
        return this.u;
    }

    // 去混淆评级： 低(38)
    static boolean s0(d d0, Object object0) {
        if(!(object0 instanceof d)) {
            return false;
        }
        if(d0 == object0) {
            return true;
        }
        d d1 = (d)object0;
        return o.a(d1.B(), d0.B()) && o.a(d1.k(), d0.k()) && o.a(d1.L(), d0.L()) && o.a(d1.w(), d0.w()) && o.a(d1.i(), d0.i()) && o.a(d1.m(), d0.m()) && o.a(d1.l(), d0.l()) && o.a(d1.j(), d0.j()) && o.a(d1.d0(), d0.d0()) && o.a(Boolean.valueOf(d1.f()), Boolean.valueOf(d0.f())) && o.a(Boolean.valueOf(d1.c()), Boolean.valueOf(d0.c())) && o.a(d1.a(), d0.a()) && o.a(d1.v(), d0.v()) && o.a(d1.q(), d0.q()) && o.a(Boolean.valueOf(d1.h()), Boolean.valueOf(d0.h())) && o.a(Boolean.valueOf(d1.g()), Boolean.valueOf(d0.g())) && o.a(Boolean.valueOf(d1.e()), Boolean.valueOf(d0.e())) && o.a(Boolean.valueOf(d1.b()), Boolean.valueOf(d0.b())) && o.a(Boolean.valueOf(d1.e0()), Boolean.valueOf(d0.e0())) && o.a(d1.S(), d0.S()) && o.a(Boolean.valueOf(d1.I()), Boolean.valueOf(d0.I())) && o.a(Boolean.valueOf(d1.d()), Boolean.valueOf(d0.d()));
    }

    @Override
    public String toString() {
        return GameEntity.p0(this);
    }

    @Override  // p1.d
    public int v() {
        return this.t;
    }

    @Override  // p1.d
    public String w() {
        return this.j;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        if(this.l0()) {
            parcel0.writeString(this.g);
            parcel0.writeString(this.h);
            parcel0.writeString(this.i);
            parcel0.writeString(this.j);
            parcel0.writeString(this.k);
            parcel0.writeString(this.l);
            String s = null;
            parcel0.writeString((this.m == null ? null : this.m.toString()));
            parcel0.writeString((this.n == null ? null : this.n.toString()));
            Uri uri0 = this.o;
            if(uri0 != null) {
                s = uri0.toString();
            }
            parcel0.writeString(s);
            parcel0.writeInt(((int)this.p));
            parcel0.writeInt(((int)this.q));
            parcel0.writeString(this.r);
            parcel0.writeInt(this.s);
            parcel0.writeInt(this.t);
            parcel0.writeInt(this.u);
            return;
        }
        int v1 = h1.c.a(parcel0);
        h1.c.n(parcel0, 1, this.B(), false);
        h1.c.n(parcel0, 2, this.k(), false);
        h1.c.n(parcel0, 3, this.L(), false);
        h1.c.n(parcel0, 4, this.w(), false);
        h1.c.n(parcel0, 5, this.i(), false);
        h1.c.n(parcel0, 6, this.m(), false);
        h1.c.m(parcel0, 7, this.l(), v, false);
        h1.c.m(parcel0, 8, this.j(), v, false);
        h1.c.m(parcel0, 9, this.d0(), v, false);
        h1.c.c(parcel0, 10, this.p);
        h1.c.c(parcel0, 11, this.q);
        h1.c.n(parcel0, 12, this.r, false);
        h1.c.i(parcel0, 13, this.s);
        h1.c.i(parcel0, 14, this.v());
        h1.c.i(parcel0, 15, this.q());
        h1.c.c(parcel0, 16, this.v);
        h1.c.c(parcel0, 17, this.w);
        h1.c.n(parcel0, 18, this.getIconImageUrl(), false);
        h1.c.n(parcel0, 19, this.getHiResImageUrl(), false);
        h1.c.n(parcel0, 20, this.getFeaturedImageUrl(), false);
        h1.c.c(parcel0, 21, this.A);
        h1.c.c(parcel0, 22, this.B);
        h1.c.c(parcel0, 23, this.e0());
        h1.c.n(parcel0, 24, this.S(), false);
        h1.c.c(parcel0, 25, this.I());
        h1.c.c(parcel0, 28, this.F);
        h1.c.b(parcel0, v1);
    }
}

