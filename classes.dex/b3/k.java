package b3;

import j3.a;
import java.io.Serializable;
import k3.f;

final class k implements d, Serializable {
    private a e;
    private volatile Object f;
    private final Object g;

    public k(a a0, Object object0) {
        f.e(a0, "initializer");
        super();
        this.e = a0;
        this.f = m.a;
        if(object0 == null) {
            object0 = this;
        }
        this.g = object0;
    }

    public k(a a0, Object object0, int v, k3.d d0) {
        if((v & 2) != 0) {
            object0 = null;
        }
        this(a0, object0);
    }

    public boolean a() {
        return this.f != m.a;
    }

    @Override  // b3.d
    public Object getValue() {
        Object object0 = this.f;
        m m0 = m.a;
        if(object0 != m0) {
            return object0;
        }
        synchronized(this.g) {
            Object object2 = this.f;
            if(object2 == m0) {
                a a0 = this.e;
                f.b(a0);
                object2 = a0.a();
                this.f = object2;
                this.e = null;
            }
            return object2;
        }
    }

    // 去混淆评级： 低(20)
    @Override
    public String toString() {
        return this.a() ? String.valueOf(this.getValue()) : "Lazy value not initialized yet.";
    }
}

