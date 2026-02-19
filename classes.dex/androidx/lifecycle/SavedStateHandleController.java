package androidx.lifecycle;

import z.c;

final class SavedStateHandleController implements j {
    private boolean a;

    @Override  // androidx.lifecycle.j
    public void d(l l0, b h$b0) {
        if(h$b0 == b.ON_DESTROY) {
            this.a = false;
            l0.o().c(this);
        }
    }

    void h(c c0, h h0) {
        if(this.a) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.a = true;
        h0.a(this);
        throw null;
    }

    boolean i() {
        return this.a;
    }
}

