package l0;

public abstract class d {
    public static void a(Object object0, Class class0) {
        if(object0 == null) {
            throw new IllegalStateException(class0.getCanonicalName() + " must be set");
        }
    }

    public static Object b(Object object0) {
        object0.getClass();
        return object0;
    }

    public static Object c(Object object0, String s) {
        if(object0 == null) {
            throw new NullPointerException(s);
        }
        return object0;
    }
}

