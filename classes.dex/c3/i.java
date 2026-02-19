package c3;

import java.util.List;
import k3.f;

abstract class i extends h {
    public static final List b() {
        return s.e;
    }

    public static List c(Object[] arr_object) {
        f.e(arr_object, "elements");
        return arr_object.length <= 0 ? i.b() : d.a(arr_object);
    }

    public static List d(List list0) {
        f.e(list0, "<this>");
        switch(list0.size()) {
            case 0: {
                return i.b();
            }
            case 1: {
                return h.a(list0.get(0));
            }
            default: {
                return list0;
            }
        }
    }

    public static void e() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}

