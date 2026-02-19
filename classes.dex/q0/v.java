package q0;

import j0.o;
import java.util.concurrent.Executor;
import r0.d;
import s0.b;

public class v {
    private final Executor a;
    private final d b;
    private final x c;
    private final b d;

    v(Executor executor0, d d0, x x0, b b0) {
        this.a = executor0;
        this.b = d0;
        this.c = x0;
        this.d = b0;
    }

    public void c() {
        t t0 = () -> {
            u u0 = () -> {
                for(Object object0: this.b.h0()) {
                    this.c.a(((o)object0), 1);
                }
                return null;
            };
            this.d.b(u0);
        };
        this.a.execute(t0);
    }

    // 检测为 Lambda 实现
    private Object d() [...]

    // 检测为 Lambda 实现
    private void e() [...]
}

