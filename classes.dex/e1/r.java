package e1;

import android.os.Looper;
import com.google.android.gms.common.api.internal.b;
import d1.e;

public final class r extends o {
    private final e c;

    public r(e e0) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.c = e0;
    }

    @Override  // d1.f
    public final b a(b b0) {
        return this.c.h(b0);
    }

    @Override  // d1.f
    public final Looper c() {
        return this.c.o();
    }
}

