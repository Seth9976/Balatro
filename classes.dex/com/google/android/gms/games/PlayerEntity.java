package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import p1.c;
import p1.i0;
import p1.l;
import p1.o;
import p1.p;
import p1.s;
import r1.a;
import r1.b;

public final class PlayerEntity extends GamesDowngradeableSafeParcel implements l {
    private final long A;
    private final i0 B;
    private final s C;
    public static final Parcelable.Creator CREATOR;
    private final boolean D;
    private final String E;
    private final String g;
    private final String h;
    private final Uri i;
    private final Uri j;
    private final long k;
    private final int l;
    private final long m;
    private final String n;
    private final String o;
    private final String p;
    private final a q;
    private final o r;
    private final boolean s;
    private final boolean t;
    private final String u;
    private final String v;
    private final Uri w;
    private final String x;
    private final Uri y;
    private final String z;

    static {
        PlayerEntity.CREATOR = new e();
    }

    PlayerEntity(String s, String s1, Uri uri0, Uri uri1, long v, int v1, long v2, String s2, String s3, String s4, a a0, o o0, boolean z, boolean z1, String s5, String s6, Uri uri2, String s7, Uri uri3, String s8, long v3, i0 i00, s s9, boolean z2, String s10) {
        this.g = s;
        this.h = s1;
        this.i = uri0;
        this.n = s2;
        this.j = uri1;
        this.o = s3;
        this.k = v;
        this.l = v1;
        this.m = v2;
        this.p = s4;
        this.s = z;
        this.q = a0;
        this.r = o0;
        this.t = z1;
        this.u = s5;
        this.v = s6;
        this.w = uri2;
        this.x = s7;
        this.y = uri3;
        this.z = s8;
        this.A = v3;
        this.B = i00;
        this.C = s9;
        this.D = z2;
        this.E = s10;
    }

    public PlayerEntity(l l0) {
        String s = l0.X();
        this.g = s;
        String s1 = l0.k();
        this.h = s1;
        this.i = l0.l();
        this.n = l0.getIconImageUrl();
        this.j = l0.j();
        this.o = l0.getHiResImageUrl();
        long v = l0.M();
        this.k = v;
        this.l = l0.a();
        this.m = l0.A();
        this.p = l0.getTitle();
        this.s = l0.W();
        b b0 = l0.c();
        s s2 = null;
        this.q = b0 == null ? null : new a(b0);
        this.r = l0.N();
        this.t = l0.h();
        this.u = l0.f();
        this.v = l0.d();
        this.w = l0.r();
        this.x = l0.getBannerImageLandscapeUrl();
        this.y = l0.Q();
        this.z = l0.getBannerImagePortraitUrl();
        this.A = l0.b();
        p p0 = l0.P();
        this.B = p0 == null ? null : new i0(((p)p0.D()));
        c c0 = l0.p();
        if(c0 != null) {
            s2 = (s)c0.D();
        }
        this.C = s2;
        this.D = l0.g();
        this.E = l0.e();
        g1.c.a(s);
        g1.c.a(s1);
        g1.c.b(v > 0L);
    }

    @Override  // p1.l
    public long A() {
        return this.m;
    }

    @Override  // p1.l
    public long M() {
        return this.k;
    }

    @Override  // p1.l
    public o N() {
        return this.r;
    }

    @Override  // p1.l
    public p P() {
        return this.B;
    }

    @Override  // p1.l
    public Uri Q() {
        return this.y;
    }

    @Override  // p1.l
    public final boolean W() {
        return this.s;
    }

    @Override  // p1.l
    public String X() {
        return this.g;
    }

    @Override  // p1.l
    public final int a() {
        return this.l;
    }

    @Override  // p1.l
    public final long b() {
        return this.A;
    }

    @Override  // p1.l
    public final b c() {
        return this.q;
    }

    @Override  // p1.l
    public final String d() {
        return this.v;
    }

    @Override  // p1.l
    public final String e() {
        return this.E;
    }

    @Override
    public boolean equals(Object object0) {
        return PlayerEntity.s0(this, object0);
    }

    @Override  // p1.l
    public final String f() {
        return this.u;
    }

    @Override  // p1.l
    public final boolean g() {
        return this.D;
    }

    @Override  // p1.l
    public String getBannerImageLandscapeUrl() {
        return this.x;
    }

    @Override  // p1.l
    public String getBannerImagePortraitUrl() {
        return this.z;
    }

    @Override  // p1.l
    public String getHiResImageUrl() {
        return this.o;
    }

    @Override  // p1.l
    public String getIconImageUrl() {
        return this.n;
    }

    @Override  // p1.l
    public String getTitle() {
        return this.p;
    }

    @Override  // p1.l
    public final boolean h() {
        return this.t;
    }

    @Override
    public int hashCode() {
        return PlayerEntity.n0(this);
    }

    @Override  // p1.l
    public Uri j() {
        return this.j;
    }

    @Override  // p1.l
    public String k() {
        return this.h;
    }

    @Override  // p1.l
    public Uri l() {
        return this.i;
    }

