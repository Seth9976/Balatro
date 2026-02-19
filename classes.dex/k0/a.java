package k0;

import java.util.Arrays;

final class a extends f {
    static abstract class k0.a.a {
    }

    static final class b extends k0.f.a {
        private Iterable a;
        private byte[] b;

        @Override  // k0.f$a
        public f a() {
            String s = this.a == null ? " events" : "";
            if(!s.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + s);
            }
            return new a(this.a, this.b, null);
        }

        @Override  // k0.f$a
        public k0.f.a b(Iterable iterable0) {
            if(iterable0 == null) {
                throw new NullPointerException("Null events");
            }
            this.a = iterable0;
            return this;
        }

        @Override  // k0.f$a
        public k0.f.a c(byte[] arr_b) {
            this.b = arr_b;
            return this;
        }
    }

    private final Iterable a;
    private final byte[] b;

    private a(Iterable iterable0, byte[] arr_b) {
        this.a = iterable0;
        this.b = arr_b;
    }

    a(Iterable iterable0, byte[] arr_b, k0.a.a a$a0) {
        this(iterable0, arr_b);
    }

    @Override  // k0.f
    public Iterable b() {
        return this.a;
    }

    @Override  // k0.f
    public byte[] c() {
        return this.b;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof f) {
            Iterable iterable0 = ((f)object0).b();
            if(this.a.equals(iterable0)) {
                byte[] arr_b = ((f)object0) instanceof a ? ((a)(((f)object0))).b : ((f)object0).c();
                return Arrays.equals(this.b, arr_b);
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = Arrays.hashCode(this.b);
        return (this.a.hashCode() ^ 1000003) * 1000003 ^ v;
    }

    @Override
    public String toString() {
        return "BackendRequest{events=" + this.a + ", extras=" + Arrays.toString(this.b) + "}";
    }
}

