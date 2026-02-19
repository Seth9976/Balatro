package d1;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import e1.m;
import g1.q;

public abstract class h {
    public static g a(k k0, f f0) {
        q.j(k0, "Result must not be null");
        q.b(!k0.g0().o0(), "Status code must not be SUCCESS");
        g g0 = new o(f0, k0);
        ((BasePendingResult)g0).h(k0);
        return g0;
    }

    public static g b(Status status0, f f0) {
        q.j(status0, "Result must not be null");
        g g0 = new m(f0);
        ((BasePendingResult)g0).h(status0);
        return g0;
    }
}

