package com.google.android.gms.internal.drive;

import java.util.Iterator;

final class a2 extends g2 {
    private final x1 f;

    private a2(x1 x10) {
        this.f = x10;
        super(x10, null);
    }

    a2(x1 x10, y1 y10) {
        this(x10);
    }

    @Override  // com.google.android.gms.internal.drive.g2
    public final Iterator iterator() {
        return new z1(this.f, null);
    }
}

