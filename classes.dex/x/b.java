package x;

import androidx.lifecycle.a0;
import androidx.lifecycle.y;

public final class b implements androidx.lifecycle.z.b {
    private final f[] a;

    public b(f[] arr_f) {
        k3.f.e(arr_f, "initializers");
        super();
        this.a = arr_f;
    }

    @Override  // androidx.lifecycle.z$b
    public y a(Class class0) {
        return a0.a(this, class0);
    }

    @Override  // androidx.lifecycle.z$b
    public y b(Class class0, a a0) {
        k3.f.e(class0, "modelClass");
        k3.f.e(a0, "extras");
        f[] arr_f = this.a;
        y y0 = null;
        for(int v = 0; v < arr_f.length; ++v) {
            f f0 = arr_f[v];
            if(k3.f.a(f0.a(), class0)) {
                Object object0 = f0.b().c(a0);
                y0 = object0 instanceof y ? ((y)object0) : null;
            }
        }
        if(y0 == null) {
            throw new IllegalArgumentException("No initializer set for given class " + class0.getName());
        }
        return y0;
    }
}

