package com.google.android.gms.common.api.internal;

final class l implements Runnable {
    final m e;

    l(m m0) {
        this.e = m0;
        super();
    }

    @Override
    public final void run() {
        this.e.a.b.j(this.e.a.b.getClass().getName() + " disconnecting because it was signed out.");
    }
}

