package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import t3.o;

public abstract class l {
    public static final long a;
    public static final int b;
    public static final int c;
    public static final long d;
    public static g e;
    public static final i f;
    public static final i g;

    static {
        l.a = o.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        l.b = o.d("kotlinx.coroutines.scheduler.core.pool.size", 8, 1, 0, 8, null);
        l.c = o.d("kotlinx.coroutines.scheduler.max.pool.size", 0x1FFFFE, 0, 0x1FFFFE, 4, null);
        l.d = TimeUnit.SECONDS.toNanos(o.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
        l.e = e.a;
        l.f = new j(0);
        l.g = new j(1);
    }
}

