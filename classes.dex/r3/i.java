package r3;

import t3.m;

public abstract class i {
    private static final boolean a;
    private static final j b;

    static {
        i.a = m.e("kotlinx.coroutines.main.delay", false);
        i.b = i.b();
    }

    public static final j a() {
        return i.b;
    }

    private static final j b() {
        if(!i.a) {
            return h.j;
        }
        v v0 = l.b();
        return !t3.i.c(v0) && v0 instanceof j ? ((j)v0) : h.j;
    }
}

