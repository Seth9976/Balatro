package com.google.android.gms.internal.play_billing;

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

abstract class p3 extends AbstractMap {
    private final int e;
    private List f;
    private Map g;
    private boolean h;
    private volatile n3 i;
    private Map j;

    p3(int v, o3 o30) {
        this.e = v;
        this.f = Collections.emptyList();
        this.g = Collections.emptyMap();
        this.j = Collections.emptyMap();
    }

    public void a() {
        if(!this.h) {
            this.g = this.g.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.g);
            this.j = this.j.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.j);
            this.h = true;
        }
    }

    public final int b() {
        return this.f.size();
    }

    public final Iterable c() {
        return this.g.isEmpty() ? i3.a() : this.g.entrySet();
    }

    @Override
    public final void clear() {
        this.n();
        if(!this.f.isEmpty()) {
            this.f.clear();
        }
        if(!this.g.isEmpty()) {
            this.g.clear();
        }
    }

    @Override
    public final boolean containsKey(Object object0) {
        return this.k(((Comparable)object0)) >= 0 || this.g.containsKey(((Comparable)object0));
    }

    public final Object e(Comparable comparable0, Object object0) {
        this.n();
        int v = this.k(comparable0);
        if(v >= 0) {
            return ((j3)this.f.get(v)).setValue(object0);
        }
        this.n();
        if(this.f.isEmpty() && !(this.f instanceof ArrayList)) {
            this.f = new ArrayList(this.e);
        }
        if(-(v + 1) >= this.e) {
            return this.m().put(comparable0, object0);
        }
        int v1 = this.e;
        if(this.f.size() == v1) {
            j3 j30 = (j3)this.f.remove(v1 - 1);
            this.m().put(j30.c(), j30.getValue());
        }
        this.f.add(-(v + 1), new j3(this, comparable0, object0));
        return null;
    }

    @Override
    public final Set entrySet() {
        if(this.i == null) {
            this.i = new n3(this, null);
        }
        return this.i;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof p3)) {
            return super.equals(object0);
        }
        int v = this.size();
        if(v != ((p3)object0).size()) {
            return false;
        }
        int v1 = this.b();
        if(v1 == ((p3)object0).b()) {
            for(int v2 = 0; v2 < v1; ++v2) {
                if(!this.g(v2).equals(((p3)object0).g(v2))) {
                    return false;
                }
            }
            return v1 == v ? true : this.g.equals(((p3)object0).g);
        }
        return this.entrySet().equals(((p3)object0).entrySet());
    }

    public final Map.Entry g(int v) {
        return (Map.Entry)this.f.get(v);
    }

    @Override
    public final Object get(Object object0) {
        int v = this.k(((Comparable)object0));
        return v < 0 ? this.g.get(((Comparable)object0)) : ((j3)this.f.get(v)).getValue();
    }

    @Override
    public final int hashCode() {
        int v = this.b();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += ((j3)this.f.get(v1)).hashCode();
        }
        return this.g.size() <= 0 ? v2 : v2 + this.g.hashCode();
    }

    public final boolean j() {
        return this.h;
    }

    private final int k(Comparable comparable0) {
        int v = this.f.size() - 1;
        int v1 = 0;
        if(v >= 0) {
            int v2 = comparable0.compareTo(((j3)this.f.get(v)).c());
            if(v2 > 0) {
                return -(v + 2);
            }
            if(v2 == 0) {
                return v;
            }
        }
        while(v1 <= v) {
            int v3 = (v1 + v) / 2;
            int v4 = comparable0.compareTo(((j3)this.f.get(v3)).c());
            if(v4 < 0) {
                v = v3 - 1;
                continue;
            }
            if(v4 > 0) {
                v1 = v3 + 1;
                continue;
            }
            return v3;
        }
        return -(v1 + 1);
    }

    private final Object l(int v) {
        this.n();
        Object object0 = ((j3)this.f.remove(v)).getValue();
        if(!this.g.isEmpty()) {
            Iterator iterator0 = this.m().entrySet().iterator();
            List list0 = this.f;
            Object object1 = iterator0.next();
            list0.add(new j3(this, ((Comparable)((Map.Entry)object1).getKey()), ((Map.Entry)object1).getValue()));
            iterator0.remove();
        }
        return object0;
    }

    private final SortedMap m() {
        this.n();
        if(this.g.isEmpty() && !(this.g instanceof TreeMap)) {
            TreeMap treeMap0 = new TreeMap();
            this.g = treeMap0;
            this.j = treeMap0.descendingMap();
        }
        return (SortedMap)this.g;
    }

    private final void n() {
        if(this.h) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public final Object put(Object object0, Object object1) {
        return this.e(((Comparable)object0), object1);
    }

    @Override
    public final Object remove(Object object0) {
        this.n();
        int v = this.k(((Comparable)object0));
        if(v >= 0) {
            return this.l(v);
        }
        return this.g.isEmpty() ? null : this.g.remove(((Comparable)object0));
    }

    @Override
    public final int size() {
        return this.f.size() + this.g.size();
    }
}

