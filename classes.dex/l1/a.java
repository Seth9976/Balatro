package l1;

import g1.o;

public abstract class a {
    public static boolean a(int[] arr_v, int v) {
        if(arr_v != null) {
            for(int v1 = 0; v1 < arr_v.length; ++v1) {
                if(arr_v[v1] == v) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(Object[] arr_object, Object object0) {
        int v = arr_object == null ? 0 : arr_object.length;
        for(int v1 = 0; v1 < v; ++v1) {
            if(o.a(arr_object[v1], object0)) {
                return v1 >= 0;
            }
        }
        return false;
    }
}

