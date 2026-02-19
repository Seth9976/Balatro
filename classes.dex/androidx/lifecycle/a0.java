package androidx.lifecycle;

import k3.f;
import x.a;

public abstract class a0 {
    public static y a(b z$b0, Class class0) {
        f.e(class0, "modelClass");
        throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
    }

    public static y b(b z$b0, Class class0, a a0) {
        f.e(class0, "modelClass");
        f.e(a0, "extras");
        return z$b0.a(class0);
    }
}

