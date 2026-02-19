package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;

public abstract class g extends AbstractCollection implements Serializable {
    private static final Object[] e;

    static {
        g.e = new Object[0];
    }

    @Override
    public final boolean add(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean addAll(Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public abstract boolean contains(Object arg1);

    abstract int e(Object[] arg1, int arg2);

    int n() {
        throw new UnsupportedOperationException();
    }

    int o() {
        throw new UnsupportedOperationException();
    }

    public abstract j p();

    abstract boolean q();

    Object[] r() {
        return null;
    }

    @Override
    public final boolean remove(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean removeAll(Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean retainAll(Collection collection0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Spliterator spliterator() {
        return Spliterators.spliterator(this, 0x510);
    }

    @Override
    public final Object[] toArray() {
        return this.toArray(g.e);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        arr_object.getClass();
        int v = this.size();
        if(arr_object.length < v) {
            Object[] arr_object1 = this.r();
            if(arr_object1 == null) {
                if(arr_object.length != 0) {
                    arr_object = Arrays.copyOf(arr_object, 0);
                }
                arr_object = Arrays.copyOf(arr_object, v);
                this.e(arr_object, 0);
                return arr_object;
            }
            return Arrays.copyOfRange(arr_object1, this.o(), this.n(), arr_object.getClass());
        }
        else if(arr_object.length > v) {
            arr_object[v] = null;
        }
        this.e(arr_object, 0);
        return arr_object;
    }
}

