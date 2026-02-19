package r3;

import b3.b;
import b3.j;
import java.util.List;
import java.util.ServiceLoader;
import p3.f;
import p3.h;

public abstract class e {
    private static final List a;

    static {
        e.a = h.d(f.a(ServiceLoader.load(d.class, d.class.getClassLoader()).iterator()));
    }

    public static final void a(d3.e e0, Throwable throwable0) {
        Thread thread1;
        for(Object object0: e.a) {
            d d0 = (d)object0;
            try {
                d0.handleException(e0, throwable0);
            }
            catch(Throwable throwable1) {
                Thread thread0 = Thread.currentThread();
                thread0.getUncaughtExceptionHandler().uncaughtException(thread0, r3.f.b(throwable0, throwable1));
            }
        }
        try {
            thread1 = Thread.currentThread();
            b.a(throwable0, new k(e0));
        }
        catch(Throwable throwable2) {
            j.a(throwable2);
        }
        thread1.getUncaughtExceptionHandler().uncaughtException(thread1, throwable0);
    }
}

