package x2;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

public class e0 {
    private String a;
    private static final k0 b;

    static {
        e0.b = k0.f("e0");
    }

    // 去混淆评级： 低(20)
    public boolean b() {
        return !p0.V(this.a) || i0.t().n().getSharedPreferences("singular-pref-session", 0).contains("custom-sdid");
    }

    public String c() {
        return this.a;
    }

    public void d(Context context0) {
        this.a = context0.getSharedPreferences("singular-pref-session", 0).getString("pref-singular-device-id", null);
    }

    public void e(Context context0, String s) {
        e0.b.a("saving SDID to prefs : " + s);
        SharedPreferences.Editor sharedPreferences$Editor0 = context0.getSharedPreferences("singular-pref-session", 0).edit();
        sharedPreferences$Editor0.putString("pref-singular-device-id", s);
        sharedPreferences$Editor0.commit();
        this.d(context0);
    }

    public void f(t t0, Context context0) {
        class a implements x2.w.a {
            final Context a;
            final e0 b;

            a(Context context0) {
                this.a = context0;
                super();
            }

            @Override  // x2.w$a
            public void a(String s) {
                e0.b.e("onFailure to /resolve SDID with error: %s", new Object[]{s});
            }

            @Override  // x2.w$a
            public void b(String s, int v) {
                if(v == 200 && !p0.V(s)) {
                    e0.b.a("/resolve request successful");
                    p0.f0(i0.t().n(), "resolve");
                    try {
                        if(e0.this.b()) {
                            e0.b.a("/resolve request successful, but ignoring, because SDID already exists, exiting.");
                            return;
                        }
                        JSONObject jSONObject0 = new JSONObject(s);
                        if(!jSONObject0.has("sdid")) {
                            e0.b.a("SDID not found in response");
                            return;
                        }
                        String s1 = jSONObject0.getString("sdid");
                        if(!p0.V(s1)) {
                            e0.b.b("SDID resolved successfully: %s", new Object[]{s1});
                            e0.this.e(this.a, s1);
                            i0.t().B().getClass();
                        }
                    }
                    catch(Throwable throwable0) {
                        e0.b.e("failed to resolve SDID with throwable: %s", new Object[]{p0.h(throwable0)});
                    }
                }
            }
        }

        synchronized(this) {
            if(this.b()) {
                e0.b.a("sdid exists, exiting /resolve request flow");
                return;
            }
            v v1 = new v();
            m0 m00 = new m0().j(t0);
            int v2 = p0.p(i0.t().n(), "resolve");
            if(v2 > 3) {
                m00.put("rc", String.valueOf(v2));
            }
            m00.put("sdk", p0.F());
            v1.d("/resolve", m00, null, new a(this, context0));
        }
    }
}

