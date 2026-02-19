package com.google.android.gms.games.internal.v2.appshortcuts;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import g2.i;

final class n extends o {
    n(p p0, i i0) {
        super(i0);
    }

    @Override  // com.google.android.gms.games.internal.v2.appshortcuts.o
    public final void l(Intent intent0) {
        if(intent0 == null) {
            this.k(new Status(17));
            return;
        }
        this.a.e(intent0);
    }
}

