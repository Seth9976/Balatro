package androidx.core.content.res;

import java.lang.reflect.Array;

abstract class g {
    public static int[] a(int[] arr_v, int v, int v1) {
        if(v + 1 > arr_v.length) {
            int[] arr_v1 = new int[g.c(v)];
            System.arraycopy(arr_v, 0, arr_v1, 0, v);
            arr_v = arr_v1;
        }
        arr_v[v] = v1;
        return arr_v;
    }

    public static Object[] b(Object[] arr_object, int v, Object object0) {
        if(v + 1 > arr_object.length) {
            Object[] arr_object1 = (Object[])Array.newInstance(arr_object.getClass().getComponentType(), g.c(v));
            System.arraycopy(arr_object, 0, arr_object1, 0, v);
            arr_object = arr_object1;
        }
        arr_object[v] = object0;
        return arr_object;
    }

    public static int c(int v) {
        return v > 4 ? v * 2 : 8;
    }
}

