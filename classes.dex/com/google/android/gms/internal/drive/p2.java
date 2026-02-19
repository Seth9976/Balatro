package com.google.android.gms.internal.drive;

import java.util.ListIterator;

final class p2 implements ListIterator {
    private ListIterator e;
    private final int f;
    private final o2 g;

    p2(o2 o20, int v) {
        this.g = o20;
        this.f = v;
        super();
        this.e = o20.e.listIterator(v);
    }

    @Override
    public final void add(Object object0) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean hasNext() {
        return this.e.hasNext();
    }

    @Override
    public final boolean hasPrevious() {
        return this.e.hasPrevious();
    }

    @Override
    public final Object next() {
        return (String)this.e.next();
    }

    @Override
    public final int nextIndex() {
        return this.e.nextIndex();
    }

    @Override
    public final Object previous() {
        return (String)this.e.previous();
    }

    @Override
    public final int previousIndex() {
        return this.e.previousIndex();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void set(Object object0) {
        throw new UnsupportedOperationException();
    }
}

