package g1;

import d1.g;
import d1.k;
import g2.h;
import g2.i;

public abstract class p {
    public interface a {
        Object a(k arg1);
    }

    private static final l0 a;

    static {
        p.a = new i0();
    }

    public static h a(g g0, a p$a0) {
        i i0 = new i();
        g0.c(new j0(g0, i0, p$a0, p.a));
        return i0.a();
    }

    public static h b(g g0) {
        return p.a(g0, new k0());
    }
}

