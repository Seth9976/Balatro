package c2;

import d1.e;
import g2.h;
import g2.i;

final class b0 {
    private final i a;
    private final f b;

    public b0(f f0, i i0) {
        this.b = f0;
        this.a = i0;
    }

    public final void a(e e0) {
        this.b.a(e0).d(f2.a(), (h h0) -> {
            if(h0.q()) {
                Object object0 = h0.n();
                this.a.c(object0);
                return;
            }
            Exception exception0 = h0.m();
            p1.a(exception0);
            this.a.b(exception0);
        });
    }

    // 检测为 Lambda 实现
    final void b(h h0) [...]

    public final void c(Exception exception0) {
        this.a.b(exception0);
    }
}

