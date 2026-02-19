package kotlinx.coroutines.scheduling;

import d3.e;
import d3.f;
import java.util.concurrent.Executor;
import r3.c;
import r3.r;
import t3.o;

public final class b extends r implements Executor {
    public static final b g;
    private static final c h;

    static {
        b.g = new b();
        int v = o.d("kotlinx.coroutines.io.parallelism", 0x40, 0, 0, 12, null);
        b.h = m.f.c(v);
    }

    @Override  // r3.c
    public void a(e e0, Runnable runnable0) {
        b.h.a(e0, runnable0);
    }

    // 去混淆评级： 低(20)
    @Override
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO");
    }

    @Override
    public void execute(Runnable runnable0) {
        this.a(f.e, runnable0);
    }

    @Override  // r3.c
    public String toString() {
        return "Dispatchers.IO";
    }
}

