package c3;

import java.util.Collection;
import k3.f;

abstract class n extends m {
    public static boolean g(Collection collection0, Iterable iterable0) {
        f.e(collection0, "<this>");
        f.e(iterable0, "elements");
        if(iterable0 instanceof Collection) {
            return collection0.addAll(((Collection)iterable0));
        }
        boolean z = false;
        for(Object object0: iterable0) {
            if(collection0.add(object0)) {
                z = true;
            }
        }
        return z;
    }
}

