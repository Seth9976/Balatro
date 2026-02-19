package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import e1.s;

final class a0 extends s {
    final Dialog a;
    final b0 b;

    a0(b0 b00, Dialog dialog0) {
        this.b = b00;
        this.a = dialog0;
        super();
    }

    @Override  // e1.s
    public final void a() {
        this.b.f.o();
        if(this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}

