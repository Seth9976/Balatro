package g2;

import java.util.concurrent.Executor;

final class m implements x {
    private final Executor a;
    private final a b;
    private final c0 c;

    public m(Executor executor0, a a0, c0 c00) {
        this.a = executor0;
        this.b = a0;
        this.c = c00;
    }

    @Override  // g2.x
    public final void a(h h0) {
        l l0 = new l(this, h0);
        this.a.execute(l0);
    }

    @Override  // g2.x
    public final void c() {
        throw new UnsupportedOperationException();
    }
}

