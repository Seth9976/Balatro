package x;

import androidx.lifecycle.z.b;
import j3.l;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import k3.f;
import o3.a;

public final class c {
    private final List a;

    public c() {
        this.a = new ArrayList();
    }

    public final void a(a a0, l l0) {
        f.e(a0, "clazz");
        f.e(l0, "initializer");
        x.f f0 = new x.f(i3.a.a(a0), l0);
        this.a.add(f0);
    }

    public final b b() {
        Object[] arr_object = this.a.toArray(new x.f[0]);
        if(arr_object == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        return new x.b(((x.f[])Arrays.copyOf(((x.f[])arr_object), ((x.f[])arr_object).length)));
    }
}

