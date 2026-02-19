package com.google.android.gms.common.api.internal;

import e1.c0;

final class e0 {
    final BasePendingResult a;

    e0(BasePendingResult basePendingResult0, c0 c00) {
        this.a = basePendingResult0;
        super();
    }

    @Override
    protected final void finalize() {
        BasePendingResult.m(this.a.g);
        super.finalize();
    }
}

