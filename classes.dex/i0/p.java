package i0;

import android.util.SparseArray;

public enum p {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);

    private final int e;
    private static final SparseArray l;

    static {
        SparseArray sparseArray0 = new SparseArray();
        p.l = sparseArray0;
        sparseArray0.put(0, p.f);
        sparseArray0.put(1, p.g);
        sparseArray0.put(2, p.h);
        sparseArray0.put(3, p.i);
        sparseArray0.put(4, p.j);
        sparseArray0.put(-1, p.k);
    }

    private p(int v1) {
        this.e = v1;
    }
}

