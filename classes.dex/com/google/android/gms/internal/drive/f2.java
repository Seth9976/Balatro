package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map.Entry;

final class f2 implements Iterator {
    private int e;
    private boolean f;
    private Iterator g;
    private final x1 h;

    private f2(x1 x10) {
        this.h = x10;
        super();
        this.e = -1;
    }

    f2(x1 x10, y1 y10) {
        this(x10);
    }

    private final Iterator b() {
        if(this.g == null) {
            this.g = this.h.g.entrySet().iterator();
        }
        return this.g;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean hasNext() {
        return this.e + 1 < this.h.f.size() || !this.h.g.isEmpty() && this.b().hasNext();
    }

    @Override
    public final Object next() {
        this.f = true;
        int v = this.e + 1;
        this.e = v;
        return v < this.h.f.size() ? ((Map.Entry)this.h.f.get(this.e)) : this.b().next();
    }

    @Override
    public final void remove() {
        if(!this.f) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f = false;
        this.h.p();
        if(this.e < this.h.f.size()) {
            int v = this.e;
            this.e = v - 1;
            this.h.h(v);
            return;
        }
        this.b().remove();
    }
}

