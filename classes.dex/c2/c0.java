package c2;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.pm.PackageInfo;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import d1.e;
import g2.h;
import g2.i;
import g2.j;
import g2.k;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import q1.q;
import q1.t;
import t1.b;
import t1.c;

public final class c0 implements m {
    private final AtomicReference a;
    private final AtomicReference b;
    private final Queue c;
    private final AtomicReference d;
    private final AtomicReference e;
    private final Application f;
    private final q g;
    private final d0 h;

    c0(Application application0, q q0, b b0, d0 d00) {
        this.a = new AtomicReference(z.e);
        this.b = new AtomicReference(y.e);
        this.c = new ArrayDeque();
        this.d = new AtomicReference();
        this.e = new AtomicReference();
        this.f = application0;
        this.g = q0;
        this.h = d00;
    }

    @Override  // c2.m
    public final h a() {
        return c0.j(() -> {
            this.m(1);
            i i0 = (i)this.d.get();
            return c0.i(this.a, i0);
        });
    }

    // 检测为 Lambda 实现
    final h b() [...]

    @Override  // c2.m
    public final h c() {
        i i0 = (i)this.d.get();
        return c0.i(this.a, i0);
    }

    @Override  // c2.m
    public final h d(f f0) {
        z z0 = (z)this.a.get();
        f1.f("GamesApiManager", "Executing API call with authentication state: " + z0);
        if(z0 == z.g) {
            return f0.a(((e)this.e.get()));
        }
        if(z0 == z.h) {
            return k.a(c0.h());
        }
        if(z0 == z.e) {
            return k.a(new d1.b(new Status(10)));
        }
        i i0 = new i();
        s s0 = () -> {
            g1.q.e("Must be called on the main thread.");
            z z0 = (z)this.a.get();
            if(z0 == z.g) {
                new b0(f0, i0).a(((e)this.e.get()));
                return;
            }
            if(z0 == z.h) {
                new b0(f0, i0).c(c0.h());
                return;
            }
            this.c.add(new b0(f0, i0));
        };
        if(c0.n()) {
            s0.run();
            return i0.a();
        }
        j.a.execute(s0);
        return i0.a();
    }

    // 检测为 Lambda 实现
    final void e(i i0, q2 q20, h h0) [...]

    // 检测为 Lambda 实现
    final void f(i i0, int v, h h0) [...]

    // 检测为 Lambda 实现
    final void g(b0 b00) [...]

    private static d1.b h() {
        return new d1.b(new Status(4));
    }

    private static h i(AtomicReference atomicReference0, i i0) {
        switch(((z)atomicReference0.get()).ordinal()) {
            case 0: {
                return k.a(new d1.b(new Status(10)));
            }
            case 2: {
                return k.b(p1.b.b);
            }
            case 3: {
                return k.b(p1.b.c);
            }
            default: {
                if(i0 == null) {
                    return k.b(p1.b.c);
                }
                h h0 = i0.a();
                if(h0.q()) {
                    return ((Boolean)h0.n()).booleanValue() ? k.b(p1.b.b) : k.b(p1.b.c);
                }
                i i1 = new i();
                h0.d(f2.a(), new x(i1));
                return i1.a();
            }
        }
    }

    private static h j(g2 g20) {
        if(c0.n()) {
            return (h)g20.a();
        }
        i i0 = new i();
        v v0 = new v(g20, i0);
        j.a.execute(v0);
        return i0.a();
    }

    private final void k(i i0, q2 q20) {
        f1.a("GamesApiManager", "Attempting authentication: " + q20.toString());
        h h0 = this.h.a(q20);
        w w0 = (h h0) -> {
            boolean z;
            PendingIntent pendingIntent0;
            int v;
            if(!h0.q()) {
                Exception exception0 = h0.m();
                p1.a(exception0);
                f1.b("GamesApiManager", "Authentication task failed", exception0);
                goto label_15;
            }
            h0 h00 = (h0)h0.n();
            if(!h00.e()) {
                f1.a("GamesApiManager", "Failed to authenticate: " + h00);
                v = q20.a();
                pendingIntent0 = h00.a();
                z = true;
                this.l(i0, v, pendingIntent0, z, !q20.e());
                return;
            }
            String s = h00.d();
            if(s == null) {
                f1.g("GamesApiManager", "Unexpected state: game run token absent");
            label_15:
                v = q20.a();
                pendingIntent0 = null;
                z = false;
                this.l(i0, v, pendingIntent0, z, !q20.e());
                return;
            }
            f1.a("GamesApiManager", "Successfully authenticated");
            g1.q.e("Must be called on the main thread.");
            p1.b0 b00 = p1.d0.b();
            b00.d(0x201113);
            b00.c(GoogleSignInAccount.j0());
            b00.a(s);
            t t0 = q1.v.a();
            t0.b(true);
            t0.c(true);
            t0.a(true);
            b00.b(t0.d());
            p1.d0 d00 = b00.e();
            q0 q00 = new q0(this.f, d00);
            this.e.set(q00);
            this.a.set(z.g);
            i0.e(Boolean.TRUE);
            Iterator iterator0 = this.c.iterator();
            while(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                ((b0)object0).a(q00);
                iterator0.remove();
            }
        };
        h0.d(j.a, w0);
    }

