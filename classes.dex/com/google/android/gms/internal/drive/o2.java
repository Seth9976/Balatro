package com.google.android.gms.internal.drive;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class o2 extends AbstractList implements t0, RandomAccess {
    private final t0 e;

    public o2(t0 t00) {
        this.e = t00;
    }

    @Override  // com.google.android.gms.internal.drive.t0
    public final Object a(int v) {
        return this.e.a(v);
    }

    @Override
    public final Object get(int v) {
        return (String)this.e.get(v);
    }

    @Override  // com.google.android.gms.internal.drive.t0
    public final t0 i() {
        return this;
    }

    @Override
    public final Iterator iterator() {
        return new q2(this);
    }

    @Override  // com.google.android.gms.internal.drive.t0
    public final List k() {
        return this.e.k();
    }

    @Override
    public final ListIterator listIterator(int v) {
        return new p2(this, v);
    }

    @Override
    public final int size() {
        return this.e.size();
    }
}

