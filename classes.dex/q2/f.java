package q2;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import n2.g;
import n2.i;
import n2.j;
import n2.l;
import v2.c;

public final class f extends c {
    class a extends Writer {
        a() {
            super();
        }

        @Override
        public void close() {
            throw new AssertionError();
        }

        @Override
        public void flush() {
            throw new AssertionError();
        }

        @Override
        public void write(char[] arr_c, int v, int v1) {
            throw new AssertionError();
        }
    }

    private final List q;
    private String r;
    private g s;
    private static final Writer t;
    private static final l u;

    static {
        f.t = new a();
        f.u = new l("closed");
    }

    public f() {
        super(f.t);
        this.q = new ArrayList();
        this.s = i.e;
    }

    @Override  // v2.c
    public c B(double f) {
        if(!this.j() && (Double.isNaN(f) || Double.isInfinite(f))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + f);
        }
        this.N(new l(f));
        return this;
    }

    @Override  // v2.c
    public c D(long v) {
        this.N(new l(v));
        return this;
    }

    @Override  // v2.c
    public c E(Boolean boolean0) {
        if(boolean0 == null) {
            return this.n();
        }
        this.N(new l(boolean0));
        return this;
    }

    @Override  // v2.c
    public c F(Number number0) {
        if(number0 == null) {
            return this.n();
        }
        if(!this.j()) {
            double f = number0.doubleValue();
            if(Double.isNaN(f) || Double.isInfinite(f)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number0);
            }
        }
        this.N(new l(number0));
        return this;
    }

    @Override  // v2.c
    public c G(String s) {
        if(s == null) {
            return this.n();
        }
        this.N(new l(s));
        return this;
    }

    @Override  // v2.c
    public c I(boolean z) {
        this.N(new l(Boolean.valueOf(z)));
        return this;
    }

    public g L() {
        if(!this.q.isEmpty()) {
            throw new IllegalStateException("Expected one JSON element but was " + this.q);
        }
        return this.s;
    }

    private g M() {
        return (g)this.q.get(this.q.size() - 1);
    }

    private void N(g g0) {
        if(this.r != null) {
            ((j)this.M()).t(this.r, g0);
            this.r = null;
            return;
        }
        if(this.q.isEmpty()) {
            this.s = g0;
            return;
        }
        g g1 = this.M();
        if(!(g1 instanceof n2.f)) {
            throw new IllegalStateException();
        }
        ((n2.f)g1).t(g0);
    }

    @Override  // v2.c
    public c c() {
        n2.f f0 = new n2.f();
        this.N(f0);
        this.q.add(f0);
        return this;
    }

    @Override  // v2.c
    public void close() {
        if(!this.q.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.q.add(f.u);
    }

    @Override  // v2.c
    public c d() {
        j j0 = new j();
        this.N(j0);
        this.q.add(j0);
        return this;
    }

    @Override  // v2.c
    public c f() {
        if(this.q.isEmpty() || this.r != null || !(this.M() instanceof n2.f)) {
            throw new IllegalStateException();
        }
        this.q.remove(this.q.size() - 1);
        return this;
    }

    @Override  // v2.c
    public void flush() {
    }

    @Override  // v2.c
    public c g() {
        if(this.q.isEmpty() || this.r != null || !(this.M() instanceof j)) {
            throw new IllegalStateException();
        }
        this.q.remove(this.q.size() - 1);
        return this;
    }

    @Override  // v2.c
    public c l(String s) {
        Objects.requireNonNull(s, "name == null");
        if(this.q.isEmpty() || this.r != null || !(this.M() instanceof j)) {
            throw new IllegalStateException();
        }
        this.r = s;
        return this;
    }

    @Override  // v2.c
    public c n() {
        this.N(i.e);
        return this;
    }
}

