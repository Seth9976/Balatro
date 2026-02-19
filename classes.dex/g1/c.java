package g1;

public abstract class c {
    public static void a(Object object0) {
        if(object0 == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    public static void b(boolean z) {
        if(!z) {
            throw new IllegalStateException();
        }
    }
}

