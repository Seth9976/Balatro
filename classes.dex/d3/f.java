package d3;

import j3.p;
import java.io.Serializable;

public final class f implements e, Serializable {
    public static final f e;

    static {
        f.e = new f();
    }

    @Override  // d3.e
    public Object fold(Object object0, p p0) {
        k3.f.e(p0, "operation");
        return object0;
    }

    @Override  // d3.e
    public b get(c e$c0) {
        k3.f.e(e$c0, "key");
        return null;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override  // d3.e
    public e minusKey(c e$c0) {
        k3.f.e(e$c0, "key");
        return this;
    }

    @Override
    public String toString() {
        return "EmptyCoroutineContext";
    }
}

