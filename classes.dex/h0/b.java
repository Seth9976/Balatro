package h0;

public final class b {
    private final String a;

    private b(String s) {
        if(s == null) {
            throw new NullPointerException("name is null");
        }
        this.a = s;
    }

    public String a() {
        return this.a;
    }

    public static b b(String s) {
        return new b(s);
    }

    @Override
    public boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof b ? this.a.equals(((b)object0).a) : false;
    }

    @Override
    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    @Override
    public String toString() {
        return "Encoding{name=\"" + this.a + "\"}";
    }
}

