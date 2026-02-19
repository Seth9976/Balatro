package androidx.activity;

import androidx.core.util.a;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class h {
    private boolean a;
    private CopyOnWriteArrayList b;
    private a c;

    public h(boolean z) {
        this.b = new CopyOnWriteArrayList();
        this.a = z;
    }

    void a(androidx.activity.a a0) {
        this.b.add(a0);
    }

    public abstract void b();

    public final boolean c() {
        return this.a;
    }

    public final void d() {
        for(Object object0: this.b) {
            ((androidx.activity.a)object0).cancel();
        }
    }

    void e(androidx.activity.a a0) {
        this.b.remove(a0);
    }

    public final void f(boolean z) {
        this.a = z;
        a a0 = this.c;
        if(a0 != null) {
            a0.accept(Boolean.valueOf(z));
        }
    }

    void g(a a0) {
        this.c = a0;
    }
}

