package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import d1.g.a;

final class e implements a {
    final BasePendingResult a;
    final g b;

    e(g g0, BasePendingResult basePendingResult0) {
        this.b = g0;
        this.a = basePendingResult0;
        super();
    }

    @Override  // d1.g$a
    public final void a(Status status0) {
        this.b.a.remove(this.a);
    }
}

