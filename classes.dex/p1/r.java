package p1;

import com.google.android.gms.common.api.Status;
import g2.h;
import v1.e;
import v1.g;

public interface r {
    public static final class a {
        private final Object a;
        private final b b;

        public a(Object object0, b r$b0) {
            this.a = object0;
            this.b = r$b0;
        }

        public b a() {
            if(!this.c()) {
                throw new IllegalStateException("getConflict called when there is no conflict.");
            }
            return this.b;
        }

        public Object b() {
            if(this.c()) {
                throw new IllegalStateException("getData called when there is a conflict.");
            }
            return this.a;
        }

        public boolean c() {
            return this.b != null;
        }
    }

    public static final class b {
        private final v1.a a;
        private final String b;
        private final v1.a c;
        private final v1.b d;

        public b(v1.a a0, String s, v1.a a1, v1.b b0) {
            this.a = a0;
            this.b = s;
            this.c = a1;
            this.d = b0;
        }

        public String a() {
            return this.b;
        }

        public v1.a b() {
            return this.c;
        }

        public v1.b c() {
            return this.d;
        }

        public v1.a d() {
            return this.a;
        }
    }

    public static final class c extends d1.b {
        protected final e f;

        public c(Status status0, e e0) {
            super(status0);
            this.f = e0;
        }
    }

    h a(v1.a arg1);

    h b(v1.a arg1, g arg2);

    h c(String arg1, String arg2, g arg3, v1.b arg4);

    h d(String arg1, boolean arg2, int arg3);
}

