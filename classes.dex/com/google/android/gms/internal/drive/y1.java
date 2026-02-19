package com.google.android.gms.internal.drive;

import h.d;
import java.util.Iterator;
import java.util.Map.Entry;

final class y1 extends x1 {
    y1(int v) {
        super(v, null);
    }

    @Override  // com.google.android.gms.internal.drive.x1
    public final void j() {
        if(!this.a()) {
            if(this.m() > 0) {
                d.a(this.g(0).getKey());
                throw null;
            }
            Iterator iterator0 = this.n().iterator();
            if(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                d.a(((Map.Entry)object0).getKey());
                throw null;
            }
        }
        super.j();
    }
}

