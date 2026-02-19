package q0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import j0.i;
import j0.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import k0.e;
import k0.f;
import k0.g;
import k0.m;
import r0.c;
import r0.d;
import s0.b;
import t0.a;

public class r {
    private final Context a;
    private final e b;
    private final d c;
    private final x d;
    private final Executor e;
    private final b f;
    private final a g;
    private final a h;
    private final c i;

    public r(Context context0, e e0, d d0, x x0, Executor executor0, b b0, a a0, a a1, c c0) {
        this.a = context0;
        this.b = e0;
        this.c = d0;
        this.d = x0;
        this.e = executor0;
        this.f = b0;
        this.g = a0;
        this.h = a1;
        this.i = c0;
    }

    public i j(m m0) {
        Objects.requireNonNull(this.i);
        h h0 = new h(this.i);
        m0.a a0 = (m0.a)this.f.b(h0);
        return m0.a(i.a().i(this.g.a()).k(this.h.a()).j("GDT_CLIENT_METRICS").h(new j0.h(h0.b.b("proto"), new byte[0])).d());
    }

    boolean k() {
        NetworkInfo networkInfo0 = ((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkInfo0 != null && networkInfo0.isConnected();
    }

    // 检测为 Lambda 实现
    private Boolean l(o o0) [...]

    // 检测为 Lambda 实现
    private Iterable m(o o0) [...]

    // 检测为 Lambda 实现
    private Object n(Iterable iterable0, o o0, long v) [...]

    // 检测为 Lambda 实现
    private Object o(Iterable iterable0) [...]

    // 检测为 Lambda 实现
    private Object p() [...]

    // 检测为 Lambda 实现
    private Object q(Map map0) [...]

    // 检测为 Lambda 实现
    private Object r(o o0, long v) [...]

    // 检测为 Lambda 实现
    private Object s(o o0, int v) [...]

    // 检测为 Lambda 实现
    private void t(o o0, int v, Runnable runnable0) [...]

    public g u(o o0, int v) {
        g g1;
        String s = o0.b();
        m m0 = this.b.a(s);
        long v1 = 0L;
        g g0 = g.e(0L);
        while(true) {
            k k0 = () -> Boolean.valueOf(this.c.z(o0));
            if(!((Boolean)this.f.b(k0)).booleanValue()) {
                break;
            }
            l l0 = () -> this.c.K(o0);
            Iterable iterable0 = (Iterable)this.f.b(l0);
            if(!iterable0.iterator().hasNext()) {
                return g0;
            }
            if(m0 == null) {
                n0.a.b("Uploader", "Unknown backend for %s, deleting event batch for it...", o0);
                g1 = g.a();
            }
            else {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: iterable0) {
                    arrayList0.add(((r0.k)object0).b());
                }
                if(o0.e()) {
                    arrayList0.add(this.j(m0));
                }
                g1 = m0.b(f.a().b(arrayList0).c(o0.c()).a());
            }
            g0 = g1;
            if(g0.c() == k0.g.a.f) {
                q0.m m1 = () -> {
                    this.c.H(iterable0);
                    long v1 = this.g.a();
                    this.c.x(o0, v1 + v1);
                    return null;
                };
                this.f.b(m1);
                this.d.b(o0, v + 1, true);
                return g0;
            }
            n n0 = () -> {
                this.c.s(iterable0);
                return null;
            };
            this.f.b(n0);
            if(g0.c() == k0.g.a.e) {
                v1 = Math.max(v1, g0.b());
                if(!o0.e()) {
                    continue;
                }
                q0.o o1 = () -> {
                    this.i.a();
                    return null;
                };
                this.f.b(o1);
            }
            else if(g0.c() == k0.g.a.h) {
                HashMap hashMap0 = new HashMap();
                for(Object object1: iterable0) {
                    String s1 = ((r0.k)object1).b().j();
                    hashMap0.put(s1, (hashMap0.containsKey(s1) ? ((int)(((int)(((Integer)hashMap0.get(s1)))) + 1)) : 1));
                }
                p p0 = () -> {
                    for(Object object0: hashMap0.entrySet()) {
                        long v = (long)(((int)(((Integer)((Map.Entry)object0).getValue()))));
                        String s = (String)((Map.Entry)object0).getKey();
                        this.i.d(v, m0.c.b.k, s);
                    }
                    return null;
                };
                this.f.b(p0);
            }
        }
        q q0 = () -> {
            long v1 = this.g.a();
            this.c.x(o0, v1 + v1);
            return null;
        };
        this.f.b(q0);
        return g0;
    }

    public void v(o o0, int v, Runnable runnable0) {
        q0.g g0 = () -> try {
            Objects.requireNonNull(this.c);
            q0.i i0 = new q0.i(this.c);
            this.f.b(i0);
            if(this.k()) {
                this.u(o0, v);
            }
            else {
                j j0 = () -> {
                    this.d.a(o0, v + 1);
                    return null;
                };
                this.f.b(j0);
            }
        }
        catch(s0.a unused_ex) {
            this.d.a(o0, v + 1);
        }
        finally {
            runnable0.run();
        };
        this.e.execute(g0);
    }
}

