package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;

public class s implements l {
    class a implements Runnable {
        final s e;

        @Override
        public void run() {
            s.this.h();
            s.this.i();
        }
    }

    class b implements androidx.lifecycle.u.a {
        final s a;

        @Override  // androidx.lifecycle.u$a
        public void a() {
        }

        @Override  // androidx.lifecycle.u$a
        public void b() {
            s.this.b();
        }

        @Override  // androidx.lifecycle.u$a
        public void c() {
            s.this.e();
        }
    }

    private int a;
    private int b;
    private boolean c;
    private boolean d;
    private Handler e;
    private final m f;
    private Runnable g;
    androidx.lifecycle.u.a h;
    private static final s i;

    static {
        s.i = new s();
    }

    private s() {
        this.a = 0;
        this.b = 0;
        this.c = true;
        this.d = true;
        this.f = new m(this);
        this.g = new a(this);
        this.h = new b(this);
    }

    void a() {
        int v = this.b - 1;
        this.b = v;
        if(v == 0) {
            this.e.postDelayed(this.g, 700L);
        }
    }

    void b() {
        int v = this.b + 1;
        this.b = v;
        if(v == 1) {
            if(this.c) {
                this.f.h(androidx.lifecycle.h.b.ON_RESUME);
                this.c = false;
                return;
            }
            this.e.removeCallbacks(this.g);
        }
    }

    void e() {
        int v = this.a + 1;
        this.a = v;
        if(v == 1 && this.d) {
            this.f.h(androidx.lifecycle.h.b.ON_START);
            this.d = false;
        }
    }

    void f() {
        --this.a;
        this.i();
    }

    void g(Context context0) {
        class c extends d {
            @Override  // androidx.lifecycle.d
            public void onActivityCreated(Activity activity0, Bundle bundle0) {
                if(Build.VERSION.SDK_INT < 29) {
                    u.f(activity0).h(s.this.h);
                }
            }

            @Override  // androidx.lifecycle.d
            public void onActivityPaused(Activity activity0) {
                s.this.a();
            }

            @Override  // android.app.Application$ActivityLifecycleCallbacks
            public void onActivityPreCreated(Activity activity0, Bundle bundle0) {
                class androidx.lifecycle.s.c.a extends d {
                    @Override  // android.app.Application$ActivityLifecycleCallbacks
                    public void onActivityPostResumed(Activity activity0) {
                        s.this.b();
                    }

                    @Override  // android.app.Application$ActivityLifecycleCallbacks
                    public void onActivityPostStarted(Activity activity0) {
                        s.this.e();
                    }
                }

                activity0.registerActivityLifecycleCallbacks(new androidx.lifecycle.s.c.a(this));
            }

            @Override  // androidx.lifecycle.d
            public void onActivityStopped(Activity activity0) {
                s.this.f();
            }
        }

        this.e = new Handler();
        this.f.h(androidx.lifecycle.h.b.ON_CREATE);
        ((Application)context0.getApplicationContext()).registerActivityLifecycleCallbacks(new c(this));
    }

    void h() {
        if(this.b == 0) {
            this.c = true;
            this.f.h(androidx.lifecycle.h.b.ON_PAUSE);
        }
    }

    void i() {
        if(this.a == 0 && this.c) {
            this.f.h(androidx.lifecycle.h.b.ON_STOP);
            this.d = true;
        }
    }

    public static l j() {
        return s.i;
    }

    static void k(Context context0) {
        s.i.g(context0);
    }

    @Override  // androidx.lifecycle.l
    public h o() {
        return this.f;
    }
}

