package c2;

import android.app.Application;
import java.util.Objects;

public final class h {
    private final m a;

    private h(m m0) {
        this.a = m0;
    }

    public static h a(Application application0) {
        return new h(o.a(application0));
    }

    public final g2.h b(g g0) {
        Objects.requireNonNull(g0);
        f f0 = new f(g0);
        return this.a.d(f0);
    }
}

