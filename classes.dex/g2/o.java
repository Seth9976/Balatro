package g2;

import java.util.concurrent.Executor;

final class o implements c, e, f, x {
    private final Executor a;
    private final a b;
    private final c0 c;

    public o(Executor executor0, a a0, c0 c00) {
        this.a = executor0;
        this.b = a0;
        this.c = c00;
    }

    @Override  // g2.x
    public final void a(h h0) {
        n n0 = new n(this, h0);
        this.a.execute(n0);
    }

    @Override  // g2.c
    public final void b() {
        this.c.t();
    }

    @Override  // g2.x
    public final void c() {
        throw new UnsupportedOperationException();
    }

    @Override  // g2.e
    public final void d(Exception exception0) {
        this.c.r(exception0);
    }

    @Override  // g2.f
    public final void e(Object object0) {
        this.c.s(object0);
    }
}

