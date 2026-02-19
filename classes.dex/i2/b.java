package i2;

import h2.c;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;

public abstract class b extends AbstractCollection implements Serializable {
    private static final Object[] e;

    static {
        b.e = new Object[0];
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

    abstract int e(Object[] arg1, int arg2);

    abstract Object[] n();

    abstract int o();

    abstract int p();

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
    public final Object[] toArray() {
        return this.toArray(b.e);
    }

    @Override
    public final Object[] toArray(Object[] arr_object) {
        c.f(arr_object);
        int v = this.size();
        if(arr_object.length < v) {
            Object[] arr_object1 = this.n();
            if(arr_object1 != null) {
                return g.a(arr_object1, this.p(), this.o(), arr_object);
            }
            arr_object = f.d(arr_object, v);
        }
        else if(arr_object.length > v) {
            arr_object[v] = null;
        }
        this.e(arr_object, 0);
        return arr_object;
    }
}

