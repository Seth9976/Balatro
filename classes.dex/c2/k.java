package c2;

import android.app.Application;
import e1.b0;
import g1.q;
import java.util.concurrent.atomic.AtomicReference;

public final class k {
    private final j a;
    private final m b;
    private static final AtomicReference c;

    static {
        k.c = new AtomicReference();
    }

    k(Application application0, m m0) {
        this.a = new j(this, application0, null);
        this.b = m0;
    }

    static k a(Application application0) {
        AtomicReference atomicReference0 = k.c;
        k k0 = (k)atomicReference0.get();
        if(k0 != null) {
            return k0;
        }
        k k1 = new k(application0, o.a(application0));
        while(!b0.a(atomicReference0, null, k1) && atomicReference0.get() == null) {
        }
        return (k)q.i(((k)k.c.get()));
    }

    public final void c() {
        f1.a("AutomaticGamesAuthenticator", "startWatching()");
        j.a(this.a);
    }
}

