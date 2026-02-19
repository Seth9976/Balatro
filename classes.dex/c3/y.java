package c3;

import b3.h;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.Map;
import k3.f;

abstract class y extends x {
    public static int a(int v) {
        if(v >= 0) {
            if(v < 3) {
                return v + 1;
            }
            return v >= 0x40000000 ? 0x7FFFFFFF : ((int)(((float)v) / 0.75f + 1.0f));
        }
        return v;
    }

    public static final Map b(h h0) {
        f.e(h0, "pair");
        Map map0 = Collections.singletonMap(h0.c(), h0.d());
        f.d(map0, "singletonMap(pair.first, pair.second)");
        return map0;
    }

    public static final Map c(Map map0) {
        f.e(map0, "<this>");
        Object object0 = map0.entrySet().iterator().next();
        Map map1 = Collections.singletonMap(((Map.Entry)object0).getKey(), ((Map.Entry)object0).getValue());
        f.d(map1, "with(entries.iterator().…ingletonMap(key, value) }");
        return map1;
    }
}

