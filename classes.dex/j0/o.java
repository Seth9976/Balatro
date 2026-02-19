package j0;

import android.util.Base64;
import h0.d;

public abstract class o {
    public static abstract class a {
        public abstract o a();

        public abstract a b(String arg1);

        public abstract a c(byte[] arg1);

        public abstract a d(d arg1);
    }

    public static a a() {
        return new b().d(d.e);
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract d d();

    public boolean e() {
        return this.c() != null;
    }

    public o f(d d0) {
        return o.a().b(this.b()).d(d0).c(this.c()).a();
    }

    @Override
    public final String toString() {
        return String.format("TransportContext(%s, %s, %s)", this.b(), this.d(), (this.c() == null ? "" : Base64.encodeToString(this.c(), 2)));
    }
}

