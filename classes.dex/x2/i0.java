package x2;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import n2.p;
import org.json.JSONObject;
import w2.b;

public class i0 {
    private final Context a;
    private final e b;
    private final o0 c;
    private b d;
    private g0 e;
    private t f;
    private HashMap g;
    Map h;
    Map i;
    Map j;
    String k;
    private boolean l;
    private boolean m;
    private double n;
    private static final k0 o;
    private static int p;
    private static i0 q;

    static {
        i0.o = k0.f("Instance");
        i0.p = 0;
    }

    private i0(Context context0, b b0) {
        class d implements Runnable {
            final i0 e;
            final i0 f;

            d(i0 i01) {
                this.e = i01;
                super();
            }

            @Override
            public void run() {
                i0.this.D(this.e);
            }
        }

        this.l = false;
        this.m = false;
        i0.o.b("SDK version: %s", new Object[]{"Singular/v12.5.6"});
        i0.o.b("SDK build info: %s", new Object[]{"1d1dfa45.master; Sun, 30 Jun 2024 16:35:45 +0800"});
        i0.o.b("new SingularInstance() with config: %s", new Object[]{b0});
        Context context1 = context0.getApplicationContext();
        if(!(context1 instanceof Application)) {
            throw new IllegalStateException("Context failed to cast to ApplicationContext");
        }
        this.a = context1;
        this.d = b0;
        o0 o00 = new o0("worker");
        this.c = o00;
        this.b = new e(new o0("api"), context0, new f0(context0));
        o00.start();
        this.E();
        this.P(new d(this, this));
    }

    private SharedPreferences A() {
        return this.a.getSharedPreferences("singular-pref-session", 0);
    }

    b B() {
        return this.d;
    }

    public void C(JSONObject jSONObject0) {
        try {
            Map map0 = (Map)new n2.e().c(p.g).b().h(jSONObject0.toString(), Map.class);
            this.d.getClass();
        }
        catch(Throwable throwable0) {
            i0.o.a("could not convert device attribution json object to map" + throwable0.getMessage());
        }
    }

    private void D(i0 i00) {
        class x2.i0.e implements c {
            final i0 a;
            final i0 b;

            x2.i0.e(i0 i01) {
                this.a = i01;
                super();
            }

            @Override  // x2.m$c
            public void a() {
                class a implements x2.i.d {
                    final x2.i0.e a;

                    @Override  // x2.i$d
                    public boolean a(h h0) {
                        try {
                            JSONObject jSONObject0 = i0.this.q();
                            if(jSONObject0.length() != 0) {
                                h0.g("global_properties", jSONObject0.toString());
                            }
                            return h0.a(x2.i0.e.this.a);
                        }
                        catch(IOException iOException0) {
                            i0.o.c(p0.h(iOException0));
                            return false;
                        }
                    }
                }


                class x2.i0.e.b implements x2.i.e {
                    final x2.i0.e a;

                    @Override  // x2.i$e
                    public void a(h h0) {
                        i0.this.m().c(h0);
                    }
                }

                i.u(i0.this.a, new k(this.a.a), new a(this), new x2.i0.e.b(this));
                i.t().y();
            }
        }

        if(this.G()) {
            i0.o.c("Singular is already initialized, please don\'t call init() again.");
            return;
        }
        try {
            i00.m = p0.W(this.n());
            if(!p0.V(this.d.q)) {
                this.U("fcm_device_token_key", this.d.q);
            }
            String s = this.d.e;
            if(s != null) {
                this.T(s);
            }
            Boolean boolean0 = this.d.r;
            if(boolean0 != null) {
                this.I(boolean0.booleanValue());
            }
            String s1 = this.d.f;
            if(s1 != null) {
                this.W(s1);
            }
            i00.f = new t(i00.a, this.d.g, this.d.s);
            if(p0.V(this.A().getString("custom-sdid", null)) && !p0.V(this.d.t) && !this.d.t.equalsIgnoreCase("null")) {
                SharedPreferences.Editor sharedPreferences$Editor0 = this.a.getSharedPreferences("singular-pref-session", 0).edit();
                sharedPreferences$Editor0.putString("custom-sdid", this.d.t);
                sharedPreferences$Editor0.putString("cs", "1");
                sharedPreferences$Editor0.commit();
                this.d.getClass();
            }
            m.n(new x2.p(this.a), new o(new v()), new x2.i0.e(this, i00));
            i00.e = new g0(i00);
            this.l = true;
            i0.o.h("Singular is initialized now.");
        }
        catch(Throwable throwable0) {
            i0.o.d("error in init()", throwable0);
        }
    }

