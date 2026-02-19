package i2;

import h2.b;
import h2.c;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class e {
    static boolean a(List list0, Object object0) {
        if(object0 == c.f(list0)) {
            return true;
        }
        if(!(object0 instanceof List)) {
            return false;
        }
        int v = list0.size();
        if(v != ((List)object0).size()) {
            return false;
        }
        if(list0 instanceof RandomAccess && ((List)object0) instanceof RandomAccess) {
            for(int v1 = 0; v1 < v; ++v1) {
                if(!b.a(list0.get(v1), ((List)object0).get(v1))) {
                    return false;
                }
            }
            return true;
        }
        return d.a(list0.iterator(), ((List)object0).iterator());
    }

    static int b(List list0, Object object0) {
        if(list0 instanceof RandomAccess) {
            return e.c(list0, object0);
        }
        ListIterator listIterator0 = list0.listIterator();
        while(listIterator0.hasNext()) {
            if(b.a(object0, listIterator0.next())) {
                return listIterator0.previousIndex();
            }
            if(false) {
                break;
            }
        }
        return -1;
    }

    private static int c(List list0, Object object0) {
        int v = list0.size();
        int v1 = 0;
        if(object0 == null) {
            while(v1 < v) {
                if(list0.get(v1) == null) {
                    return v1;
                }
                ++v1;
            }
            return -1;
        }
        while(v1 < v) {
            if(object0.equals(list0.get(v1))) {
                return v1;
            }
            ++v1;
        }
        return -1;
    }

    static int d(List list0, Object object0) {
        if(list0 instanceof RandomAccess) {
            return e.e(list0, object0);
        }
        ListIterator listIterator0 = list0.listIterator(list0.size());
        while(listIterator0.hasPrevious()) {
            if(b.a(object0, listIterator0.previous())) {
                return listIterator0.nextIndex();
            }
            if(false) {
                break;
            }
        }
        return -1;
    }

    private static int e(List list0, Object object0) {
        if(object0 == null) {
            for(int v = list0.size() - 1; v >= 0; --v) {
                if(list0.get(v) == null) {
                    return v;
                }
            }
            return -1;
        }
        for(int v1 = list0.size() - 1; v1 >= 0; --v1) {
            if(object0.equals(list0.get(v1))) {
                return v1;
            }
        }
        return -1;
    }
}

