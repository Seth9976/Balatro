package androidx.lifecycle;

import k3.d;
import k3.f;
import x.a.b;

public class z {
    public static abstract class a extends c {
        public static final class androidx.lifecycle.z.a.a {
            static final class androidx.lifecycle.z.a.a.a implements b {
                public static final androidx.lifecycle.z.a.a.a a;

                static {
                    androidx.lifecycle.z.a.a.a.a = new androidx.lifecycle.z.a.a.a();
                }
            }

            private androidx.lifecycle.z.a.a() {
            }

            public androidx.lifecycle.z.a.a(d d0) {
            }
        }

        public static final androidx.lifecycle.z.a.a c;
        public static final b d;

        static {
            a.c = new androidx.lifecycle.z.a.a(null);
            a.d = androidx.lifecycle.z.a.a.a.a;
        }
    }

    public interface androidx.lifecycle.z.b {
        y a(Class arg1);

        y b(Class arg1, x.a arg2);
    }

    public static abstract class c implements androidx.lifecycle.z.b {
        public static final class androidx.lifecycle.z.c.a {
            static final class androidx.lifecycle.z.c.a.a implements b {
                public static final androidx.lifecycle.z.c.a.a a;

                static {
                    androidx.lifecycle.z.c.a.a.a = new androidx.lifecycle.z.c.a.a();
                }
            }

            private androidx.lifecycle.z.c.a() {
            }

            public androidx.lifecycle.z.c.a(d d0) {
            }
        }

        public static final androidx.lifecycle.z.c.a a;
        public static final b b;

        static {
            c.a = new androidx.lifecycle.z.c.a(null);
            c.b = androidx.lifecycle.z.c.a.a.a;
        }
    }

    private final c0 a;
    private final androidx.lifecycle.z.b b;
    private final x.a c;

    public z(c0 c00, androidx.lifecycle.z.b z$b0) {
        f.e(c00, "store");
        f.e(z$b0, "factory");
        this(c00, z$b0, null, 4, null);
    }

    public z(c0 c00, androidx.lifecycle.z.b z$b0, x.a a0) {
        f.e(c00, "store");
        f.e(z$b0, "factory");
        f.e(a0, "defaultCreationExtras");
        super();
        this.a = c00;
        this.b = z$b0;
        this.c = a0;
    }

    public z(c0 c00, androidx.lifecycle.z.b z$b0, x.a a0, int v, d d0) {
        if((v & 4) != 0) {
            a0 = x.a.a.b;
        }
        this(c00, z$b0, a0);
    }

    public z(d0 d00, androidx.lifecycle.z.b z$b0) {
        f.e(d00, "owner");
        f.e(z$b0, "factory");
        c0 c00 = d00.l();
        f.d(c00, "owner.viewModelStore");
        this(c00, z$b0, b0.a(d00));
    }

    public y a(Class class0) {
        f.e(class0, "modelClass");
        String s = class0.getCanonicalName();
        if(s == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return this.b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + s, class0);
    }

    public y b(String s, Class class0) {
        y y1;
        f.e(s, "key");
        f.e(class0, "modelClass");
        y y0 = this.a.b(s);
        if(class0.isInstance(y0)) {
            if(y0 == null) {
                throw new NullPointerException("null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            }
            return y0;
        }
        x.d d0 = new x.d(this.c);
        d0.b(c.b, s);
        try {
            y1 = this.b.b(class0, d0);
        }
        catch(AbstractMethodError unused_ex) {
            y1 = this.b.a(class0);
        }
        this.a.d(s, y1);
        return y1;
    }
}

