package x2;

import android.net.Uri;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public class f extends h {
    public class a implements x2.a.a {
        final f a;

        @Override  // x2.a$a
        public boolean a(i0 i00, int v, String s) {
            if(v != 200) {
                return false;
            }
            try {
                JSONObject jSONObject0 = new JSONObject(s);
                if(!jSONObject0.optString("status", "").equalsIgnoreCase("ok")) {
                    return false;
                }
                String s1 = jSONObject0.optString("ddl", null);
                String s2 = jSONObject0.optString("deferred_passthrough", null);
                if(!p0.b0() && (!p0.V(s1) || !p0.V(s2))) {
                    this.c(i00, s1, s2);
                }
                String s3 = jSONObject0.optString("resolved_singular_link", null);
                if(!p0.V(s3)) {
                    String s4 = (String)f.this.get("singular_link_resolve_required");
                    if(s4 != null && Boolean.parseBoolean(s4) && p0.e0(f.this.f()) < ((double)i0.t().B().m)) {
                        p0.L(Uri.parse(s3));
                    }
                }
                JSONObject jSONObject1 = jSONObject0.optJSONObject("attribution_info");
                if(jSONObject1 != null) {
                    i00.C(jSONObject1);
                }
                String s5 = (String)f.this.get("u");
                if(!p0.V(s5) && !p0.Z(i00.n(), s5)) {
                    p0.i0(i00.n(), s5);
                    this.e(i00, s5);
                }
                return true;
            }
            catch(JSONException jSONException0) {
                f.g.d("error in handle()", jSONException0);
                return false;
            }
        }

        void c(i0 i00, String s, String s1) {
            i00.B().getClass();
            f.g.e("DDLHandler is not configured, ignoring callback for url = %s", new Object[]{s});
        }

        private boolean d(int v) {
            return v != -1 && v != 4 && v != 0x101;
        }

        void e(i0 i00, String s) {
            class x2.f.a.a implements Runnable {
                final i0 e;
                final String f;
                final a g;

                x2.f.a.a(i0 i00, String s) {
                    this.e = i00;
                    this.f = s;
                    super();
                }

                @Override
                public void run() {
                    class x2.f.a.a.a extends x2.x.a {
                        final x2.f.a.a a;

                        @Override  // x2.x$a
                        public void a(int v, String s, String s1) {
                            class x2.f.a.a.a.a implements Runnable {
                                final int e;
                                final String f;
                                final String g;
                                final x2.f.a.a.a h;

                                x2.f.a.a.a.a(int v, String s, String s1) {
                                    this.e = v;
                                    this.f = s;
                                    this.g = s1;
                                    super();
                                }

                                @Override
                                public void run() {
                                    try {
                                        if(!a.this.d(this.e) && f.this.f < 3) {
                                            Thread.sleep(f.this.f * 3000);
                                            a.this.e(x2.f.a.a.this.e, x2.f.a.a.this.f);
                                            return;
                                        }
                                        JSONObject jSONObject0 = new JSONObject();
                                        jSONObject0.put("responseCode", String.valueOf(this.e));
                                        jSONObject0.put("signedData", this.f);
                                        jSONObject0.put("signature", this.g);
                                        c g$c0 = new c("__LicensingStatus", jSONObject0.toString());
                                        x2.f.a.a.this.e.K(g$c0);
                                    }
                                    catch(Throwable throwable0) {
                                        f.g.d("Error occurred while trying to send licensing status event", throwable0);
                                    }
                                }
                            }

                            new Thread(new x2.f.a.a.a.a(this, v, s, s1)).start();
                        }
                    }

                    f.r(f.this);
                    x2.f.a.a.a f$a$a$a0 = new x2.f.a.a.a(this);
                    x.a(this.e.n(), f$a$a$a0);
                }
            }

            f.g.a("Trying to fetch license key from the Licensing Service");
            new Thread(new x2.f.a.a(this, i00, s)).start();
        }
    }

    static class b extends m0 {
        @Override  // x2.m0
        protected m0 j(t t0) {
            return this.o(t0);
        }

        static b k(long v, i0 i00) {
            return new b().p(v).r(i00.B()).o(i00.p()).m(p0.u(i00.n())).l(i00).q(i00).n(i00).s();
        }

        private b l(i0 i00) {
            this.g("is", (i00.v() ? "true" : "false"));
            return this;
        }

        private b m(String s) {
            this.g("c", s);
            return this;
        }

        private b n(i0 i00) {
            if(i00.v() && i00.o() != null) {
                this.g("dt_referrer", i00.o());
            }
            return this;
        }

        protected b o(t t0) {
            super.j(t0);
            this.g("ab", t0.l);
            this.g("av", t0.m);
            this.g("br", t0.n);
            this.g("de", t0.o);
            this.g("ma", t0.q);
            this.g("mo", t0.r);
            this.g("n", t0.s);
            this.g("pr", t0.u);
            this.g("sdk", p0.F());
            String s = "1";
            if(!t0.f) {
                if(!t0.i) {
                    s = "-1";
                }
                else if(!t0.g) {
                    s = "0";
                }
            }
            else if(!t0.g) {
                s = "0";
            }
            this.g("dnt", s);
            this.g("v", t0.w);
            if(!p0.V(t0.L)) {
                this.g("src", t0.L);
            }
            if(!p0.V(t0.J)) {
                this.g("ri", t0.J);
            }
            if(!p0.V(t0.K)) {
                this.g("fi", t0.K);
            }
            if(t0.m()) {
                this.g("apc", t0.M);
                this.g("apg", t0.N);
                this.g("aps", t0.O);
            }
            this.g("lc", Locale.getDefault().toString());
            this.g("install_time", t0.P.toString());
            this.g("update_time", t0.Q.toString());
            this.g("current_device_time", "1771482087519");
            this.g("device_type", t0.y);
            this.g("custom_user_id", t0.R);
            if(!p0.V(t0.S)) {
                this.g("device_user_agent", t0.S);
            }
            return this;
        }

        private b p(long v) {
            this.g("s", String.valueOf(v));
            return this;
        }

        private b q(i0 i00) {
            if(i00.v()) {
                if(i00.r() != null) {
                    this.g("install_ref", new JSONObject(i00.r()).toString());
                }
                this.g("install_ref_timeinterval", String.valueOf(i00.s()));
                HashMap hashMap0 = new HashMap();
                if(i00.y() != null) {
                    hashMap0.putAll(i00.y());
                }
                if(i00.x() != null) {
                    hashMap0.putAll(i00.x());
                }
                this.g("referrer_data", new JSONObject(hashMap0).toString());
            }
            return this;
        }

        private b r(w2.b b0) {
            this.g("a", b0.a);
            Uri uri0 = b0.d;
            if(z2.a.a(uri0)) {
                this.g("ref", uri0.getQueryParameter("referrer"));
                this.g("extra", uri0.getQuery());
            }
            this.g("ddl_enabled", "false");
            Uri uri1 = b0.l;
            if(z2.a.a(uri1)) {
                String s = uri1.getQueryParameter("referrer");
                String s1 = uri1.getQuery();
                if(!p0.V(s)) {
                    this.g("ref", s);
                }
                if(!p0.V(s1)) {
                    this.g("extra", s1);
                }
                if(p0.U(uri1)) {
                    this.g("esp_link", uri1.toString());
                    uri1 = p0.g0(uri1);
                }
                if(p0.m0(uri1)) {
                    boolean z = p0.c0(uri1);
                    if(!z) {
                        p0.L(uri1);
                    }
                    this.g("singular_link", uri1.toString());
                    this.g("singular_link_resolve_timeout", String.valueOf(b0.m));
                    this.g("singular_link_resolve_required", String.valueOf(z));
                }
                b0.l = null;
            }
            return this;
        }

        // 去混淆评级： 低(26)
        private b s() {
            this.g("asid_timeinterval", "0.0");
            this.g("asid_scope", "0");
            return this;
        }
    }

    private int f;
    private static final k0 g;

    static {
        f.g = k0.f("f");
    }

    f(long v) {
        super("SESSION_START", v);
        this.f = 0;
    }

    @Override  // x2.h
    public boolean a(i0 i00) {
        return super.a(i00);
    }

    @Override  // x2.a
    public x2.a.a c() {
        return new a(this);
    }

    @Override  // x2.a
    public String d() {
        return "/start";
    }

    @Override  // x2.h
    public long f() {
        return super.f();
    }

    @Override  // x2.h
    public String m() {
        return super.m();
    }

    @Override  // x2.h
    public boolean n() {
        return super.n();
    }

    @Override  // x2.h
    public String o() {
        return super.o();
    }

    static int r(f f0) {
        int v = f0.f;
        f0.f = v + 1;
        return v;
    }
}

