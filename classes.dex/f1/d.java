package f1;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import g1.q;

public abstract class d {
    protected final DataHolder e;
    protected int f;
    private int g;

    public d(DataHolder dataHolder0, int v) {
        this.e = (DataHolder)q.i(dataHolder0);
        this.b0(v);
    }

    protected String C(String s) {
        return this.e.o0(s, this.f, this.g);
    }

    public boolean H(String s) {
        return this.e.q0(s);
    }

    protected boolean K(String s) {
        return this.e.r0(s, this.f, this.g);
    }

    protected Uri U(String s) {
        String s1 = this.e.o0(s, this.f, this.g);
        return s1 == null ? null : Uri.parse(s1);
    }

    protected final void b0(int v) {
        q.k(v >= 0 && v < this.e.getCount());
        this.f = v;
        this.g = this.e.p0(v);
    }

    protected boolean o(String s) {
        return this.e.j0(s, this.f, this.g);
    }

    protected float s(String s) {
        return this.e.s0(s, this.f, this.g);
    }

    protected int x(String s) {
        return this.e.k0(s, this.f, this.g);
    }

    protected long z(String s) {
        return this.e.l0(s, this.f, this.g);
    }
}

