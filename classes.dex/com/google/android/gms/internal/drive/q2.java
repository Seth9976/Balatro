package com.google.android.gms.internal.drive;

import java.util.Iterator;

final class q2 implements Iterator {
    private Iterator e;
    private final o2 f;

    q2(o2 o20) {
        this.f = o20;
        super();
        this.e = o20.e.iterator();
    }

    @Override
    public final boolean hasNext() {
        return this.e.hasNext();
    }

    @Override
    public final Object next() {
        return this.e.next();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

