package g1;

import android.content.Context;
import android.util.SparseIntArray;
import c1.j;
import d1.a.f;

public final class g0 {
    private final SparseIntArray a;
    private j b;

    public g0(j j0) {
        this.a = new SparseIntArray();
        q.i(j0);
        this.b = j0;
    }

    public final int a(Context context0, int v) {
        return this.a.get(v, -1);
    }

    public final int b(Context context0, f a$f0) {
        q.i(context0);
        q.i(a$f0);
        int v = 0;
        if(!a$f0.m()) {
            return 0;
        }
        int v1 = a$f0.o();
        int v2 = this.a(context0, v1);
        if(v2 == -1) {
            for(int v3 = 0; true; ++v3) {
                if(v3 >= this.a.size()) {
                    v = -1;
                    break;
                }
                int v4 = this.a.keyAt(v3);
                if(v4 > v1 && this.a.get(v4) == 0) {
                    break;
                }
            }
            v2 = v == -1 ? this.b.g(context0, v1) : v;
            this.a.put(v1, v2);
        }
        return v2;
    }

    public final void c() {
        this.a.clear();
    }
}

