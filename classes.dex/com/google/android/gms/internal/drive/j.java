package com.google.android.gms.internal.drive;

import java.util.NoSuchElementException;

final class j extends l {
    private int e;
    private final int f;
    private final i g;

    j(i i0) {
        this.g = i0;
        super();
        this.e = 0;
        this.f = i0.size();
    }

    @Override  // com.google.android.gms.internal.drive.p
    public final byte c() {
        int v = this.e;
        if(v >= this.f) {
            throw new NoSuchElementException();
        }
        this.e = v + 1;
        return this.g.y(v);
    }

    @Override
    public final boolean hasNext() {
        return this.e < this.f;
    }
}

