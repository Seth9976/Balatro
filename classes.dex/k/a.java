package k;

import java.util.Collection;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;

public class a extends g implements Map {
    f l;

    public a() {
    }

    public a(int v) {
        super(v);
    }

    @Override
    public Set entrySet() {
        return this.m().l();
    }

    @Override
    public Set keySet() {
        return this.m().m();
    }

    private f m() {
        class k.a.a extends f {
            final a d;

            @Override  // k.f
            protected void a() {
                a.this.clear();
            }

            @Override  // k.f
            protected Object b(int v, int v1) {
                return a.this.f[(v << 1) + v1];
            }

            @Override  // k.f
            protected Map c() {
                return a.this;
            }

            @Override  // k.f
            protected int d() {
                return a.this.g;
            }

            @Override  // k.f
            protected int e(Object object0) {
                return a.this.f(object0);
            }

            @Override  // k.f
            protected int f(Object object0) {
                return a.this.h(object0);
            }

            @Override  // k.f
            protected void g(Object object0, Object object1) {
                a.this.put(object0, object1);
            }

            @Override  // k.f
            protected void h(int v) {
                a.this.j(v);
            }

            @Override  // k.f
            protected Object i(int v, Object object0) {
                return a.this.k(v, object0);
            }
        }

        if(this.l == null) {
            this.l = new k.a.a(this);
        }
        return this.l;
    }

    public boolean n(Collection collection0) {
        return f.p(this, collection0);
    }

    @Override
    public void putAll(Map map0) {
        this.c(this.g + map0.size());
        for(Object object0: map0.entrySet()) {
            this.put(((Map.Entry)object0).getKey(), ((Map.Entry)object0).getValue());
        }
    }

    @Override
    public Collection values() {
        return this.m().n();
    }
}