    static int n0(l l0) {
        return g1.o.b(new Object[]{l0.X(), l0.k(), Boolean.valueOf(l0.h()), l0.l(), l0.j(), l0.M(), l0.getTitle(), l0.N(), l0.f(), l0.d(), l0.r(), l0.Q(), l0.b(), l0.P(), l0.p(), Boolean.valueOf(l0.g()), l0.e()});
    }

    @Override  // p1.l
    public c p() {
        return this.C;
    }

    static String p0(l l0) {
        g1.o.a o$a0 = g1.o.c(l0).a("PlayerId", l0.X()).a("DisplayName", l0.k()).a("HasDebugAccess", Boolean.valueOf(l0.h())).a("IconImageUri", l0.l()).a("IconImageUrl", l0.getIconImageUrl()).a("HiResImageUri", l0.j()).a("HiResImageUrl", l0.getHiResImageUrl()).a("RetrievedTimestamp", l0.M()).a("Title", l0.getTitle()).a("LevelInfo", l0.N()).a("GamerTag", l0.f()).a("Name", l0.d()).a("BannerImageLandscapeUri", l0.r()).a("BannerImageLandscapeUrl", l0.getBannerImageLandscapeUrl()).a("BannerImagePortraitUri", l0.Q()).a("BannerImagePortraitUrl", l0.getBannerImagePortraitUrl()).a("CurrentPlayerInfo", l0.p()).a("TotalUnlockedAchievement", l0.b());
        if(l0.g()) {
            o$a0.a("AlwaysAutoSignIn", Boolean.valueOf(l0.g()));
        }
        if(l0.P() != null) {
            o$a0.a("RelationshipInfo", l0.P());
        }
        if(l0.e() != null) {
            o$a0.a("GamePlayerId", l0.e());
        }
        return o$a0.toString();
    }

    @Override  // p1.l
    public Uri r() {
        return this.w;
    }

    // 去混淆评级： 中等(63)
    static boolean s0(l l0, Object object0) {
        if(!(object0 instanceof l)) {
            return false;
        }
        return l0 == object0 ? true : g1.o.a(((l)object0).X(), l0.X()) && g1.o.a(((l)object0).k(), l0.k()) && g1.o.a(Boolean.valueOf(((l)object0).h()), Boolean.valueOf(l0.h())) && g1.o.a(((l)object0).l(), l0.l()) && g1.o.a(((l)object0).j(), l0.j()) && g1.o.a(((l)object0).M(), l0.M()) && g1.o.a(((l)object0).getTitle(), l0.getTitle()) && g1.o.a(((l)object0).N(), l0.N()) && g1.o.a(((l)object0).f(), l0.f()) && g1.o.a(((l)object0).d(), l0.d()) && g1.o.a(((l)object0).r(), l0.r()) && g1.o.a(((l)object0).Q(), l0.Q()) && g1.o.a(((l)object0).b(), l0.b()) && g1.o.a(((l)object0).p(), l0.p()) && g1.o.a(((l)object0).P(), l0.P()) && g1.o.a(Boolean.valueOf(((l)object0).g()), Boolean.valueOf(l0.g())) && g1.o.a(((l)object0).e(), l0.e());
    }

    @Override
    public String toString() {
        return PlayerEntity.p0(this);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        if(this.l0()) {
            parcel0.writeString(this.g);
            parcel0.writeString(this.h);
            String s = null;
            parcel0.writeString((this.i == null ? null : this.i.toString()));
            Uri uri0 = this.j;
            if(uri0 != null) {
                s = uri0.toString();
            }
            parcel0.writeString(s);
            parcel0.writeLong(this.k);
            return;
        }
        int v1 = h1.c.a(parcel0);
        h1.c.n(parcel0, 1, this.X(), false);
        h1.c.n(parcel0, 2, this.k(), false);
        h1.c.m(parcel0, 3, this.l(), v, false);
        h1.c.m(parcel0, 4, this.j(), v, false);
        h1.c.k(parcel0, 5, this.M());
        h1.c.i(parcel0, 6, this.l);
        h1.c.k(parcel0, 7, this.A());
        h1.c.n(parcel0, 8, this.getIconImageUrl(), false);
        h1.c.n(parcel0, 9, this.getHiResImageUrl(), false);
        h1.c.n(parcel0, 14, this.getTitle(), false);
        h1.c.m(parcel0, 15, this.q, v, false);
        h1.c.m(parcel0, 16, this.N(), v, false);
        h1.c.c(parcel0, 18, this.s);
        h1.c.c(parcel0, 19, this.t);
        h1.c.n(parcel0, 20, this.u, false);
        h1.c.n(parcel0, 21, this.v, false);
        h1.c.m(parcel0, 22, this.r(), v, false);
        h1.c.n(parcel0, 23, this.getBannerImageLandscapeUrl(), false);
        h1.c.m(parcel0, 24, this.Q(), v, false);
        h1.c.n(parcel0, 25, this.getBannerImagePortraitUrl(), false);
        h1.c.k(parcel0, 29, this.A);
        h1.c.m(parcel0, 33, this.P(), v, false);
        h1.c.m(parcel0, 35, this.p(), v, false);
        h1.c.c(parcel0, 36, this.D);
        h1.c.n(parcel0, 37, this.E, false);
        h1.c.b(parcel0, v1);
    }
}

