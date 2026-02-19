package r3;

import d3.e;
import h.d;

public final class x extends c {
    public static final x f;

    static {
        x.f = new x();
    }

    @Override  // r3.c
    public void a(e e0, Runnable runnable0) {
        d.a(e0.get(y.e));
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override  // r3.c
    public boolean b(e e0) {
        return false;
    }

    @Override  // r3.c
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}

