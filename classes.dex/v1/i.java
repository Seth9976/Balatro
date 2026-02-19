package v1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import g1.o;
import h1.c;
import p1.d;
import p1.l;
import q1.r;

public final class i extends r implements e {
    public static final Parcelable.Creator CREATOR;
    private final GameEntity e;
    private final PlayerEntity f;
    private final String g;
    private final Uri h;
    private final String i;
    private final String j;
    private final String k;
    private final long l;
    private final long m;
    private final float n;
    private final String o;
    private final boolean p;
    private final long q;
    private final String r;

    static {
        i.CREATOR = new n();
    }

    i(GameEntity gameEntity0, PlayerEntity playerEntity0, String s, Uri uri0, String s1, String s2, String s3, long v, long v1, float f, String s4, boolean z, long v2, String s5) {
        this.e = gameEntity0;
        this.f = playerEntity0;
        this.g = s;
        this.h = uri0;
        this.i = s1;
        this.n = f;
        this.j = s2;
        this.k = s3;
        this.l = v;
        this.m = v1;
        this.o = s4;
        this.p = z;
        this.q = v2;
        this.r = s5;
    }

    public i(e e0) {
        PlayerEntity playerEntity0 = new PlayerEntity(e0.F());
        super();
        this.e = new GameEntity(e0.i0());
        this.f = playerEntity0;
        this.g = e0.f0();
        this.h = e0.y();
        this.i = e0.getCoverImageUrl();
        this.n = e0.R();
        this.j = e0.a();
        this.k = e0.i();
        this.l = e0.T();
        this.m = e0.E();
        this.o = e0.Y();
        this.p = e0.c0();
        this.q = e0.O();
        this.r = e0.n();
    }

    @Override  // v1.e
    public long E() {
        return this.m;
    }

    @Override  // v1.e
    public l F() {
        return this.f;
    }

    @Override  // v1.e
    public long O() {
        return this.q;
    }

    @Override  // v1.e
    public float R() {
        return this.n;
    }

    @Override  // v1.e
    public long T() {
        return this.l;
    }

    @Override  // v1.e
    public String Y() {
        return this.o;
    }

    @Override  // v1.e
    public final String a() {
        return this.j;
    }

    @Override  // v1.e
    public boolean c0() {
        return this.p;
    }

    @Override
    public boolean equals(Object object0) {
        return i.l0(this, object0);
    }

    @Override  // v1.e
    public String f0() {
        return this.g;
    }

    @Override  // v1.e
    public String getCoverImageUrl() {
        return this.i;
    }

    @Override
    public int hashCode() {
        return i.j0(this);
    }

    @Override  // v1.e
    public String i() {
        return this.k;
    }

    @Override  // v1.e
    public d i0() {
        return this.e;
    }

    static int j0(e e0) {
        return o.b(new Object[]{e0.i0(), e0.F(), e0.f0(), e0.y(), e0.R(), e0.a(), e0.i(), e0.T(), e0.E(), e0.Y(), Boolean.valueOf(e0.c0()), e0.O(), e0.n()});
    }

    static String k0(e e0) {
        return o.c(e0).a("Game", e0.i0()).a("Owner", e0.F()).a("SnapshotId", e0.f0()).a("CoverImageUri", e0.y()).a("CoverImageUrl", e0.getCoverImageUrl()).a("CoverImageAspectRatio", e0.R()).a("Description", e0.i()).a("LastModifiedTimestamp", e0.T()).a("PlayedTime", e0.E()).a("UniqueName", e0.Y()).a("ChangePending", Boolean.valueOf(e0.c0())).a("ProgressValue", e0.O()).a("DeviceName", e0.n()).toString();
    }

    // 去混淆评级： 中等(50)
    static boolean l0(e e0, Object object0) {
        if(!(object0 instanceof e)) {
            return false;
        }
        return e0 == object0 ? true : o.a(((e)object0).i0(), e0.i0()) && o.a(((e)object0).F(), e0.F()) && o.a(((e)object0).f0(), e0.f0()) && o.a(((e)object0).y(), e0.y()) && o.a(((e)object0).R(), e0.R()) && o.a(((e)object0).a(), e0.a()) && o.a(((e)object0).i(), e0.i()) && o.a(((e)object0).T(), e0.T()) && o.a(((e)object0).E(), e0.E()) && o.a(((e)object0).Y(), e0.Y()) && o.a(Boolean.valueOf(((e)object0).c0()), Boolean.valueOf(e0.c0())) && o.a(((e)object0).O(), e0.O()) && o.a(((e)object0).n(), e0.n());
    }

    @Override  // v1.e
    public String n() {
        return this.r;
    }

    @Override
    public String toString() {
        return i.k0(this);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = c.a(parcel0);
        c.m(parcel0, 1, this.i0(), v, false);
        c.m(parcel0, 2, this.F(), v, false);
        c.n(parcel0, 3, this.f0(), false);
        c.m(parcel0, 5, this.y(), v, false);
        c.n(parcel0, 6, this.getCoverImageUrl(), false);
        c.n(parcel0, 7, this.j, false);
        c.n(parcel0, 8, this.i(), false);
        c.k(parcel0, 9, this.T());
        c.k(parcel0, 10, this.E());
        c.g(parcel0, 11, this.R());
        c.n(parcel0, 12, this.Y(), false);
        c.c(parcel0, 13, this.c0());
        c.k(parcel0, 14, this.O());
        c.n(parcel0, 15, this.n(), false);
        c.b(parcel0, v1);
    }

    @Override  // v1.e
    public Uri y() {
        return this.h;
    }
}

