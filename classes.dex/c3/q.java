package c3;

import b3.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k3.f;

abstract class q extends p {
    public static boolean h(Iterable iterable0, Object object0) {
        f.e(iterable0, "<this>");
        return iterable0 instanceof Collection ? ((Collection)iterable0).contains(object0) : q.i(iterable0, object0) >= 0;
    }

    public static final int i(Iterable iterable0, Object object0) {
        f.e(iterable0, "<this>");
        if(iterable0 instanceof List) {
            return ((List)iterable0).indexOf(object0);
        }
        int v = 0;
        for(Object object1: iterable0) {
            if(v < 0) {
                i.e();
            }
            if(f.a(object0, object1)) {
                return v;
            }
            ++v;
        }
        return -1;
    }

    public static final Collection j(Iterable iterable0, Collection collection0) {
        f.e(iterable0, "<this>");
        f.e(collection0, "destination");
        for(Object object0: iterable0) {
            collection0.add(object0);
        }
        return collection0;
    }

    public static List k(Iterable iterable0) {
        f.e(iterable0, "<this>");
        if(iterable0 instanceof Collection) {
            switch(((Collection)iterable0).size()) {
                case 0: {
                    return i.b();
                }
                case 1: {
                    if(iterable0 instanceof List) {
                        return h.a(((List)iterable0).get(0));
                    }
                    Object object0 = iterable0.iterator().next();
                    return h.a(object0);
                }
                default: {
                    return q.m(((Collection)iterable0));
                }
            }
        }
        return i.d(q.l(iterable0));
    }

    public static final List l(Iterable iterable0) {
        f.e(iterable0, "<this>");
        return iterable0 instanceof Collection ? q.m(((Collection)iterable0)) : ((List)q.j(iterable0, new ArrayList()));
    }

    public static final List m(Collection collection0) {
        f.e(collection0, "<this>");
        return new ArrayList(collection0);
    }

    public static Set n(Iterable iterable0) {
        f.e(iterable0, "<this>");
        if(iterable0 instanceof Collection) {
            switch(((Collection)iterable0).size()) {
                case 0: {
                    return e0.b();
                }
                case 1: {
                    if(iterable0 instanceof List) {
                        return d0.a(((List)iterable0).get(0));
                    }
                    Object object0 = iterable0.iterator().next();
                    return d0.a(object0);
                }
                default: {
                    return (Set)q.j(iterable0, new LinkedHashSet(y.a(((Collection)iterable0).size())));
                }
            }
        }
        return e0.c(((Set)q.j(iterable0, new LinkedHashSet())));
    }

    public static List o(Iterable iterable0, Iterable iterable1) {
        f.e(iterable0, "<this>");
        f.e(iterable1, "other");
        Iterator iterator0 = iterable0.iterator();
        Iterator iterator1 = iterable1.iterator();
        List list0 = new ArrayList(Math.min(j.f(iterable0, 10), j.f(iterable1, 10)));
        while(iterator0.hasNext() && iterator1.hasNext()) {
            Object object0 = iterator0.next();
            Object object1 = iterator1.next();
            ((ArrayList)list0).add(l.a(object0, object1));
        }
        return list0;
    }
}

