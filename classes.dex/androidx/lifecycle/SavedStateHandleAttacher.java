package androidx.lifecycle;

import k3.f;

public final class SavedStateHandleAttacher implements j {
    private final w a;

    public SavedStateHandleAttacher(w w0) {
        f.e(w0, "provider");
        super();
        this.a = w0;
    }

    @Override  // androidx.lifecycle.j
    public void d(l l0, b h$b0) {
        f.e(l0, "source");
        f.e(h$b0, "event");
        if(h$b0 != b.ON_CREATE) {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + h$b0).toString());
        }
        l0.o().c(this);
        this.a.c();
    }
}