    private void E() {
        this.g = this.J();
        if(this.d.h.size() == 0) {
            return;
        }
        HashMap hashMap0 = (HashMap)this.g.clone();
        Iterator iterator0 = this.d.h.values().iterator();
        if(!iterator0.hasNext()) {
            if(hashMap0.size() > 5) {
                return;
            }
            this.g = hashMap0;
            this.V();
            if(this.g == null) {
                this.i();
            }
            return;
        }
        Object object0 = iterator0.next();
        h.d.a(object0);
        throw null;
    }

    public boolean F() {
        return this.A().getBoolean("stop_all_tracking", false);
    }

    boolean G() {
        return this.l;
    }

    private boolean H() {
        return this.G() && i0.t() != null && this.z() != null;
    }

    public void I(boolean z) {
        this.S("limit_data_sharing", z);
    }

    public HashMap J() {
        JSONObject jSONObject0;
        String s = this.A().getString("global_properties", "{}");
        try {
            jSONObject0 = new JSONObject(s);
        }
        catch(Throwable unused_ex) {
            jSONObject0 = new JSONObject();
        }
        HashMap hashMap0 = new HashMap();
        Iterator iterator0 = jSONObject0.keys();
        while(iterator0.hasNext()) {
            try {
                Object object0 = iterator0.next();
                hashMap0.put(((String)object0), jSONObject0.getString(((String)object0)));
            }
            catch(Throwable unused_ex) {
            }
        }
        return hashMap0;
    }

    void K(x2.g.c g$c0) {
        class f implements Runnable {
            final x2.g.c e;
            final i0 f;

            f(x2.g.c g$c0) {
                this.e = g$c0;
                super();
            }

            @Override
            public void run() {
                i0.this.K(this.e);
            }
        }


        class g implements Runnable {
            final x2.g.c e;
            final i0 f;

            g(x2.g.c g$c0) {
                this.e = g$c0;
                super();
            }

            @Override
            public void run() {
                x2.g g0 = new x2.g(this.e.c);
                g0.i(x2.g.b.k(this.e, i0.q));
                if(i.t() != null) {
                    i.t().r(g0);
                    return;
                }
                i0.q.b.c(g0);
            }
        }

        if(this.F()) {
            i0.o.a("Tracking was stopped! not logging event!");
            return;
        }
        if(!this.H()) {
            this.O(new f(this, g$c0));
            return;
        }
        this.P(new g(this, g$c0));
    }

    public boolean L(String s) {
        return this.M(s, null);
    }

    public boolean M(String s, String s1) {
        int v = (s == null ? 0 : s.length()) + (s1 == null ? 0 : s1.length());
        if(v > 0xEA2) {
            i0.o.b("Event discarded! payload length = %d", new Object[]{v});
            return false;
        }
        this.K(new x2.g.c(s, s1));
        return true;
    }

    void N(long v) {
        class x2.i0.h implements Runnable {
            final long e;
            final i0 f;

            x2.i0.h(long v) {
                this.e = v;
                super();
            }

            @Override
            public void run() {
                if(i0.q != null) {
                    if(i0.this.m) {
                        i0.this.l();
                        i0.this.j();
                        i0.this.k(this.e);
                        return;
                    }
                    i0.this.X(this.e);
                }
            }
        }

        if(this.F()) {
            i0.o.a("Tracking was stopped! not logging event!");
            return;
        }
        this.Q(new x2.i0.h(this, v));
    }

    void O(Runnable runnable0) {
        if(i0.p < 10) {
            this.R(runnable0, 200);
            ++i0.p;
        }
    }

    void P(Runnable runnable0) {
        this.c.c(runnable0);
    }

    void Q(Runnable runnable0) {
        this.c.d(runnable0);
    }

    void R(Runnable runnable0, int v) {
        this.c.e(runnable0, v);
    }

    private void S(String s, boolean z) {
        SharedPreferences.Editor sharedPreferences$Editor0 = this.A().edit();
        sharedPreferences$Editor0.putBoolean(s, z);
        sharedPreferences$Editor0.commit();
    }

