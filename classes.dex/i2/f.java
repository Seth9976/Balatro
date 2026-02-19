package i2;

public abstract class f {
    static Object a(Object object0, int v) {
        if(object0 == null) {
            throw new NullPointerException("at index " + v);
        }
        return object0;
    }

    static Object[] b(Object[] arr_object) {
        return f.c(arr_object, arr_object.length);
    }

    static Object[] c(Object[] arr_object, int v) {
        for(int v1 = 0; v1 < v; ++v1) {
            f.a(arr_object[v1], v1);
        }
        return arr_object;
    }

    public static Object[] d(Object[] arr_object, int v) {
        return g.b(arr_object, v);
    }
}

