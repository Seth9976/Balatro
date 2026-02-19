package c2;

import java.util.Objects;

final class b2 extends z1 {
    final transient Object[] h;
    private final transient int i;
    static final z1 j;

    static {
        b2.j = new b2(new Object[0], 0);
    }

    b2(Object[] arr_object, int v) {
        this.h = arr_object;
        this.i = v;
    }

    @Override  // c2.z1
    final int e(Object[] arr_object, int v) {
        System.arraycopy(this.h, 0, arr_object, 0, this.i);
        return this.i;
    }

    @Override
    public final Object get(int v) {
        n1.a(v, this.i, "index");
        Object object0 = this.h[v];
        Objects.requireNonNull(object0);
        return object0;
    }

    @Override  // c2.v1
    final int n() {
        return this.i;
    }

    @Override  // c2.v1
    final int o() {
        return 0;
    }

    @Override  // c2.v1
    final Object[] p() {
        return this.h;
    }

    @Override
    public final int size() {
        return this.i;
    }
}