    public void T(String s) {
        SharedPreferences.Editor sharedPreferences$Editor0 = this.A().edit();
        sharedPreferences$Editor0.putString("custom_user_id", s);
        sharedPreferences$Editor0.commit();
        t t0 = this.f;
        if(t0 != null) {
            t0.p(s);
        }
    }

    private void U(String s, String s1) {
        SharedPreferences.Editor sharedPreferences$Editor0 = this.A().edit();
        sharedPreferences$Editor0.putString(s, s1);
        sharedPreferences$Editor0.commit();
    }

    private void V() {
        if(this.g == null) {
            this.g = new HashMap();
        }
        SharedPreferences.Editor sharedPreferences$Editor0 = this.A().edit();
        sharedPreferences$Editor0.putString("global_properties", this.q().toString());
        sharedPreferences$Editor0.commit();
    }

    public void W(String s) {
        p0.k0(s);
    }

    void X(long v) {
        x2.f f0 = new x2.f(v);
        f0.i(x2.f.b.k(v, i0.q));
        i0.q.b.c(f0);
        i0.q.d.d = null;
        i0.q.m = false;
    }

    public void Y() {
        class x2.i0.c implements Runnable {
            final i0 e;

            @Override
            public void run() {
                i0.this.e.r(0x19C748F8809L);
            }
        }

        if(this.d.l == null) {
            return;
        }
        this.P(new x2.i0.c(this));
    }

    public void i() {
        this.g = null;
        this.V();
    }

    void j() {
        class j implements y2.e {
            final i0 a;

            @Override  // y2.e
            public void a(Map map0) {
                if(map0 != null && map0.containsKey("dt_referrer")) {
                    i0.this.k = map0.get("dt_referrer").toString();
                }
            }
        }

        new y2.c().c(this.n(), new j(this));
    }

    void k(long v) {
        class x2.i0.a implements y2.e {
            final CountDownLatch a;
            final long b;
            final i0 c;

            x2.i0.a(CountDownLatch countDownLatch0, long v) {
                this.a = countDownLatch0;
                this.b = v;
                super();
            }

            @Override  // y2.e
            public void a(Map map0) {
                i0.this.h = map0;
                this.a.countDown();
                i0.this.n = p0.e0(this.b);
            }
        }


        class x2.i0.b implements y2.e {
            final CountDownLatch a;
            final i0 b;

            x2.i0.b(CountDownLatch countDownLatch0) {
                this.a = countDownLatch0;
                super();
            }

            @Override  // y2.e
            public void a(Map map0) {
                i0.this.i = map0;
                this.a.countDown();
            }
        }

        CountDownLatch countDownLatch0 = new CountDownLatch(2);
        new y2.d().d(this.n(), new x2.i0.a(this, countDownLatch0, 0x19C748F8856L));
        new y2.g().a(this.n(), new x2.i0.b(this, countDownLatch0));
        try {
            countDownLatch0.await(3L, TimeUnit.SECONDS);
        }
        catch(InterruptedException unused_ex) {
            i0.o.a("InterruptedException!");
        }
        this.X(v);
    }

    void l() {
        class x2.i0.i implements y2.e {
            final i0 a;

            @Override  // y2.e
            public void a(Map map0) {
                i0.this.j = map0;
            }
        }

        new b0().a(this.n(), new x2.i0.i(this));
    }

    e m() {
        return this.b;
    }

    Context n() {
        return this.a;
    }

    public String o() {
        return this.k;
    }

    t p() {
        return this.f;
    }

    public JSONObject q() {
        return new JSONObject(this.g);
    }

    public Map r() {
        return this.h;
    }

    public double s() {
        return this.n;
    }

    public static i0 t() {
        return i0.q;
    }

    public static i0 u(Context context0, b b0) {
        if(i0.q == null) {
            Class class0 = i0.class;
            synchronized(class0) {
                if(i0.q == null) {
                    k0.c = b0.j;
                    k0.d = b0.k;
                    i0.q = new i0(context0, b0);
                }
            }
        }
        i0.q.d = b0;
        return i0.q;
    }

    public boolean v() {
        return this.m;
    }

    public Boolean w() {
        SharedPreferences sharedPreferences0 = this.A();
        return sharedPreferences0.contains("limit_data_sharing") ? Boolean.valueOf(sharedPreferences0.getBoolean("limit_data_sharing", false)) : null;
    }

    public Map x() {
        return this.j;
    }

    public Map y() {
        return this.i;
    }

    g0 z() {
        return this.e;
    }
}

