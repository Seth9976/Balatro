package i2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class c extends b implements List, RandomAccess {
    static class a extends i2.a {
        private final c g;

        a(c c0, int v) {
            super(c0.size(), v);
            this.g = c0;
        }

        @Override  // i2.a
        protected Object b(int v) {
            return this.g.get(v);
        }
    }

    class i2.c.b extends c {
        final transient int g;
        final transient int h;
        final c i;

        i2.c.b(int v, int v1) {
            this.g = v;
            this.h = v1;
        }

        @Override
        public Object get(int v) {
            h2.c.d(v, this.h);
            return c.this.get(v + this.g);
        }

        @Override  // i2.c
        public Iterator iterator() {
            return super.t();
        }

        @Override  // i2.c
        public ListIterator listIterator() {
            return super.u();
        }

        @Override  // i2.c
        public ListIterator listIterator(int v) {
            return super.v(v);
        }

        @Override  // i2.b
        Object[] n() {
            return c.this.n();
        }

        @Override  // i2.b
        int o() {
            return c.this.p() + this.g + this.h;
        }

        @Override  // i2.b
        int p() {
            return c.this.p() + this.g;
        }

        @Override
        public int size() {
            return this.h;
        }

        @Override  // i2.c
        public List subList(int v, int v1) {
            return this.y(v, v1);
        }

        @Override  // i2.c
        public c y(int v, int v1) {
            h2.c.i(v, v1, this.h);
            return c.this.y(v + this.g, v1 + this.g);
        }
    }

    private static final j f;

    static {
        c.f = new a(h.i, 0);
    }

    @Override
    public final void add(int v, Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object object0) {
        return this.indexOf(object0) >= 0;
    }

    @Override  // i2.b
    int e(Object[] arr_object, int v) {
        int v1 = this.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            arr_object[v + v2] = this.get(v2);
        }
        return v + v1;
    }

    @Override
    public boolean equals(Object object0) {
        return e.a(this, object0);
    }

    @Override
    public int hashCode() {
        int v = this.size();
        int v1 = 1;
        for(int v2 = 0; v2 < v; ++v2) {
            v1 = v1 * 0x1F + this.get(v2).hashCode();
        }
        return v1;
    }

    @Override
    public int indexOf(Object object0) {
        return object0 == null ? -1 : e.b(this, object0);
    }

    @Override
    public Iterator iterator() {
        return this.t();
    }

    @Override
    public int lastIndexOf(Object object0) {
        return object0 == null ? -1 : e.d(this, object0);
    }

    @Override
    public ListIterator listIterator() {
        return this.u();
    }

    @Override
    public ListIterator listIterator(int v) {
        return this.v(v);
    }

    static c q(Object[] arr_object) {
        return c.r(arr_object, arr_object.length);
    }

    static c r(Object[] arr_object, int v) {
        return v == 0 ? c.w() : new h(arr_object, v);
    }

    @Override
    public final Object remove(int v) {
        throw new UnsupportedOperationException();
    }

    private static c s(Object[] arr_object) {
        return c.q(f.b(arr_object));
    }

    @Override
    public final Object set(int v, Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int v, int v1) {
        return this.y(v, v1);
    }

    public i t() {
        return this.u();
    }

    public j u() {
        return this.v(0);
    }

    public j v(int v) {
        h2.c.g(v, this.size());
        return this.isEmpty() ? c.f : new a(this, v);
    }

    public static c w() {
        return h.i;
    }

    public static c x(Object object0) {
        return c.s(new Object[]{object0});
    }

    public c y(int v, int v1) {
        h2.c.i(v, v1, this.size());
        int v2 = v1 - v;
        if(v2 == this.size()) {
            return this;
        }
        return v2 == 0 ? c.w() : this.z(v, v1);
    }

    c z(int v, int v1) {
        return new i2.c.b(this, v, v1 - v);
    }
}

