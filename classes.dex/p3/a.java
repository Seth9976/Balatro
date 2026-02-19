package p3;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import k3.f;

public final class a implements b {
    private final AtomicReference a;

    public a(b b0) {
        f.e(b0, "sequence");
        super();
        this.a = new AtomicReference(b0);
    }

    @Override  // p3.b
    public Iterator iterator() {
        b b0 = (b)this.a.getAndSet(null);
        if(b0 == null) {
            throw new IllegalStateException("This sequence can be consumed only once.");
        }
        return b0.iterator();
    }
}

