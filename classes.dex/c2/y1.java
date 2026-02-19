package c2;

import java.util.List;

final class y1 extends z1 {
    final transient int h;
    final transient int i;
    final z1 j;

    y1(z1 z10, int v, int v1) {
        this.j = z10;
        super();
        this.h = v;
        this.i = v1;
    }

    @Override
    public final Object get(int v) {
        n1.a(v, this.i, "index");
        return this.j.get(v + this.h);
    }

    @Override  // c2.v1
    final int n() {
        return this.j.o() + this.h + this.i;
    }

    @Override  // c2.v1
    final int o() {
        return this.j.o() + this.h;
    }

    @Override  // c2.v1
    final Object[] p() {
        return this.j.p();
    }

    @Override  // c2.z1
    public final z1 q(int v, int v1) {
        n1.c(v, v1, this.i);
        return this.j.q(v + this.h, v1 + this.h);
    }

    @Override
    public final int size() {
        return this.i;
    }

    @Override  // c2.z1
    public final List subList(int v, int v1) {
        return this.q(v, v1);
    }
}

