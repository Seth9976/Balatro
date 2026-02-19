package androidx.lifecycle;

import k3.f;
import x.a;

public abstract class b0 {
    public static final a a(d0 d00) {
        f.e(d00, "owner");
        if(d00 instanceof g) {
            a a0 = ((g)d00).a();
            f.d(a0, "{\n        owner.defaultV…ModelCreationExtras\n    }");
            return a0;
        }
        return x.a.a.b;
    }
}

