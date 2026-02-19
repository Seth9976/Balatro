package f1;

import g1.q;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class c implements Iterator {
    protected final b e;
    protected int f;

    public c(b b0) {
        this.e = (b)q.i(b0);
        this.f = -1;
    }

    @Override
    public final boolean hasNext() {
        return this.f < this.e.getCount() - 1;
    }

    @Override
    public Object next() {
        if(!this.hasNext()) {
            throw new NoSuchElementException("Cannot advance the iterator beyond " + this.f);
        }
        int v = this.f + 1;
        this.f = v;
        return this.e.get(v);
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}

