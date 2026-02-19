package j0;

import java.util.Arrays;

final class d extends o {
    static abstract class a {
    }

    static final class b extends j0.o.a {
        private String a;
        private byte[] b;
        private h0.d c;

        @Override  // j0.o$a
        public o a() {
            String s = this.a == null ? " backendName" : "";
            if(this.c == null) {
                s = s + " priority";
            }
            if(!s.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + s);
            }
            return new d(this.a, this.b, this.c, null);
        }

        @Override  // j0.o$a
        public j0.o.a b(String s) {
            if(s == null) {
                throw new NullPointerException("Null backendName");
            }
            this.a = s;
            return this;
        }

        @Override  // j0.o$a
        public j0.o.a c(byte[] arr_b) {
            this.b = arr_b;
            return this;
        }

        @Override  // j0.o$a
        public j0.o.a d(h0.d d0) {
            if(d0 == null) {
                throw new NullPointerException("Null priority");
            }
            this.c = d0;
            return this;
        }
    }

    private final String a;
    private final byte[] b;
    private final h0.d c;

    private d(String s, byte[] arr_b, h0.d d0) {
        this.a = s;
        this.b = arr_b;
        this.c = d0;
    }

    d(String s, byte[] arr_b, h0.d d0, a d$a0) {
        this(s, arr_b, d0);
    }

    @Override  // j0.o
    public String b() {
        return this.a;
    }

    @Override  // j0.o
    public byte[] c() {
        return this.b;
    }

    @Override  // j0.o
    public h0.d d() {
        return this.c;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof o) {
            String s = ((o)object0).b();
            if(this.a.equals(s)) {
                byte[] arr_b = ((o)object0) instanceof d ? ((d)(((o)object0))).b : ((o)object0).c();
                if(Arrays.equals(this.b, arr_b)) {
                    h0.d d0 = ((o)object0).d();
                    return this.c.equals(d0);
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int v = Arrays.hashCode(this.b);
        return ((this.a.hashCode() ^ 1000003) * 1000003 ^ v) * 1000003 ^ this.c.hashCode();
    }
}

