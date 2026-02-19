package com.google.android.gms.internal.play_billing;

import h.d;
import java.util.Iterator;
import java.util.Map.Entry;

final class f3 extends p3 {
    f3(int v) {
        super(v, null);
    }

    @Override  // com.google.android.gms.internal.play_billing.p3
    public final void a() {
        if(!this.j()) {
            if(this.b() > 0) {
                d.a(this.g(0).getKey());
                throw null;
            }
            Iterator iterator0 = this.c().iterator();
            if(iterator0.hasNext()) {
                Object object0 = iterator0.next();
                d.a(((Map.Entry)object0).getKey());
                throw null;
            }
        }
        super.a();
    }
}

