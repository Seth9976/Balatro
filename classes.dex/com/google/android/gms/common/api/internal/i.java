package com.google.android.gms.common.api.internal;

final class i implements a {
    final c a;

    i(c c0) {
        this.a = c0;
        super();
    }

    @Override  // com.google.android.gms.common.api.internal.a$a
    public final void a(boolean z) {
        this.a.n.sendMessage(this.a.n.obtainMessage(1, Boolean.valueOf(z)));
    }
}

