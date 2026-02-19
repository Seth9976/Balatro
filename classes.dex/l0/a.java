package l0;

public final class a implements a3.a {
    private volatile a3.a a;
    private volatile Object b;
    private static final Object c;

    static {
        a.c = new Object();
    }

    private a(a3.a a0) {
        this.b = a.c;
        this.a = a0;
    }

    public static a3.a a(a3.a a0) {
        d.b(a0);
        return a0 instanceof a ? a0 : new a(a0);
    }

    public static Object b(Object object0, Object object1) {
        if(object0 != a.c && object0 != object1) {
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + object0 + " & " + object1 + ". This is likely due to a circular dependency.");
        }
        return object1;
    }

    @Override  // a3.a
    public Object get() {
        Object object0 = this.b;
        Object object1 = a.c;
        if(object0 == object1) {
            synchronized(this) {
                object0 = this.b;
                if(object0 == object1) {
                    object0 = this.a.get();
                    this.b = a.b(this.b, object0);
                    this.a = null;
                }
                return object0;
            }
        }
        return object0;
    }
}

