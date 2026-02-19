package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

final class w3 implements Iterator {
    final Iterator e;
    final x3 f;

    w3(x3 x30) {
        this.f = x30;
        super();
        this.e = x30.e.iterator();
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

