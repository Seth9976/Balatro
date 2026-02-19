package i2;

import java.lang.reflect.Array;
import java.util.Arrays;

abstract class g {
    static Object[] a(Object[] arr_object, int v, int v1, Object[] arr_object1) {
        return Arrays.copyOfRange(arr_object, v, v1, arr_object1.getClass());
    }

    static Object[] b(Object[] arr_object, int v) {
        return (Object[])Array.newInstance(arr_object.getClass().getComponentType(), v);
    }
}

