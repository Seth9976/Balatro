package d1;

import android.accounts.Account;
import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.h;
import e1.b;
import e1.l;
import e1.r;
import e1.z;
import g1.q;
import g2.i;
import java.util.Collections;
import java.util.Set;

public abstract class e {
    public static class a {
        public static class d1.e.a.a {
            private l a;
            private Looper b;

            public a a() {
                if(this.a == null) {
                    this.a = new e1.a();
                }
                if(this.b == null) {
                    this.b = Looper.getMainLooper();
                }
                return new a(this.a, null, this.b, null);
            }

            public d1.e.a.a b(l l0) {
                q.j(l0, "StatusExceptionMapper must not be null.");
                this.a = l0;
                return this;
            }
        }

        public final l a;
        public final Looper b;
        public static final a c;

        static {
            a.c = new d1.e.a.a().a();
        }

        private a(l l0, Account account0, Looper looper0) {
            this.a = l0;
            this.b = looper0;
        }

        a(l l0, Account account0, Looper looper0, n n0) {
            this(l0, null, looper0);
        }
    }

    private final Context a;
    private final String b;
    private final d1.a c;
    private final d d;
    private final b e;
    private final Looper f;
    private final int g;
    private final f h;
    private final l i;
    protected final c j;

    public e(Activity activity0, d1.a a0, d a$d0, a e$a0) {
        this(activity0, activity0, a0, a$d0, e$a0);
    }

    private e(Context context0, Activity activity0, d1.a a0, d a$d0, a e$a0) {
        q.j(context0, "Null context is not permitted.");
        q.j(a0, "Api must not be null.");
        q.j(e$a0, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context context1 = (Context)q.j(context0.getApplicationContext(), "The provided context did not have an application context.");
        this.a = context1;
        String s = Build.VERSION.SDK_INT < 30 ? null : context0.getAttributionTag();
        this.b = s;
        this.c = a0;
        this.d = a$d0;
        this.f = e$a0.b;
        b b0 = b.a(a0, a$d0, s);
        this.e = b0;
        this.h = new r(this);
        c c0 = c.u(context1);
        this.j = c0;
        this.g = c0.l();
        this.i = e$a0.a;
        if(activity0 != null && !(activity0 instanceof GoogleApiActivity) && Looper.myLooper() == Looper.getMainLooper()) {
            h.u(activity0, c0, b0);
        }
        c0.F(this);
    }

    public e(Context context0, d1.a a0, d a$d0, a e$a0) {
        this(context0, null, a0, a$d0, e$a0);
    }

    public f d() {
        return this.h;
    }

    protected g1.e.a e() {
        Set set0;
        Account account0;
        g1.e.a e$a0 = new g1.e.a();
        d a$d0 = this.d;
        if(a$d0 instanceof d1.a.d.a) {
            GoogleSignInAccount googleSignInAccount0 = ((d1.a.d.a)a$d0).b0();
            account0 = googleSignInAccount0 == null ? null : googleSignInAccount0.k0();
        }
        else {
            account0 = null;
        }
        e$a0.d(account0);
        d a$d1 = this.d;
        if(a$d1 instanceof d1.a.d.a) {
            GoogleSignInAccount googleSignInAccount1 = ((d1.a.d.a)a$d1).b0();
            set0 = googleSignInAccount1 == null ? Collections.emptySet() : googleSignInAccount1.r0();
        }
        else {
            set0 = Collections.emptySet();
        }
        e$a0.c(set0);
        e$a0.e(this.a.getClass().getName());
        e$a0.b("com.playstack.balatro.android");
        return e$a0;
    }

    public g2.h f(com.google.android.gms.common.api.internal.d d0) {
        return this.t(2, d0);
    }

    public g2.h g(com.google.android.gms.common.api.internal.d d0) {
        return this.t(0, d0);
    }

    public com.google.android.gms.common.api.internal.b h(com.google.android.gms.common.api.internal.b b0) {
        this.s(1, b0);
        return b0;
    }

    public g2.h i(com.google.android.gms.common.api.internal.d d0) {
        return this.t(1, d0);
    }

    protected String j(Context context0) [...] // Inlined contents

    public final b k() {
        return this.e;
    }

    public d l() {
        return this.d;
    }

    public Context m() {
        return this.a;
    }

    protected String n() {
        return this.b;
    }

    public Looper o() {
        return this.f;
    }

    public final int p() {
        return this.g;
    }

    public final d1.a.f q(Looper looper0, com.google.android.gms.common.api.internal.n n0) {
        g1.e e0 = this.e().a();
        d1.a.f a$f0 = ((d1.a.a)q.i(this.c.a())).a(this.a, looper0, e0, this.d, n0, n0);
        String s = this.n();
        if(s != null && a$f0 instanceof g1.d) {
            ((g1.d)a$f0).O(s);
        }
        if(s != null && a$f0 instanceof e1.h) {
            e1.h h0 = (e1.h)a$f0;
            throw null;
        }
        return a$f0;
    }

    public final z r(Context context0, Handler handler0) {
        return new z(context0, handler0, this.e().a());
    }

    private final com.google.android.gms.common.api.internal.b s(int v, com.google.android.gms.common.api.internal.b b0) {
        b0.l();
        this.j.A(this, v, b0);
        return b0;
    }

    private final g2.h t(int v, com.google.android.gms.common.api.internal.d d0) {
        i i0 = new i();
        this.j.B(this, v, d0, i0, this.i);
        return i0.a();
    }
}

