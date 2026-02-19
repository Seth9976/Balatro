package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map.Entry;

final class l3 implements Iterator {
    private int e;
    private boolean f;
    private Iterator g;
    final p3 h;

    l3(p3 p30, k3 k30) {
        this.h = p30;
        super();
        this.e = -1;
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
        this.h.n();
        if(this.e < this.h.f.size()) {
            int v = this.e;
            this.e = v - 1;
            this.h.l(v);
            return;
        }
        this.b().remove();
    }
}

