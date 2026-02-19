package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map.Entry;

final class z1 implements Iterator {
    private int e;
    private Iterator f;
    private final x1 g;

    private z1(x1 x10) {
        this.g = x10;
        super();
        this.e = x10.f.size();
    }

    z1(x1 x10, y1 y10) {
        this(x10);
    }

    private final Iterator b() {
        if(this.f == null) {
            this.f = this.g.j.entrySet().iterator();
        }
        return this.f;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean hasNext() {
        return this.e > 0 && this.e <= this.g.f.size() || this.b().hasNext();
    }

    @Override
    public final Object next() {
        if(this.b().hasNext()) {
            return this.b().next();
        }
        int v = this.e - 1;
        this.e = v;
        return (Map.Entry)this.g.f.get(v);
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

