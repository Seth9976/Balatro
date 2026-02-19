package r1;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.o;
import q1.r;

public final class a extends r implements b {
    public static final Parcelable.Creator CREATOR;
    private final String e;
    private final String f;
    private final long g;
    private final Uri h;
    private final Uri i;
    private final Uri j;

    static {
        a.CREATOR = new c();
    }

    a(String s, String s1, long v, Uri uri0, Uri uri1, Uri uri2) {
        this.e = s;
        this.f = s1;
        this.g = v;
        this.h = uri0;
        this.i = uri1;
        this.j = uri2;
    }

    public a(b b0) {
        this.e = b0.f();
        this.f = b0.d();
        this.g = b0.a();
        this.h = b0.e();
        this.i = b0.c();
        this.j = b0.b();
    }

    @Override  // r1.b
    public final long a() {
        return this.g;
    }

    @Override  // r1.b
    public final Uri b() {
        return this.j;
    }

    @Override  // r1.b
    public final Uri c() {
        return this.i;
    }

    @Override  // r1.b
    public final String d() {
        return this.f;
    }

    @Override  // r1.b
    public final Uri e() {
        return this.h;
    }

    @Override
    public final boolean equals(Object object0) {
        return a.l0(this, object0);
    }

    @Override  // r1.b
    public final String f() {
        return this.e;
    }

    @Override
    public final int hashCode() {
        return a.j0(this);
    }

    static int j0(b b0) {
        return o.b(new Object[]{b0.f(), b0.d(), b0.a(), b0.e(), b0.c(), b0.b()});
    }

    static String k0(b b0) {
        return o.c(b0).a("GameId", b0.f()).a("GameName", b0.d()).a("ActivityTimestampMillis", b0.a()).a("GameIconUri", b0.e()).a("GameHiResUri", b0.c()).a("GameFeaturedUri", b0.b()).toString();
    }

    // 去混淆评级： 低(26)
    static boolean l0(b b0, Object object0) {
        if(!(object0 instanceof b)) {
            return false;
        }
        return b0 == object0 ? true : o.a(((b)object0).f(), b0.f()) && o.a(((b)object0).d(), b0.d()) && o.a(((b)object0).a(), b0.a()) && o.a(((b)object0).e(), b0.e()) && o.a(((b)object0).c(), b0.c()) && o.a(((b)object0).b(), b0.b());
    }

    @Override
    public final String toString() {
        return a.k0(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        c.a(this, parcel0, v);
    }
}

