package b3;

import java.io.Serializable;
import k3.d;
import k3.f;

public abstract class i implements Serializable {
    public static final class a {
        private a() {
        }

        public a(d d0) {
        }
    }

    public static final class b implements Serializable {
        public final Throwable e;

        public b(Throwable throwable0) {
            f.e(throwable0, "exception");
            super();
            this.e = throwable0;
        }

        // 去混淆评级： 低(20)
        @Override
        public boolean equals(Object object0) {
            return object0 instanceof b && f.a(this.e, ((b)object0).e);
        }

        @Override
        public int hashCode() {
            return this.e.hashCode();
        }

        @Override
        public String toString() {
            return "Failure(" + this.e + ')';
        }
    }

    public static final a e;

    static {
        i.e = new a(null);
    }

    public static Object a(Object object0) {
        return object0;
    }

    public static final boolean b(Object object0) {
        return object0 instanceof b;
    }

    public static final boolean c(Object object0) {
        return !(object0 instanceof b);
    }
}