    private final void l(i i0, int v, PendingIntent pendingIntent0, boolean z, boolean z1) {
        String s;
        g1.q.e("Must be called on the main thread.");
        int v1 = l1.b.a(this.f, "com.google.android.gms");
        Locale locale0 = Locale.US;
        f1.a("GamesApiManager", String.format(locale0, "GmsCore version is %d", v1));
        if(v1 < 220812000) {
            PackageInfo packageInfo0 = l1.b.b(this.f, "com.android.vending");
            if(packageInfo0 == null) {
                s = "PlayStore is not installed";
                goto label_12;
            }
            int v2 = packageInfo0.versionCode;
            if(v2 < 82470600) {
                s = String.format(locale0, "PlayStore version is below resolution threshold: %s", v2);
            label_12:
                f1.a("GamesApiManager", s);
                f1.g("GamesApiManager", "PlayStore is too old or not available and the version of GmsCore would attempt PGA installation on automatic sign-in. Skipping it.");
                i0.e(Boolean.FALSE);
                this.a.set(z.h);
                return;
            }
            f1.a("GamesApiManager", "Installed PlayStore version can be used for resolution.");
        }
        if(z && pendingIntent0 != null) {
            Activity activity0 = this.g.a();
            if(activity0 != null) {
                h h0 = b.b(activity0, pendingIntent0);
                c2.q q0 = (h h0) -> {
                    if(!h0.q()) {
                        Exception exception0 = h0.m();
                        p1.a(exception0);
                        f1.h("GamesApiManager", "Resolution failed", exception0);
                        this.l(i0, v, null, false, true);
                        return;
                    }
                    c c0 = (c)h0.n();
                    if(c0.d()) {
                        f1.a("GamesApiManager", "Resolution successful");
                        this.k(i0, q2.k0(v, x2.j0(c0.a())));
                        return;
                    }
                    f1.a("GamesApiManager", "Resolution attempt was canceled");
                    this.l(i0, v, null, false, true);
                };
                h0.d(j.a, q0);
                f1.a("GamesApiManager", "Resolution triggered");
                return;
            }
        }
        if(!z1 && p.a(this.b, y.f, y.g)) {
            f1.a("GamesApiManager", "Consumed pending explicit sign-in. Attempting explicit sign-in");
            this.k(i0, q2.j0(0));
            return;
        }
        i0.e(Boolean.FALSE);
        this.a.set(z.h);
        Iterator iterator0 = this.c.iterator();
        while(iterator0.hasNext()) {
            Object object0 = iterator0.next();
            ((b0)object0).c(c0.h());
            iterator0.remove();
        }
    }

    private final void m(int v) {
        y y0;
        f1.a("GamesApiManager", "startAuthenticationIfNecessary() signInType: " + v);
        g1.q.e("Must be called on the main thread.");
        z z0 = z.f;
        int v1 = 0;
        if(!p.a(this.a, z.e, z0)) {
            if(v != 1) {
                if(!p.a(this.a, z.h, z0)) {
                    f1.a("GamesApiManager", "Explicit sign-in during existing authentication. Marking pending explicit sign-in: " + p.a(this.b, y.e, y.f));
                    f1.a("GamesApiManager", "Authentication attempt skipped. Already authenticated or authenticating. State: " + this.a.get());
                    return;
                }
                v = 0;
                goto label_13;
            }
            f1.a("GamesApiManager", "Authentication attempt skipped. Already authenticated or authenticating. State: " + this.a.get());
            return;
        }
    label_13:
        i i0 = (i)this.d.get();
        if(i0 != null) {
            i0.d(new IllegalStateException("New authentication attempt in progress"));
        }
        i i1 = new i();
        this.d.set(i1);
        AtomicReference atomicReference0 = this.b;
        if(v == 0) {
            y0 = y.g;
        }
        else {
            y0 = y.e;
            v1 = 1;
        }
        atomicReference0.set(y0);
        this.k(i1, q2.j0(v1));
    }

    private static boolean n() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}

