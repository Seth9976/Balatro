package c2;

import com.google.android.gms.common.api.Status;
import d1.b;
import g2.i;

final class n2 extends s0 {
    final i a;

    n2(o2 o20, i i0) {
        this.a = i0;
        super();
    }

    @Override  // c2.v2
    public final void n(Status status0, s2 s20) {
        if(s20 == null) {
            b b0 = new b(status0);
            this.a.b(b0);
            return;
        }
        this.a.c(s20);
    }
}

