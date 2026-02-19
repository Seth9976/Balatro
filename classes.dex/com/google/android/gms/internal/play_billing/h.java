package com.google.android.gms.internal.play_billing;

final class h extends d {
    private final j g;

    h(j j0, int v) {
        super(j0.size(), v);
        this.g = j0;
    }

    @Override  // com.google.android.gms.internal.play_billing.d
    protected final Object b(int v) {
        return this.g.get(v);
    }
}

