package p0;

import h0.h;
import j0.i;
import j0.o;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import k0.m;
import q0.x;
import r0.d;
import s0.b;

public class c implements e {
    private final x a;
    private final Executor b;
    private final k0.e c;
    private final d d;
    private final b e;
    private static final Logger f;

    static {
        c.f = Logger.getLogger("j0.t");
    }

    public c(Executor executor0, k0.e e0, x x0, d d0, b b0) {
        this.b = executor0;
        this.c = e0;
        this.a = x0;
        this.d = d0;
        this.e = b0;
    }

    @Override  // p0.e
    public void a(o o0, i i0, h h0) {
        a a0 = () -> try {
            String s = o0.b();
            m m0 = this.c.a(s);
            if(m0 == null) {
                String s1 = String.format("Transport backend \'%s\' is not registered", o0.b());
                c.f.warning(s1);
                h0.a(new IllegalArgumentException(s1));
                return;
            }
            p0.b b0 = () -> {
                this.d.C(o0, m0.a(i0));
                this.a.a(o0, 1);
                return null;
            };
            this.e.b(b0);
            h0.a(null);
        }
        catch(Exception exception0) {
            c.f.warning("Error scheduling event " + exception0.getMessage());
            h0.a(exception0);
        };
        this.b.execute(a0);
    }

    // 检测为 Lambda 实现
    private Object d(o o0, i i0) [...]

    // 检测为 Lambda 实现
    private void e(o o0, h h0, i i0) [...]
}

