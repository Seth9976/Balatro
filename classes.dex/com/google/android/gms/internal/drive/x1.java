package com.google.android.gms.internal.drive;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

abstract class x1 extends AbstractMap {
    private final int e;
    private List f;
    private Map g;
    private boolean h;
    private volatile g2 i;
    private Map j;
    private volatile a2 k;

    private x1(int v) {
        this.e = v;
        this.f = Collections.emptyList();
        this.g = Collections.emptyMap();
        this.j = Collections.emptyMap();
    }

    x1(int v, y1 y10) {
        this(v);
    }

    public final boolean a() {
        return this.h;
    }

    private final int b(Comparable comparable0) {
        int v = this.f.size() - 1;
        if(v >= 0) {
            int v1 = comparable0.compareTo(((Comparable)((e2)this.f.get(v)).getKey()));
            if(v1 > 0) {
                return -(v + 2);
            }
            if(v1 == 0) {
                return v;
            }
        }
        int v2 = 0;
        while(v2 <= v) {
            int v3 = (v2 + v) / 2;
            int v4 = comparable0.compareTo(((Comparable)((e2)this.f.get(v3)).getKey()));
            if(v4 < 0) {
                v = v3 - 1;
                continue;
            }
            if(v4 > 0) {
                v2 = v3 + 1;
                continue;
            }
            return v3;
        }
        return -(v2 + 1);
    }

    @Override
    public void clear() {
        this.p();
        if(!this.f.isEmpty()) {
            this.f.clear();
        }
        if(!this.g.isEmpty()) {
            this.g.clear();
        }
    }

    @Override
    public boolean containsKey(Object object0) {
        return this.b(((Comparable)object0)) >= 0 || this.g.containsKey(((Comparable)object0));
    }

    public final Object d(Comparable comparable0, Object object0) {
        this.p();
        int v = this.b(comparable0);
        if(v >= 0) {
            return ((e2)this.f.get(v)).setValue(object0);
        }
        this.p();
        if(this.f.isEmpty() && !(this.f instanceof ArrayList)) {
            this.f = new ArrayList(this.e);
        }
        if(-(v + 1) >= this.e) {
            return this.q().put(comparable0, object0);
        }
        int v1 = this.e;
        if(this.f.size() == v1) {
            e2 e20 = (e2)this.f.remove(v1 - 1);
            this.q().put(((Comparable)e20.getKey()), e20.getValue());
        }
        this.f.add(-(v + 1), new e2(this, comparable0, object0));
        return null;
    }

    @Override
    public Set entrySet() {
        if(this.i == null) {
            this.i = new g2(this, null);
        }
        return this.i;
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof x1)) {
            return super.equals(object0);
        }
        int v = this.size();
        if(v != ((x1)object0).size()) {
            return false;
        }
        int v1 = this.m();
        if(v1 != ((x1)object0).m()) {
            return this.entrySet().equals(((x1)object0).entrySet());
        }
        for(int v2 = 0; v2 < v1; ++v2) {
            if(!this.g(v2).equals(((x1)object0).g(v2))) {
                return false;
            }
        }
        return v1 == v ? true : this.g.equals(((x1)object0).g);
    }

    static x1 f(int v) {
        return new y1(v);
    }

    public final Map.Entry g(int v) {
        return (Map.Entry)this.f.get(v);
    }

    @Override
    public Object get(Object object0) {
        int v = this.b(((Comparable)object0));
        return v < 0 ? this.g.get(((Comparable)object0)) : ((e2)this.f.get(v)).getValue();
    }

    private final Object h(int v) {
        this.p();
        Object object0 = ((e2)this.f.remove(v)).getValue();
        if(!this.g.isEmpty()) {
            Iterator iterator0 = this.q().entrySet().iterator();
            List list0 = this.f;
            Object object1 = iterator0.next();
            list0.add(new e2(this, ((Map.Entry)object1)));
            iterator0.remove();
        }
        return object0;
    }

    @Override
    public int hashCode() {
        int v = this.m();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += ((e2)this.f.get(v1)).hashCode();
        }
        return this.g.size() <= 0 ? v2 : v2 + this.g.hashCode();
    }

    public void j() {
        if(!this.h) {
            this.g = this.g.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.g);
            this.j = this.j.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.j);
            this.h = true;
        }
    }

    public final int m() {
        return this.f.size();
    }

    public final Iterable n() {
        return this.g.isEmpty() ? b2.a() : this.g.entrySet();
    }

    final Set o() {
        if(this.k == null) {
            this.k = new a2(this, null);
        }
        return this.k;
    }

    private final void p() {
        if(this.h) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Object put(Object object0, Object object1) {
        return this.d(((Comparable)object0), object1);
    }

    private final SortedMap q() {
        this.p();
        if(this.g.isEmpty() && !(this.g instanceof TreeMap)) {
            TreeMap treeMap0 = new TreeMap();
            this.g = treeMap0;
            this.j = treeMap0.descendingMap();
        }
        return (SortedMap)this.g;
    }

    @Override
    public Object remove(Object object0) {
        this.p();
        int v = this.b(((Comparable)object0));
        if(v >= 0) {
            return this.h(v);
        }
        return this.g.isEmpty() ? null : this.g.remove(((Comparable)object0));
    }

    @Override
    public int size() {
        return this.f.size() + this.g.size();
    }
}

