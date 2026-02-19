package c2;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import g1.o;
import g1.q;

final class h0 {
    private final String a;
    private final Status b;

    private h0(Status status0, String s) {
        this.b = status0;
        this.a = s;
    }

    public final PendingIntent a() {
        return this.b.k0();
    }

    public static h0 b(Status status0) {
        q.a(!status0.o0());
        return new h0(status0, null);
    }

    public static h0 c(String s) {
        return new h0(Status.j, s);
    }

    public final String d() {
        return this.a;
    }

    public final boolean e() {
        return this.b.o0();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof h0 ? o.a(this.b, ((h0)object0).b) && o.a(this.a, ((h0)object0).a) : false;
    }

    @Override
    public final int hashCode() {
        return o.b(new Object[]{this.b, this.a});
    }

    @Override
    public final String toString() {
        return o.c(this).a("status", this.b).a("gameRunToken", this.a).toString();
    }
}

