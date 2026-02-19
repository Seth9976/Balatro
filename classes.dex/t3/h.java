package t3;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import p3.f;
import r3.v;

public final class h {
    public static final h a;
    private static final boolean b;
    public static final v c;

    static {
        h h0 = new h();
        h.a = h0;
        m.e("kotlinx.coroutines.fast.service.loader", true);
        h.c = h0.a();
    }

    private final v a() {
        Object object0;
        try {
            List list0 = h.b ? a.a.c() : p3.h.d(f.a(ServiceLoader.load(g.class, g.class.getClassLoader()).iterator()));
            Iterator iterator0 = list0.iterator();
            if(iterator0.hasNext()) {
                object0 = iterator0.next();
                if(iterator0.hasNext()) {
                    int v = ((g)object0).getLoadPriority();
                    while(true) {
                        Object object1 = iterator0.next();
                        int v1 = ((g)object1).getLoadPriority();
                        if(v < v1) {
                            object0 = object1;
                            v = v1;
                        }
                        if(!iterator0.hasNext()) {
                            break;
                        }
                    }
                }
            }
            else {
                object0 = null;
            }
            v v2 = ((g)object0) == null ? null : i.e(((g)object0), list0);
            return v2 == null ? i.b(null, null, 3, null) : v2;
        }
        catch(Throwable throwable0) {
            return i.b(throwable0, null, 2, null);
        }
    }
}

