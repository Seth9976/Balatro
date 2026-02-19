package g1;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import c1.j;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class d {
    public interface a {
        void a(int arg1);

        void f(Bundle arg1);
    }

    public interface b {
        void d(c1.a arg1);
    }

    public interface c {
        void b(c1.a arg1);
    }

    public class g1.d.d implements c {
        final d a;

        @Override  // g1.d$c
        public final void b(c1.a a0) {
            if(a0.n0()) {
                Set set0 = d.this.B();
                d.this.p(null, set0);
                return;
            }
            if(d.this.v != null) {
                d.this.v.d(a0);
            }
        }
    }

    public interface e {
        void a();
    }

    private boolean A;
    private volatile e1 B;
    protected AtomicInteger C;
    public static final String[] D;
    private static final c1.c[] E;
    private int a;
    private long b;
    private long c;
    private int d;
    private long e;
    private volatile String f;
    p1 g;
    private final Context h;
    private final Looper i;
    private final i j;
    private final j k;
    final Handler l;
    private final Object m;
    private final Object n;
    private m o;
    protected c p;
    private IInterface q;
    private final ArrayList r;
    private a1 s;
    private int t;
    private final a u;
    private final b v;
    private final int w;
    private final String x;
    private volatile String y;
    private c1.a z;

    static {
        d.E = new c1.c[0];
        d.D = new String[]{"service_esmobile", "service_googleme"};
    }

    protected d(Context context0, Looper looper0, i i0, j j0, int v, a d$a0, b d$b0, String s) {
        this.f = null;
        this.m = new Object();
        this.n = new Object();
        this.r = new ArrayList();
        this.t = 1;
        this.z = null;
        this.A = false;
        this.B = null;
        this.C = new AtomicInteger(0);
        q.j(context0, "Context must not be null");
        this.h = context0;
        q.j(looper0, "Looper must not be null");
        this.i = looper0;
        q.j(i0, "Supervisor must not be null");
        this.j = i0;
        q.j(j0, "API availability must not be null");
        this.k = j0;
        this.l = new x0(this, looper0);
        this.w = v;
        this.u = d$a0;
        this.v = d$b0;
        this.x = s;
    }

    protected String A() [...] // Inlined contents

    protected abstract Set B();

    public final IInterface C() {
        synchronized(this.m) {
            if(this.t != 5) {
                this.q();
                IInterface iInterface0 = this.q;
                q.j(iInterface0, "Client is connected but service is null");
                return iInterface0;
            }
        }
        throw new DeadObjectException();
    }

    protected abstract String D();

    protected abstract String E();

    protected String F() [...] // Inlined contents

    public f G() {
        return this.B == null ? null : this.B.h;
    }

    protected boolean H() {
        return this.o() >= 211700000;
    }

    public boolean I() {
        return this.B != null;
    }

    protected void J(IInterface iInterface0) {
        this.c = System.currentTimeMillis();
    }

    protected void K(c1.a a0) {
        this.d = a0.j0();
        this.e = System.currentTimeMillis();
    }

    protected void L(int v) {
        this.a = v;
        this.b = System.currentTimeMillis();
    }

    protected void M(int v, IBinder iBinder0, Bundle bundle0, int v1) {
        b1 b10 = new b1(this, v, iBinder0, bundle0);
        Message message0 = this.l.obtainMessage(1, v1, -1, b10);
        this.l.sendMessage(message0);
    }

    public boolean N() {
        return false;
    }

    public void O(String s) {
        this.y = s;
    }

    public void P(int v) {
        int v1 = this.C.get();
        Message message0 = this.l.obtainMessage(6, v1, v);
        this.l.sendMessage(message0);
    }

    public boolean Q() {
        return false;
    }

    protected final String V() {
        return this.x == null ? this.h.getClass().getName() : this.x;
    }

    static void Z(d d0, int v, IInterface iInterface0) {
        d0.g0(v, null);
    }

    public boolean a() {
        boolean z = true;
        synchronized(this.m) {
            if(this.t != 2 && this.t != 3) {
                z = false;
            }
        }
        return z;
    }

    static void a0(d d0, e1 e10) {
        d0.B = e10;
        if(d0.Q()) {
            f f0 = e10.h;
            r.b().c((f0 == null ? null : f0.o0()));
        }
    }

    public final c1.c[] b() {
        return this.B == null ? null : this.B.f;
    }

    static void b0(d d0, int v) {
        int v1;
        synchronized(d0.m) {
        }
        if(d0.t == 3) {
            d0.A = true;
            v1 = 5;
        }
        else {
            v1 = 4;
        }
        int v2 = d0.C.get();
        Message message0 = d0.l.obtainMessage(v1, v2, 16);
        d0.l.sendMessage(message0);
    }

    public boolean c() {
        synchronized(this.m) {
        }
        return this.t == 4;
    }

    protected final void c0(int v, Bundle bundle0, int v1) {
        c1 c10 = new c1(this, v, null);
        Message message0 = this.l.obtainMessage(7, v1, -1, c10);
        this.l.sendMessage(message0);
    }

    public String d() {
        if(this.c()) {
            p1 p10 = this.g;
            if(p10 != null) {
                return p10.a();
            }
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public String e() {
        return this.f;
    }

    static boolean e0(d d0, int v, int v1, IInterface iInterface0) {
        synchronized(d0.m) {
            if(d0.t != v) {
                return false;
            }
            d0.g0(v1, iInterface0);
            return true;
        }
    }

    static boolean f0(d d0) {
        if(!d0.A && !TextUtils.isEmpty(d0.D()) && !TextUtils.isEmpty(null)) {
            try {
                Class.forName(d0.D());
                return true;
            }
            catch(ClassNotFoundException unused_ex) {
            }
        }
        return false;
    }

    private final void g0(int v, IInterface iInterface0) {
        q.a((v == 4 ? 1 : 0) == (iInterface0 == null ? 0 : 1));
        synchronized(this.m) {
            this.t = v;
            this.q = iInterface0;
            if(v == 1) {
                a1 a12 = this.s;
                if(a12 != null) {
                    String s6 = this.g.b();
                    q.i(s6);
                    String s7 = this.g.a();
                    String s8 = this.V();
                    this.j.d(s6, s7, 0x1081, a12, s8, this.g.c());
                    this.s = null;
                }
            }
            else {
                switch(v) {
                    case 2: 
                    case 3: {
                        a1 a10 = this.s;
                        if(a10 != null) {
                            p1 p10 = this.g;
                            if(p10 != null) {
                                Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + p10.b() + " on " + p10.a());
                                String s = this.g.b();
                                q.i(s);
                                String s1 = this.g.a();
                                String s2 = this.V();
                                this.j.d(s, s1, 0x1081, a10, s2, this.g.c());
                                this.C.incrementAndGet();
                            }
                        }
                        a1 a11 = new a1(this, this.C.get());
                        this.s = a11;
                        p1 p11 = new p1("com.google.android.gms", this.E(), false, 0x1081, this.H());
                        this.g = p11;
                        if(p11.c() && this.o() < 17895000) {
                            throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: " + this.g.b());
                        }
                        String s3 = this.g.b();
                        q.i(s3);
                        String s4 = this.g.a();
                        String s5 = this.V();
                        boolean z = this.g.c();
                        Executor executor0 = this.v();
                        i1 i10 = new i1(s3, s4, 0x1081, z);
                        if(!this.j.e(i10, a11, s5, executor0)) {
                            Log.w("GmsClient", "unable to connect to service: " + this.g.b() + " on " + this.g.a());
                            this.c0(16, null, this.C.get());
                        }
                        break;
                    }
                    case 4: {
                        q.i(iInterface0);
                        this.J(iInterface0);
                    }
                }
            }
        }
    }

    public void h(e d$e0) {
        d$e0.a();
    }

    public void i() {
        this.C.incrementAndGet();
        synchronized(this.r) {
            int v1 = this.r.size();
            for(int v2 = 0; v2 < v1; ++v2) {
                ((y0)this.r.get(v2)).d();
            }
            this.r.clear();
        }
        synchronized(this.n) {
            this.o = null;
        }
        this.g0(1, null);
    }

    public void j(String s) {
        this.f = s;
        this.i();
    }

    public boolean k() {
        return false;
    }

    public boolean m() {
        return true;
    }

    public void n(c d$c0) {
        q.j(d$c0, "Connection progress callbacks cannot be null.");
        this.p = d$c0;
        this.g0(2, null);
    }

    public int o() {
        return j.a;
    }

    public void p(k k0, Set set0) {
        Bundle bundle0 = this.z();
        String s = this.y;
        Bundle bundle1 = new Bundle();
        g g0 = new g(6, this.w, j.a, null, null, g.s, bundle1, null, g.t, g.t, true, 0, false, s);
        g0.h = "com.playstack.balatro.android";
        g0.k = bundle0;
        if(set0 != null) {
            g0.j = (Scope[])set0.toArray(new Scope[0]);
        }
        if(this.k()) {
            Account account0 = this.t();
            if(account0 == null) {
                account0 = new Account("<<default account>>", "com.google");
            }
            g0.l = account0;
            if(k0 != null) {
                g0.i = k0.asBinder();
            }
        }
        else if(this.N()) {
            g0.l = this.t();
        }
        g0.m = d.E;
        g0.n = this.u();
        if(this.Q()) {
            g0.q = true;
        }
        try {
            synchronized(this.n) {
                m m0 = this.o;
                if(m0 == null) {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
                else {
                    m0.G(new z0(this, this.C.get()), g0);
                }
            }
        }
        catch(DeadObjectException deadObjectException0) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", deadObjectException0);
            this.P(3);
        }
        catch(SecurityException securityException0) {
            throw securityException0;
        }
        catch(RemoteException | RuntimeException remoteException0) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", remoteException0);
            this.M(8, null, null, this.C.get());
        }
    }

    protected final void q() {
        if(!this.c()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected abstract IInterface r(IBinder arg1);

    protected boolean s() [...] // Inlined contents

    public abstract Account t();

    public c1.c[] u() {
        return d.E;
    }

    protected abstract Executor v();

    public Bundle w() {
        return null;
    }

    public final Context x() {
        return this.h;
    }

    public int y() {
        return this.w;
    }

    protected Bundle z() {
        return new Bundle();
    }
}

