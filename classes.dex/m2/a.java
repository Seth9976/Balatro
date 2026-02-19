package m2;

public final class a {
    static final class m2.a.a implements d {
        private final int a;
        private final m2.d.a b;

        m2.a.a(int v, m2.d.a d$a0) {
            this.a = v;
            this.b = d$a0;
        }

        @Override
        public Class annotationType() {
            return d.class;
        }

        @Override
        public boolean equals(Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof d)) {
                return false;
            }
            int v = ((d)object0).tag();
            if(this.a == v) {
                m2.d.a d$a0 = ((d)object0).intEncoding();
                return this.b.equals(d$a0);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (0xDE0D66 ^ this.a) + (this.b.hashCode() ^ 2041407134);
        }

        @Override  // m2.d
        public m2.d.a intEncoding() {
            return this.b;
        }

        @Override  // m2.d
        public int tag() {
            return this.a;
        }

        @Override
        public String toString() {
            return "@com.google.firebase.encoders.proto.Protobuf" + '(' + "tag=" + this.a + "intEncoding=" + this.b + ')';
        }
    }

    private int a;
    private m2.d.a b;

    public a() {
        this.b = m2.d.a.e;
    }

    public d a() {
        return new m2.a.a(this.a, this.b);
    }

    public static a b() {
        return new a();
    }

    public a c(int v) {
        this.a = v;
        return this;
    }
}

