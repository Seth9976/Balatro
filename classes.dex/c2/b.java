package c2;

import h.d;
import java.util.concurrent.atomic.AtomicReference;

public abstract class b {
    private final AtomicReference a;

    public b() {
        this.a = new AtomicReference();
    }

    public final void a() {
        d.a(this.a.get());
    }
}

