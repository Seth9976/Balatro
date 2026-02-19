package q1;

import com.google.android.gms.common.data.DataHolder;
import g2.i;
import p1.h;
import v1.f;

final class b0 extends a {
    private final i a;

    b0(i i0) {
        this.a = i0;
    }

    @Override  // q1.a
    public final void A(DataHolder dataHolder0) {
        v1.i i0;
        int v = dataHolder0.n0();
        if(v != 0) {
            h.a(this.a, v);
            dataHolder0.close();
            return;
        }
        try(f f0 = new f(dataHolder0)) {
            i0 = f0.getCount() > 0 ? new v1.i(f0.n(0)) : null;
        }
        this.a.c(i0);
    }
}

