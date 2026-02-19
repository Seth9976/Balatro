package p3;

import c3.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k3.f;

abstract class h extends g {
    public static final Collection c(b b0, Collection collection0) {
        f.e(b0, "<this>");
        f.e(collection0, "destination");
        for(Object object0: b0) {
            collection0.add(object0);
        }
        return collection0;
    }

    public static List d(b b0) {
        f.e(b0, "<this>");
        return i.d(h.e(b0));
    }

    public static final List e(b b0) {
        f.e(b0, "<this>");
        return (List)h.c(b0, new ArrayList());
    }
}

