package j0;

import android.content.Context;
import h0.b;
import h0.h;
import java.util.Collections;
import java.util.Set;
import p0.e;
import q0.r;
import q0.v;
import t0.a;

public class t implements s {
    private final a a;
    private final a b;
    private final e c;
    private final r d;
    private static volatile u e;

    static {
    }

    t(a a0, a a1, e e0, r r0, v v0) {
        this.a = a0;
        this.b = a1;
        this.c = e0;
        this.d = r0;
        v0.c();
    }

    @Override  // j0.s
    public void a(n n0, h h0) {
        o o0 = n0.f().f(n0.c().c());
        i i0 = this.b(n0);
        this.c.a(o0, i0, h0);
    }

    private i b(n n0) {
        return i.a().i(this.a.a()).k(this.b.a()).j(n0.g()).h(new j0.h(n0.b(), n0.d())).g(n0.c().a()).d();
    }

    public static t c() {
        u u0 = t.e;
        if(u0 == null) {
            throw new IllegalStateException("Not initialized!");
        }
        return u0.b();
    }

    // 去混淆评级： 低(20)
    private static Set d(f f0) {
        return f0 instanceof g ? Collections.unmodifiableSet(((g)f0).b()) : Collections.singleton(b.b("proto"));
    }

    public r e() {
        return this.d;
    }

    public static void f(Context context0) {
        if(t.e == null) {
            Class class0 = t.class;
            synchronized(class0) {
                if(t.e == null) {
                    t.e = j0.e.c().b(context0).a();
                }
            }
        }
    }

    public h0.g g(f f0) {
        return new p(t.d(f0), o.a().b(f0.c()).c(f0.a()).a(), this);
    }
}

