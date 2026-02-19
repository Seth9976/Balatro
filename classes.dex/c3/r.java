package c3;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class r implements ListIterator {
    public static final r e;

    static {
        r.e = new r();
    }

    @Override
    public void add(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public Void b() {
        throw new NoSuchElementException();
    }

    public Void d() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Object next() {
        return this.b();
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public Object previous() {
        return this.d();
    }

    @Override
    public int previousIndex() {
        return -1;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void set(Object object0) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

