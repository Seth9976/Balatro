package com.google.android.gms.internal.play_billing;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class j extends g implements List, RandomAccess {
    private static final x f;
    public static final int g;

    static {
        j.f = new h(p.j, 0);
    }

    @Override
    public final void add(int v, Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(int v, Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    public final boolean contains(Object object0) {
        return this.indexOf(object0) >= 0;
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    int e(Object[] arr_object, int v) {
        int v1 = this.size();
        for(int v2 = 0; v2 < v1; ++v2) {
            arr_object[v2] = this.get(v2);
        }
        return v1;
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != this) {
            if(object0 instanceof List) {
                int v = this.size();
                if(v == ((List)object0).size()) {
                    if(((List)object0) instanceof RandomAccess) {
                        for(int v1 = 0; v1 < v; ++v1) {
                            if(!j6.a(this.get(v1), ((List)object0).get(v1))) {
                                return false;
                            }
                        }
                        return true;
                    }
                    else {
                        Iterator iterator0 = this.iterator();
                        Iterator iterator1 = ((List)object0).iterator();
                        while(iterator0.hasNext()) {
                            if(!iterator1.hasNext()) {
                                return false;
                            }
                            Object object1 = iterator0.next();
                            Object object2 = iterator1.next();
                            if(j6.a(object1, object2)) {
                                continue;
                            }
                            return false;
                        }
                        return !iterator1.hasNext();
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public final int hashCode() {
        int v = this.size();
        int v2 = 1;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 = v2 * 0x1F + this.get(v1).hashCode();
        }
        return v2;
    }

    @Override
    public final int indexOf(Object object0) {
        if(object0 == null) {
            return -1;
        }
        int v = this.size();
        for(int v1 = 0; v1 < v; ++v1) {
            if(object0.equals(this.get(v1))) {
                return v1;
            }
        }
        return -1;
    }

    @Override
    public final Iterator iterator() {
        return this.w(0);
    }

    @Override
    public final int lastIndexOf(Object object0) {
        if(object0 == null) {
            return -1;
        }
        for(int v = this.size() - 1; v >= 0; --v) {
            if(object0.equals(this.get(v))) {
                return v;
            }
        }
        return -1;
    }

    @Override
    public final ListIterator listIterator() {
        return this.w(0);
    }

    @Override
    public final ListIterator listIterator(int v) {
        return this.w(v);
    }

    @Override  // com.google.android.gms.internal.play_billing.g
    public final j p() {
        return this;
    }

    @Override
    public final Object remove(int v) {
        throw new UnsupportedOperationException();
    }

    public j s(int v, int v1) {
        b.d(v, v1, this.size());
        int v2 = v1 - v;
        if(v2 == this.size()) {
            return this;
        }
        return v2 == 0 ? p.j : new i(this, v, v2);
    }

    @Override
    public final Object set(int v, Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int v, int v1) {
        return this.s(v, v1);
    }

    static j t(Object[] arr_object, int v) {
        return v == 0 ? p.j : new p(arr_object, v);
    }

    public static j u(Collection collection0) {
        if(collection0 instanceof g) {
            j j0 = ((g)collection0).p();
            if(j0.q()) {
                Object[] arr_object = j0.toArray();
                return j.t(arr_object, arr_object.length);
            }
            return j0;
        }
        Object[] arr_object1 = collection0.toArray();
        for(int v = 0; v < arr_object1.length; ++v) {
            if(arr_object1[v] == null) {
                throw new NullPointerException("at index " + v);
            }
        }
        return j.t(arr_object1, arr_object1.length);
    }

    public static j v() {
        return p.j;
    }

    public final x w(int v) {
        b.b(v, this.size(), "index");
        return this.isEmpty() ? j.f : new h(this, v);
    }
}

