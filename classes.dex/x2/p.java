package x2;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class p extends n {
    private Context a;
    private static final k0 b;

    static {
        p.b = k0.f("p");
    }

    public p(Context context0) {
        this.a = context0;
    }

    @Override  // x2.n
    public void a(a n$a0) {
        class x2.p.a implements Runnable {
            final a e;
            final p f;

            x2.p.a(a n$a0) {
                this.e = n$a0;
                super();
            }

            @Override
            public void run() {
                try {
                    String s = p.this.a.getSharedPreferences("singular-pref-config-manager", 0).getString("config_manager_config", null);
                    if(s == null) {
                        a n$a0 = this.e;
                        if(n$a0 != null) {
                            n$a0.b();
                        }
                        return;
                    }
                    d0 d00 = d0.b(new JSONObject(s));
                    a n$a1 = this.e;
                    if(n$a1 != null) {
                        n$a1.a(d00);
                    }
                }
                catch(Throwable throwable0) {
                    p.b.c(p0.h(throwable0));
                    a n$a2 = this.e;
                    if(n$a2 != null) {
                        n$a2.b();
                    }
                }
            }
        }

        Executors.newSingleThreadExecutor().execute(new x2.p.a(this, n$a0));
    }

    @Override  // x2.n
    public void b(d0 d00, a n$a0) {
        class b implements Runnable {
            final d0 e;
            final a f;
            final p g;

            b(d0 d00, a n$a0) {
                this.e = d00;
                this.f = n$a0;
                super();
            }

            @Override
            public void run() {
                try {
                    SharedPreferences.Editor sharedPreferences$Editor0 = p.this.a.getSharedPreferences("singular-pref-config-manager", 0).edit();
                    sharedPreferences$Editor0.putString("config_manager_config", this.e.e().toString());
                    sharedPreferences$Editor0.commit();
                    a n$a0 = this.f;
                    if(n$a0 != null) {
                        n$a0.a(this.e);
                    }
                }
                catch(Throwable throwable0) {
                    p.b.c(p0.h(throwable0));
                    a n$a1 = this.f;
                    if(n$a1 != null) {
                        n$a1.b();
                    }
                }
            }
        }

        Executors.newSingleThreadExecutor().execute(new b(this, d00, n$a0));
    }
}

