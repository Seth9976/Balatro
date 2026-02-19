package r3;

public abstract class g {
    public static final String a(Object object0) {
        return object0.getClass().getSimpleName();
    }

    public static final String b(Object object0) {
        return Integer.toHexString(System.identityHashCode(object0));
    }
}

