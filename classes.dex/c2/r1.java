package c2;

import java.util.NoSuchElementException;

abstract class r1 extends d2 {
    private final int e;
    private int f;

    protected r1(int v, int v1) {
        n1.b(v1, v, "index");
        this.e = v;
        this.f = v1;
    }

    protected abstract Object b(int arg1);

    @Override
    public final boolean hasNext() {
        return this.f < this.e;
    }

    @Override
    public final boolean hasPrevious() {
        return this.f > 0;
    }

    @Override
    public final Object next() {
        if(!this.hasNext()) {
            throw new NoSuchElementException();
        }
        int v = this.f;
        this.f = v + 1;
        return this.b(v);
    }

    @Override
    public final int nextIndex() {
        return this.f;
    }

    @Override
    public final Object previous() {
        if(!this.hasPrevious()) {
            throw new NoSuchElementException();
        }
        int v = this.f - 1;
        this.f = v;
        return this.b(v);
    }

    @Override
    public final int previousIndex() {
        return this.f - 1;
    }
}

