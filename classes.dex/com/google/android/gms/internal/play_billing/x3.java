package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class x3 extends AbstractList implements b2, RandomAccess {
    private final b2 e;

    public x3(b2 b20) {
        this.e = b20;
    }

    @Override  // com.google.android.gms.internal.play_billing.b2
    public final b2 f() {
        return this;
    }

    @Override  // com.google.android.gms.internal.play_billing.b2
    public final List g() {
        return this.e.g();
    }

    @Override
    public final Object get(int v) {
        return ((a2)this.e).n(v);
    }

    @Override
    public final Iterator iterator() {
        return new w3(this);
    }

    @Override
    public final ListIterator listIterator(int v) {
        return new v3(this, v);
    }

    @Override  // com.google.android.gms.internal.play_billing.b2
    public final Object m(int v) {
        return this.e.m(v);
    }

    @Override
    public final int size() {
        return this.e.size();
    }
}

