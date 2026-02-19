package c3;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import k3.c;
import k3.f;

public final class s implements Serializable, List, RandomAccess {
    public static final s e;

    static {
        s.e = new s();
    }

    @Override
    public void add(int v, Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean add(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(int v, Collection collection0) {
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
        return object0 instanceof List && ((List)object0).isEmpty();
    }

    @Override
    public Object get(int v) {
        return this.n(v);
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public final int indexOf(Object object0) {
        return object0 instanceof Void ? this.p(((Void)object0)) : -1;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Iterator iterator() {
        return r.e;
    }

    @Override
    public final int lastIndexOf(Object object0) {
        return object0 instanceof Void ? this.q(((Void)object0)) : -1;
    }

    @Override
    public ListIterator listIterator() {
        return r.e;
    }

    @Override
    public ListIterator listIterator(int v) {
        if(v != 0) {
            throw new IndexOutOfBoundsException("Index: " + v);
        }
        return r.e;
    }

    public Void n(int v) {
        throw new IndexOutOfBoundsException("Empty list doesn\'t contain element at index " + v + '.');
    }

    public int o() [...] // Inlined contents

    public int p(Void void0) {
        f.e(void0, "element");
        return -1;
    }

    public int q(Void void0) {
        f.e(void0, "element");
        return -1;
    }

    @Override
    public Object remove(int v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

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
    public Object set(int v, Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final int size() {
        return 0;
    }

    @Override
    public List subList(int v, int v1) {
        if(v != 0 || v1 != 0) {
            throw new IndexOutOfBoundsException("fromIndex: " + v + ", toIndex: " + v1);
        }
        return this;
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

