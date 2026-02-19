package x2;

import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class o extends n {
    private w a;
    private static final k0 b;

    static {
        o.b = k0.f("o");
    }

    public o(w w0) {
        this.a = w0;
    }

    @Override  // x2.n
    public void a(a n$a0) {
        this.f(n$a0, 3);
    }

    @Override  // x2.n
    public void b(d0 d00, a n$a0) {
    }

    private void f(a n$a0, int v) {
        class b implements x2.w.a {
            final a a;
            final int b;
            final o c;

            b(a n$a0, int v) {
                this.a = n$a0;
                this.b = v;
                super();
            }

            @Override  // x2.w$a
            public void a(String s) {
                o.this.g(this.a, this.b, s);
            }

            @Override  // x2.w$a
            public void b(String s, int v) {
                if(v == 200 && s != null) {
                    try {
                        d0 d00 = d0.b(new JSONObject(s));
                        a n$a0 = this.a;
                        if(n$a0 != null) {
                            n$a0.a(d00);
                        }
                        p0.f0(i0.t().n(), "config");
                    }
                    catch(JSONException jSONException0) {
                        o.b.c(p0.h(jSONException0));
                        o.this.g(this.a, this.b, jSONException0.getMessage());
                    }
                    return;
                }
                o.this.g(this.a, this.b, "get config failed with code = " + v);
            }
        }

        HashMap hashMap0 = new HashMap();
        hashMap0.put("sdk", p0.F());
        t t0 = i0.t().p();
        if(t0 != null) {
            hashMap0.put("p", t0.t);
            hashMap0.put("n", t0.s);
            hashMap0.put("i", t0.p);
            hashMap0.put("v", t0.w);
        }
        int v1 = p0.p(i0.t().n(), "config");
        if(v1 > 3) {
            hashMap0.put("rc", String.valueOf(v1));
        }
        this.a.b("/config", hashMap0, null, new b(this, n$a0, v));
    }

    private void g(a n$a0, int v, String s) {
        class x2.o.a implements Runnable {
            final a e;
            final int f;
            final o g;

            x2.o.a(a n$a0, int v) {
                this.e = n$a0;
                this.f = v;
                super();
            }

            @Override
            public void run() {
                o.this.f(this.e, this.f - 1);
            }
        }

        ScheduledExecutorService scheduledExecutorService0 = Executors.newSingleThreadScheduledExecutor();
        if(v > 0) {
            scheduledExecutorService0.schedule(new x2.o.a(this, n$a0, v), 3000L, TimeUnit.MILLISECONDS);
            return;
        }
        if(n$a0 != null) {
            n$a0.b();
        }
    }
}

