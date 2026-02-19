package c3;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import k3.c;
import k3.f;

public final class u implements Serializable, Set {
    public static final u e;

    static {
        u.e = new u();
    }

    @Override
    public boolean add(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final boolean contains(Object object0) {
        return object0 instanceof Void ? this.e(((Void)object0)) : false;
    }

    @Override
    public boolean containsAll(Collection collection0) {
        f.e(collection0, "elements");
        return collection0.isEmpty();
    }

    public boolean e(Void void0) {
        f.e(void0, "element");
        return false;
    }

    // 去混淆评级： 低(20)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof Set && ((Set)object0).isEmpty();
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Iterator iterator() {
        return r.e;
    }

    public int n() [...] // Inlined contents

    @Override
    public boolean remove(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection collection0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return 0;
    }

    @Override
    public Object[] toArray() {
        return c.a(this);
    }

    @Override
    public Object[] toArray(Object[] arr_object) {
        f.e(arr_object, "array");
        return c.b(this, arr_object);
    }

    @Override
    public String toString() {
        return "[]";
    }
}

