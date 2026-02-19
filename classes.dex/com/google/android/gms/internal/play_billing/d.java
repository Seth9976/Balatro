package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;

abstract class d extends x {
    private final int e;
    private int f;

    protected d(int v, int v1) {
        b.b(v1, v, "index");
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

