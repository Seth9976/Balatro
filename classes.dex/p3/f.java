package p3;

import java.util.Iterator;

abstract class f extends e {
    public static b a(Iterator iterator0) {
        public static final class a implements b {
            final Iterator a;

            public a(Iterator iterator0) {
                this.a = iterator0;
                super();
            }

            @Override  // p3.b
            public Iterator iterator() {
                return this.a;
            }
        }

        k3.f.e(iterator0, "<this>");
        return f.b(new a(iterator0));
    }

    public static final b b(b b0) {
        k3.f.e(b0, "<this>");
        return !(b0 instanceof p3.a) ? new p3.a(b0) : b0;
    }
}

