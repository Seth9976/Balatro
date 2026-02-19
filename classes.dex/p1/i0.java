package p1;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import g1.o.a;
import g1.o;
import q1.r;

public final class i0 extends r implements p {
    public static final Parcelable.Creator CREATOR;
    private final int e;
    private final String f;
    private final String g;
    private final String h;

    static {
        i0.CREATOR = new j0();
    }

    public i0(int v, String s, String s1, String s2) {
        this.e = v;
        this.f = s;
        this.g = s1;
        this.h = s2;
    }

    public i0(p p0) {
        this.e = p0.J();
        this.f = p0.b();
        this.g = p0.a();
        this.h = p0.c();
    }

    @Override  // f1.e
    public final Object D() {
        return this;
    }

    @Override  // p1.p
    public final int J() {
        return this.e;
    }

    @Override  // p1.p
    public final String a() {
        return this.g;
    }

    @Override  // p1.p
    public final String b() {
        return this.f;
    }

    @Override  // p1.p
    public final String c() {
        return this.h;
    }

    @Override
    public final boolean equals(Object object0) {
        return i0.l0(this, object0);
    }

    @Override
    public final int hashCode() {
        return i0.j0(this);
    }

    static int j0(p p0) {
        return o.b(new Object[]{p0.J(), p0.b(), p0.a(), p0.c()});
    }

    static String k0(p p0) {
        a o$a0 = o.c(p0);
        o$a0.a("FriendStatus", p0.J());
        if(p0.b() != null) {
            o$a0.a("Nickname", p0.b());
        }
        if(p0.a() != null) {
            o$a0.a("InvitationNickname", p0.a());
        }
        if(p0.c() != null) {
            o$a0.a("NicknameAbuseReportToken", p0.a());
        }
        return o$a0.toString();
    }

    static boolean l0(p p0, Object object0) {
        if(!(object0 instanceof p)) {
            return false;
        }
        return object0 == p0 ? true : ((p)object0).J() == p0.J() && o.a(((p)object0).b(), p0.b()) && o.a(((p)object0).a(), p0.a()) && o.a(((p)object0).c(), p0.c());
    }

    @Override
    public final String toString() {
        return i0.k0(this);
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        j0.a(this, parcel0, v);
    }
}

