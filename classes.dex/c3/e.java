package c3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import k3.f;

abstract class e extends d {
    public static List b(Object[] arr_object) {
        f.e(arr_object, "<this>");
        return (List)e.c(arr_object, new ArrayList());
    }

    public static final Collection c(Object[] arr_object, Collection collection0) {
        f.e(arr_object, "<this>");
        f.e(collection0, "destination");
        for(int v = 0; v < arr_object.length; ++v) {
            Object object0 = arr_object[v];
            if(object0 != null) {
                collection0.add(object0);
            }
        }
        return collection0;
    }

    public static char d(char[] arr_c) {
        f.e(arr_c, "<this>");
        switch(arr_c.length) {
            case 0: {
                throw new NoSuchElementException("Array is empty.");
            }
            case 1: {
                return arr_c[0];
            }
            default: {
                throw new IllegalArgumentException("Array has more than one element.");
            }
        }
    }

    public static Object e(Object[] arr_object) {
        f.e(arr_object, "<this>");
        return arr_object.length == 1 ? arr_object[0] : null;
    }
}

