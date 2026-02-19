package x2;

import org.json.JSONException;
import org.json.JSONObject;

public class g extends h {
    public class a implements x2.a.a {
        final g a;

        @Override  // x2.a$a
        public boolean a(i0 i00, int v, String s) {
            switch(v) {
                case 200: {
                    try {
                        if(new JSONObject(s).optString("status", "").equalsIgnoreCase("ok")) {
                            return true;
                        }
                    }
                    catch(JSONException jSONException0) {
                        g.f.d("error in handle()", jSONException0);
                    }
                    return false;
                }
                case 413: {
                    return true;
                }
                default: {
                    return false;
                }
            }
        }
    }

    static class b extends m0 {
        @Override  // x2.m0
        protected m0 j(t t0) {
            return this.l(t0);
        }

        static b k(c g$c0, i0 i00) {
            long v = i00.z().f();
            return new b().n(g$c0.a).m(g$c0.b).o(((double)(g$c0.c - v)) * 0.001).q(v).p(i00.z().e()).r(i00.B()).l(i00.p());
        }

        protected b l(t t0) {
            super.j(t0);
            this.g("av", t0.m);
            this.g("sdk", p0.F());
            this.g("custom_user_id", t0.R);
            return this;
        }

        private b m(String s) {
            try {
                if(p0.V(s)) {
                    s = new JSONObject().put("is_revenue_event", false).toString();
                }
                else {
                    JSONObject jSONObject0 = new JSONObject(s);
                    if(!jSONObject0.optBoolean("is_revenue_event", false)) {
                        s = jSONObject0.put("is_revenue_event", false).toString();
                    }
                }
                this.g("e", s);
            }
            catch(JSONException jSONException0) {
                g.f.d("Error in JSON serialization", jSONException0);
            }
            return this;
        }

        private b n(String s) {
            this.g("n", s);
            return this;
        }

        private b o(double f) {
            this.g("t", String.valueOf(f));
            return this;
        }

        private b p(long v) {
            this.g("seq", String.valueOf(v));
            return this;
        }

        private b q(long v) {
            this.g("s", String.valueOf(v));
            return this;
        }

        private b r(w2.b b0) {
            this.g("a", b0.a);
            return this;
        }
    }

    public static class c {
        final String a;
        final String b;
        final long c;

        c(String s, String s1) {
            this.a = s.replace("\\n", "");
            this.b = p0.V(s1) ? null : s1.replace("\\n", "");
            this.c = 1771482087105L;
        }

        // 去混淆评级： 低(20)
        @Override
        public String toString() {
            return "RawEvent{name=\'" + this.a + '\'' + ", extra=\'" + this.b + '\'' + ", timestamp=" + this.c + '}';
        }
    }

    private static final k0 f;

    static {
        g.f = k0.f("g");
    }

    g(long v) {
        super("EVENT", v);
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
        return "/event";
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
}

