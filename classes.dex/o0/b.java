package o0;

public abstract class b {
    public static Object a(int v, Object object0, a a0, c c0) {
        Object object1;
        if(v < 1) {
            return a0.a(object0);
        }
        do {
            object1 = a0.a(object0);
            object0 = c0.a(object0, object1);
            if(object0 == null) {
                break;
            }
            --v;
        }
        while(v >= 1);
        return object1;
    }
}

