package f3;

import k3.f;

public class a extends e3.a {
    @Override  // e3.a
    public void a(Throwable throwable0, Throwable throwable1) {
        f.e(throwable0, "cause");
        f.e(throwable1, "exception");
        throwable0.addSuppressed(throwable1);
    }
}

