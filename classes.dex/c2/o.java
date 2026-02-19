package c2;

import android.app.Application;
import e1.b0;
import java.util.concurrent.atomic.AtomicReference;
import q1.q;
import t1.b;

public abstract class o {
    private static final AtomicReference a;

    static {
        o.a = new AtomicReference();
    }

    public static m a(Application application0) {
        AtomicReference atomicReference0 = o.a;
        m m0 = (m)atomicReference0.get();
        if(m0 != null) {
            return m0;
        }
        a2 a20 = i2.a();
        a20.a(9);
        a20.b("com.playstack.balatro.android");
        i2 i20 = a20.c();
        q q0 = q.b(application0);
        c0 c00 = new c0(application0, q0, b.a(), new g0(application0, q0, new n(application0, i20)));
        while(!b0.a(atomicReference0, null, c00) && atomicReference0.get() == null) {
        }
        return (m)g1.q.i(((m)o.a.get()));
    }
}

