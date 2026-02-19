package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map.Entry;

final class r0 implements Iterator {
    private Iterator e;

    public r0(Iterator iterator0) {
        this.e = iterator0;
    }

    @Override
    public final boolean hasNext() {
        return this.e.hasNext();
    }

    @Override
    public final Object next() {
        Object object0 = this.e.next();
        ((Map.Entry)object0).getValue();
        return (Map.Entry)object0;
    }

    @Override
    public final void remove() {
        this.e.remove();
    }
}

