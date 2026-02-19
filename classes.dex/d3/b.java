package d3;

import j3.l;
import k3.f;

public abstract class b implements c {
    private final l a;
    private final c b;

    public b(c e$c0, l l0) {
        f.e(e$c0, "baseKey");
        f.e(l0, "safeCast");
        super();
        this.a = l0;
        if(e$c0 instanceof b) {
            e$c0 = ((b)e$c0).b;
        }
        this.b = e$c0;
    }

    public final boolean a(c e$c0) {
        f.e(e$c0, "key");
        return e$c0 == this || this.b == e$c0;
    }

    public final d3.e.b b(d3.e.b e$b0) {
        f.e(e$b0, "element");
        return (d3.e.b)this.a.c(e$b0);
    }
}

