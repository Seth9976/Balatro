package c3;

import java.util.Set;
import k3.f;

abstract class e0 extends d0 {
    public static Set b() {
        return u.e;
    }

    public static final Set c(Set set0) {
        f.e(set0, "<this>");
        switch(set0.size()) {
            case 0: {
                return e0.b();
            }
            case 1: {
                Object object0 = set0.iterator().next();
                return d0.a(object0);
            }
            default: {
                return set0;
            }
        }
    }
}

