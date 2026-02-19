package c3;

import b3.h;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k3.f;

abstract class z extends y {
    public static Map d() {
        f.c(t.e, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return t.e;
    }

    public static final Map e(Map map0) {
        f.e(map0, "<this>");
        switch(map0.size()) {
            case 0: {
                return z.d();
            }
            case 1: {
                return y.c(map0);
            }
            default: {
                return map0;
            }
        }
    }

    public static final void f(Map map0, Iterable iterable0) {
        f.e(map0, "<this>");
        f.e(iterable0, "pairs");
        for(Object object0: iterable0) {
            map0.put(((h)object0).a(), ((h)object0).b());
        }
    }

    public static Map g(Iterable iterable0) {
        f.e(iterable0, "<this>");
        if(iterable0 instanceof Collection) {
            switch(((Collection)iterable0).size()) {
                case 0: {
                    return z.d();
                }
                case 1: {
                    if(iterable0 instanceof List) {
                        return y.b(((h)((List)iterable0).get(0)));
                    }
                    Object object0 = iterable0.iterator().next();
                    return y.b(((h)object0));
                }
                default: {
                    return z.h(iterable0, new LinkedHashMap(y.a(((Collection)iterable0).size())));
                }
            }
        }
        return z.e(z.h(iterable0, new LinkedHashMap()));
    }

    public static final Map h(Iterable iterable0, Map map0) {
        f.e(iterable0, "<this>");
        f.e(map0, "destination");
        z.f(map0, iterable0);
        return map0;
    }
}

