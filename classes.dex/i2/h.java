package i2;

class h extends c {
    final transient Object[] g;
    private final transient int h;
    static final c i;

    static {
        h.i = new h(new Object[0], 0);
    }

    h(Object[] arr_object, int v) {
        this.g = arr_object;
        this.h = v;
    }

    @Override  // i2.c
    int e(Object[] arr_object, int v) {
        System.arraycopy(this.g, 0, arr_object, v, this.h);
        return v + this.h;
    }

    @Override
    public Object get(int v) {
        h2.c.d(v, this.h);
        return this.g[v];
    }

    @Override  // i2.b
    Object[] n() {
        return this.g;
    }

    @Override  // i2.b
    int o() {
        return this.h;
    }

    @Override  // i2.b
    int p() {
        return 0;
    }

    @Override
    public int size() {
        return this.h;
    }
}

