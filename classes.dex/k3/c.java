package k3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class c {
    private static final Object[] a;

    static {
        c.a = new Object[0];
    }

    public static final Object[] a(Collection collection0) {
        f.e(collection0, "collection");
        int v = collection0.size();
        if(v != 0) {
            Iterator iterator0 = collection0.iterator();
            if(iterator0.hasNext()) {
                Object[] arr_object = new Object[v];
                for(int v1 = 0; true; ++v1) {
                    Object object0 = iterator0.next();
                    arr_object[v1] = object0;
                    if(v1 + 1 >= arr_object.length) {
                        if(!iterator0.hasNext()) {
                            return arr_object;
                        }
                        int v2 = (v1 + 1) * 3 + 1 >>> 1;
                        if(v2 <= v1 + 1 && v1 + 1 >= 0x7FFFFFFD) {
                            throw new OutOfMemoryError();
                        }
                        arr_object = Arrays.copyOf(arr_object, v2);
                        f.d(arr_object, "copyOf(result, newSize)");
                    }
                    else if(!iterator0.hasNext()) {
                        Object[] arr_object1 = Arrays.copyOf(arr_object, v1 + 1);
                        f.d(arr_object1, "copyOf(result, size)");
                        return arr_object1;
                    }
                }
            }
        }
        return c.a;
    }

    public static final Object[] b(Collection collection0, Object[] arr_object) {
        Object[] arr_object1;
        f.e(collection0, "collection");
        arr_object.getClass();
        int v = collection0.size();
        if(v == 0) {
            if(arr_object.length <= 0) {
                return arr_object;
            }
            arr_object[0] = null;
            return arr_object;
        }
        Iterator iterator0 = collection0.iterator();
        if(!iterator0.hasNext()) {
            if(arr_object.length > 0) {
                arr_object[0] = null;
                return arr_object;
            }
            return arr_object;
        }
        if(v <= arr_object.length) {
            arr_object1 = arr_object;
        }
        else {
            Object object0 = Array.newInstance(arr_object.getClass().getComponentType(), v);
            f.c(object0, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            arr_object1 = (Object[])object0;
        }
        for(int v1 = 0; true; ++v1) {
            Object object1 = iterator0.next();
            arr_object1[v1] = object1;
            if(v1 + 1 >= arr_object1.length) {
                if(!iterator0.hasNext()) {
                    return arr_object1;
                }
                int v2 = (v1 + 1) * 3 + 1 >>> 1;
                if(v2 <= v1 + 1 && v1 + 1 >= 0x7FFFFFFD) {
                    throw new OutOfMemoryError();
                }
                arr_object1 = Arrays.copyOf(arr_object1, v2);
                f.d(arr_object1, "copyOf(result, newSize)");
            }
            else if(!iterator0.hasNext()) {
                if(arr_object1 == arr_object) {
                    arr_object[v1 + 1] = null;
                    return arr_object;
                }
                Object[] arr_object2 = Arrays.copyOf(arr_object1, v1 + 1);
                f.d(arr_object2, "copyOf(result, size)");
                return arr_object2;
            }
        }
    }
}

