package androidx.core.provider;

import android.graphics.Typeface;
import android.os.Handler;

class a {
    private final c a;
    private final Handler b;

    a(c g$c0, Handler handler0) {
        this.a = g$c0;
        this.b = handler0;
    }

    private void a(int v) {
        class b implements Runnable {
            final c e;
            final int f;
            final a g;

            b(c g$c0, int v) {
                this.e = g$c0;
                this.f = v;
                super();
            }

            @Override
            public void run() {
                this.e.a(this.f);
            }
        }

        b a$b0 = new b(this, this.a, v);
        this.b.post(a$b0);
    }

    void b(e f$e0) {
        if(f$e0.a()) {
            this.c(f$e0.a);
            return;
        }
        this.a(f$e0.b);
    }

    private void c(Typeface typeface0) {
        class androidx.core.provider.a.a implements Runnable {
            final c e;
            final Typeface f;
            final a g;

            androidx.core.provider.a.a(c g$c0, Typeface typeface0) {
                this.e = g$c0;
                this.f = typeface0;
                super();
            }

            @Override
            public void run() {
                this.e.b(this.f);
            }
        }

        androidx.core.provider.a.a a$a0 = new androidx.core.provider.a.a(this, this.a, typeface0);
        this.b.post(a$a0);
    }
}

