package r3;

import b3.b;
import d3.e;

public abstract class f {
    public static final void a(e e0, Throwable throwable0) {
        try {
            d d0 = (d)e0.get(d.c);
            if(d0 != null) {
                d0.handleException(e0, throwable0);
                return;
            }
        }
        catch(Throwable throwable1) {
            r3.e.a(e0, f.b(throwable0, throwable1));
            return;
        }
        r3.e.a(e0, throwable0);
    }

    public static final Throwable b(Throwable throwable0, Throwable throwable1) {
        if(throwable0 == throwable1) {
            return throwable0;
        }
        Throwable throwable2 = new RuntimeException("Exception while trying to handle coroutine exception", throwable1);
        b.a(throwable2, throwable0);
        return throwable2;
    }
}

