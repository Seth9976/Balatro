package d3;

import j3.p;
import k3.f;

public abstract class a implements b {
    private final c key;

    public a(c e$c0) {
        f.e(e$c0, "key");
        super();
        this.key = e$c0;
    }

    @Override  // d3.e
    public Object fold(Object object0, p p0) {
        return d3.e.b.a.a(this, object0, p0);
    }

    @Override  // d3.e$b
    public b get(c e$c0) {
        return d3.e.b.a.b(this, e$c0);
    }

    @Override  // d3.e$b
    public c getKey() {
        return this.key;
    }

    @Override  // d3.e
    public e minusKey(c e$c0) {
        return d3.e.b.a.c(this, e$c0);
    }

    public e plus(e e0) {
        return d3.e.b.a.d(this, e0);
    }
}

