package c3;

import java.util.Collection;
import k3.f;

abstract class j extends i {
    public static int f(Iterable iterable0, int v) {
        f.e(iterable0, "<this>");
        return iterable0 instanceof Collection ? ((Collection)iterable0).size() : v;
    }
}

