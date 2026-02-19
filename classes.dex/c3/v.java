package c3;

import java.util.Iterator;

public abstract class v implements Iterator {
    public abstract int b();

    @Override
    public Object next() {
        return this.b();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

