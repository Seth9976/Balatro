package q1;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Application;
import android.os.Looper;
import e1.b0;
import g2.j;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

public final class q {
    private final Application a;
    private final Application.ActivityLifecycleCallbacks b;
    private final Object c;
    private final Set d;
    private WeakReference e;
    private boolean f;
    private static final AtomicReference g;
    public static final int h;

    static {
        q.g = new AtomicReference();
    }

    public q(Application application0) {
        this.b = new p(this, null);
        this.c = new Object();
        this.d = Collections.newSetFromMap(new WeakHashMap());
        this.f = false;
        this.a = application0;
    }

    public final Activity a() {
        synchronized(this.c) {
            return this.e == null ? null : ((Activity)this.e.get());
        }
    }

    public static q b(Application application0) {
        g1.q.i(application0);
        AtomicReference atomicReference0 = q.g;
        q q0 = (q)atomicReference0.get();
        if(q0 != null) {
            return q0;
        }
        q q1 = new q(application0);
        while(!b0.a(atomicReference0, null, q1) && atomicReference0.get() == null) {
        }
        return (q)q.g.get();
    }

    static void c(q q0, Activity activity0) {
        synchronized(q0.c) {
            WeakReference weakReference0 = q0.e;
            if(weakReference0 == null) {
                return;
            }
            if(weakReference0.get() == activity0) {
                q0.e = null;
            }
        }
    }

    static void d(q q0, Activity activity0) {
        g1.q.i(activity0);
        synchronized(q0.c) {
            if(q0.a() == activity0) {
                return;
            }
            q0.e = new WeakReference(activity0);
            for(Object object1: q0.d) {
                ((n)object1).a(activity0);
            }
        }
    }

    public final void e(n n0) {
        g1.q.i(n0);
        synchronized(this.c) {
            this.d.add(n0);
        }
        if(Looper.myLooper() == Looper.getMainLooper()) {
            this.h(n0);
            return;
        }
        m m0 = () -> this.h(n0);
        j.a.execute(m0);
    }

    // 检测为 Lambda 实现
    final void f(n n0) [...]

    public final void g() {
        synchronized(this.c) {
            if(!this.f) {
                this.a.registerActivityLifecycleCallbacks(this.b);
                this.f = true;
            }
        }
    }

    private final void h(n n0) {
        Activity activity0 = this.a();
        if(activity0 == null) {
            return;
        }
        n0.a(activity0);
    }
}

