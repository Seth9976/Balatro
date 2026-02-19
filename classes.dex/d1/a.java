package d1;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import e1.d;
import e1.i;
import g1.k;
import g1.q;
import java.util.Set;

public final class a {
    public static abstract class d1.a.a extends e {
        public f a(Context context0, Looper looper0, g1.e e0, Object object0, d1.f.a f$a0, b f$b0) {
            return this.b(context0, looper0, e0, object0, f$a0, f$b0);
        }

        public f b(Context context0, Looper looper0, g1.e e0, Object object0, d d0, i i0) {
            throw new UnsupportedOperationException("buildClient must be implemented");
        }
    }

    public interface d1.a.b {
    }

    public static abstract class c {
    }

    public interface d1.a.d {
        public interface d1.a.d.a extends d1.a.d {
            GoogleSignInAccount b0();
        }

        public static final class d1.a.d.b implements d1.a.d {
            d1.a.d.b(m m0) {
            }
        }

        public static final d1.a.d.b a;

        static {
            d1.a.d.a = new d1.a.d.b(null);
        }
    }

    public static abstract class e {
    }

    public interface f extends d1.a.b {
        boolean a();

        c1.c[] b();

        boolean c();

        String d();

        String e();

        Set g();

        void h(g1.d.e arg1);

        void i();

        void j(String arg1);

        boolean k();

        boolean m();

        void n(g1.d.c arg1);

        int o();

        void p(k arg1, Set arg2);
    }

    public static final class g extends c {
    }

    private final d1.a.a a;
    private final g b;
    private final String c;

    public a(String s, d1.a.a a$a0, g a$g0) {
        q.j(a$a0, "Cannot construct an Api with a null ClientBuilder");
        q.j(a$g0, "Cannot construct an Api with a null ClientKey");
        this.c = s;
        this.a = a$a0;
        this.b = a$g0;
    }

    public final d1.a.a a() {
        return this.a;
    }

    public final c b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }
}

