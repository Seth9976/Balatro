package com.google.android.gms.internal.play_billing;

import java.util.ListIterator;

final class v3 implements ListIterator {
    final ListIterator e;
    final int f;
    final x3 g;

    v3(x3 x30, int v) {
        this.f = v;
        this.g = x30;
        super();
        this.e = x30.e.listIterator(v);
    }

    @Override
    public final void add(Object object0) {
        String s = (String)object0;
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
        String s = (String)object0;
        throw new UnsupportedOperationException();
    }
}

