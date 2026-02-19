package x2;

import android.app.Application;
import android.content.IntentFilter;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;

class g0 {
    private final i0 a;
    private final a b;
    private boolean c;
    private long d;
    private long e;
    private long f;
    private boolean g;
    private static final k0 h;

    static {
        g0.h = k0.f("Session");
    }

    g0(i0 i00) {
        this.c = false;
        this.d = -1L;
        this.e = -1L;
        this.f = 0L;
        this.g = true;
        this.a = i00;
        this.b = new a(i00);
        this.i();
        this.s(0x19C748F7856L);
        this.d(((Application)i00.n()));
        this.m();
    }

    private void d(Application application0) {
        if(this.c) {
            return;
        }
        if(p0.J() != null && p0.J().equalsIgnoreCase("mParticle")) {
            return;
        }
        new j0(this).a(application0);
    }

    long e() {
        long v = this.f + 1L;
        this.f = v;
        return v;
    }

    long f() {
        return this.d;
    }

    private boolean g() {
        return this.d > 0L;
    }

    private boolean h(long v) {
        return v - this.e < this.a.B().i * 1000L;
    }

    private void i() {
        SharedPreferences sharedPreferences0 = this.a.n().getSharedPreferences("singular-pref-session", 0);
        this.d = sharedPreferences0.getLong("id", -1L);
        long v = sharedPreferences0.getLong("lastSessionPauseTime", -1L);
        this.e = v;
        if(v < 0L) {
            this.e = sharedPreferences0.getLong("lastEvent", -1L);
        }
        this.f = sharedPreferences0.getLong("seq", 0L);
        g0.h.b("load() <= %s", new Object[]{this.toString()});
    }

    void j(long v) {
        class b implements Runnable {
            final long e;
            final g0 f;

            b(long v) {
                this.e = v;
                super();
            }

            @Override
            public void run() {
                g0.this.g = true;
                g0.this.s(this.e);
                g0.this.m();
            }
        }

        if(!p0.b0()) {
            g0.h.b("onEnterForeground() At %d", new Object[]{v});
            b g0$b0 = new b(this, v);
            this.a.P(g0$b0);
        }
    }

    void k(long v) {
        class x2.g0.a implements Runnable {
            final long e;
            final g0 f;

            x2.g0.a(long v) {
                this.e = v;
                super();
            }

            @Override
            public void run() {
                g0.this.p(this.e);
                g0.this.g = false;
                g0.this.t();
                p0.c();
            }
        }

        g0.h.b("onExitForeground() At %d", new Object[]{v});
        x2.g0.a g0$a0 = new x2.g0.a(this, v);
        this.a.P(g0$a0);
    }

    private void l() {
        try {
            SharedPreferences.Editor sharedPreferences$Editor0 = this.a.n().getSharedPreferences("singular-pref-session", 0).edit();
            sharedPreferences$Editor0.putLong("id", this.d);
            sharedPreferences$Editor0.putLong("lastSessionPauseTime", this.e);
            sharedPreferences$Editor0.putLong("seq", this.f);
            sharedPreferences$Editor0.commit();
        }
        catch(Throwable throwable0) {
            String s = p0.h(throwable0);
            g0.h.c(s);
        }
    }

    void m() {
        if(!this.g && this.c) {
            return;
        }
        IntentFilter intentFilter0 = new IntentFilter();
        intentFilter0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        this.a.n().registerReceiver(this.b, intentFilter0);
        g0.h.a("registerNetworkChangeReceiver()");
    }

    private void n() {
        this.f = 0L;
    }

    private void o() {
        if(!this.g()) {
            return;
        }
        this.a.N(this.d);
    }

    private void p(long v) {
        this.e = v;
        this.l();
    }

    private void q(long v) {
        this.d = v;
    }

    public void r(long v) {
        g0.h.b("startNewSession() At %d", new Object[]{v});
        this.q(v);
        this.n();
        this.o();
    }

    private boolean s(long v) {
        i0.t().p().k.f(i0.t().p(), i0.t().n());
        if(i0.t().B().l != null) {
            this.r(v);
            return true;
        }
        if(this.g() && this.h(v)) {
            return false;
        }
        this.r(v);
        return true;
    }

    void t() {
        if(this.b != null) {
            try {
                this.a.n().unregisterReceiver(this.b);
                g0.h.a("unregisterNetworkChangeReceiver()");
            }
            catch(Throwable unused_ex) {
            }
        }
    }

    // 去混淆评级： 低(20)
    @Override
    public String toString() {
        return "{id=" + this.d + ", lastSessionPauseTime=" + this.e + ", seq=" + this.f + '}';
    }

    void u() {
        this.c = true;
    }
}

